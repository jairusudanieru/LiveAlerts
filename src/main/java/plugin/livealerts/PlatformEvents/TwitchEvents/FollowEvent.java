package plugin.livealerts.PlatformEvents.TwitchEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class FollowEvent {

    MessageType messageType = new MessageType();
    public void onFollowEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("twitch.followMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}