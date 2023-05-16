package plugin.livealerts.PlatformEvents.FacebookEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class FollowEvent {

    MessageType messageType = new MessageType();
    public void onFollowEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("facebook.followMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}