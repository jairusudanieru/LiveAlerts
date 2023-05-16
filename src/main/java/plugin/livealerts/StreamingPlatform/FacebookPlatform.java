package plugin.livealerts.StreamingPlatform;

import io.socket.client.IO;
import io.socket.client.Socket;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;
import plugin.livealerts.PlatformEvents.FacebookEvents.*;

public class FacebookPlatform {

    FollowEvent followEvent = new FollowEvent();
    LikeEvent likeEvent = new LikeEvent();
    ShareEvent shareEvent = new ShareEvent();
    StarsEvent starsEvent = new StarsEvent();
    SupportEvent supportEvent = new SupportEvent();

    public void onFacebookEvent(JavaPlugin plugin) {
        Socket socket;
        String socketToken = plugin.getConfig().getString("socketToken");
        if (socketToken == null || socketToken.isEmpty()) return;
        try {
            socket = IO.socket("https://sockets.streamlabs.com?token=" + socketToken);
        } catch (Exception error) {
            Bukkit.getLogger().severe("[LiveAlerts] Failed to create socket: " + error.getMessage());
            Bukkit.getLogger().info("[LiveAlerts] Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(plugin);
            Bukkit.getLogger().info("[LiveAlerts] Plugin successfully disabled!");
            return;
        }

        socket.on("event", args -> {
            JSONObject streamData = (JSONObject) args[0];
            if (streamData.has("for") && streamData.getString("for").equals("facebook_account")) {
                JSONArray messageArray = streamData.getJSONArray("message");
                String name = "user", amount = "0";
                for (int i = 0; i < messageArray.length(); i++) {
                    JSONObject messageObj = messageArray.getJSONObject(i);
                    try { name = messageObj.getString("name"); } catch (Exception ignored) {}
                    try { amount = messageObj.getString("amount"); } catch (Exception ignored) {}
                }
                switch (streamData.getString("type")) {
                    case "follow":
                        followEvent.onFollowEvent(plugin, name);
                        break;
                    case "like":
                        likeEvent.onLikeEvent(plugin, name);
                        break;
                    case "share":
                        shareEvent.onShareEvent(plugin, name);
                        break;
                    case "stars":
                        starsEvent.onStarsEvent(plugin, name, amount);
                        break;
                    case "support":
                        supportEvent.onSupportEvent(plugin, name);
                        break;
                }
            }
        });
        socket.connect();
        Bukkit.getLogger().info("[LiveAlerts] Plugin successfully enabled!");
    }

}
