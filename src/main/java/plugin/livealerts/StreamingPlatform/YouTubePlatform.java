package plugin.livealerts.StreamingPlatform;

import io.socket.client.IO;
import io.socket.client.Socket;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;
import plugin.livealerts.PlatformEvents.YouTubeEvents.ChannelMemberEvent;
import plugin.livealerts.PlatformEvents.YouTubeEvents.SubscribeEvent;
import plugin.livealerts.PlatformEvents.YouTubeEvents.SuperChatEvent;

public class YouTubePlatform {

    ChannelMemberEvent channelMemberEvent = new ChannelMemberEvent();
    SubscribeEvent subscribeEvent = new SubscribeEvent();
    SuperChatEvent superChatEvent = new SuperChatEvent();

    public void onYouTubeEvent(JavaPlugin plugin) {
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
            if (streamData.has("for") && streamData.getString("for").equals("youtube_account")) {
                JSONArray messageArray = streamData.getJSONArray("message");
                String name = "user"; int amounts = 0;
                for (int i = 0; i < messageArray.length(); i++) {
                    JSONObject messageObj = messageArray.getJSONObject(i);
                    try { name = messageObj.getString("name"); } catch (Exception ignored) {}
                    try { amounts = messageObj.getInt("amount"); } catch (Exception ignored) {}
                }
                switch (streamData.getString("type")) {
                    case "follow":
                        subscribeEvent.onSubscribeEvent(plugin, name);
                        break;
                    case "subscription":
                        channelMemberEvent.onChannelMemberEvent(plugin, name);
                        break;
                    case "superchat":
                        superChatEvent.onSuperChatEvent(plugin, name, amounts);
                        break;
                }
            }
        });
        socket.connect();
        Bukkit.getLogger().info("[LiveAlerts] Plugin successfully enabled!");
    }

}
