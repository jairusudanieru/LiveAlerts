package plugin.livealerts.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.MessageTypes.SendActionBar;
import plugin.livealerts.MessageTypes.SendBossBar;
import plugin.livealerts.MessageTypes.SendBroadcast;

public class MessageType {

    SendActionBar sendActionBar = new SendActionBar();
    SendBossBar sendBossBar = new SendBossBar();
    SendBroadcast sendBroadcast = new SendBroadcast();

    public void messageType(JavaPlugin plugin, String message) {
        String messageType = plugin.getConfig().getString("messageType");
        if (messageType == null || messageType.isEmpty()) return;

        //Checking the message type of the alert
        switch (messageType) {
            case "actionBar":
                sendActionBar.sendActionBar(plugin, message);
                break;
            case "bossBar":
                sendBossBar.sendBossBar(plugin, message);
                break;
            case "broadcast":
                sendBroadcast.sendBroadcast(plugin, message);
                break;
            default:
                Bukkit.getLogger().severe("[LiveAlerts] The \"" + messageType + "\" message type is invalid!");
                Bukkit.getLogger().severe("[LiveAlerts] Message types: \"broadcast\",\"bossBar\",\"actionBar\"!");
                Bukkit.getLogger().severe("[LiveAlerts] Please fix your config.yml!");
                break;
        }
    }
}
