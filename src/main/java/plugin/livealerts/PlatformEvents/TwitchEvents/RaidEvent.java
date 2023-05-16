package plugin.livealerts.PlatformEvents.TwitchEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class RaidEvent {

    MessageType messageType = new MessageType();
    public void onRaidEvent(JavaPlugin plugin, String name, int raiders) {
        String raider = Integer.toString(raiders);
        String message = plugin.getConfig().getString("twitch.raidMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name).replace("%raiders%",raider);
        messageType.messageType(plugin, message);
    }
}