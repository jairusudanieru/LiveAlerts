package plugin.livealerts.MessageTypes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.SoundAlert;

public class SendBroadcast {

    SoundAlert soundAlert = new SoundAlert();

    //Using the broadcast to send the event message
    public void sendBroadcast(JavaPlugin plugin, String message) {
        Server server = plugin.getServer();
        String audience = plugin.getConfig().getString("audienceType");
        String streamer = plugin.getConfig().getString("streamerUsername");
        if (audience == null || audience.isEmpty()) return;

        //Checking the message audience
        if (audience.equalsIgnoreCase("everyone")) {
            TextComponent component = Component.text(message);
            server.broadcast(component);
            soundAlert.onEveryone(plugin);
            Bukkit.getLogger().info(message);
        } else if (audience.equalsIgnoreCase("streamerOnly")) {
            if (streamer == null) return;
            Player player = Bukkit.getPlayerExact(streamer);
            if (player == null || !player.isOnline()) return;
            player.sendMessage(message);
            soundAlert.onStreamerOnly(plugin);
            Bukkit.getLogger().info(message);
        } else {
            Bukkit.getLogger().severe("[LiveAlerts] The \"" + audience + "\" audience type is invalid!");
            Bukkit.getLogger().severe("[LiveAlerts] Audience types: \"everyone\",\"streamerOnly\"!");
            Bukkit.getLogger().severe("[LiveAlerts] Please fix your config.yml!");
        }
    }

}
