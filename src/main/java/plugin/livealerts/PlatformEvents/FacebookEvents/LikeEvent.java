package plugin.livealerts.PlatformEvents.FacebookEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class LikeEvent {

    MessageType messageType = new MessageType();
    public void onLikeEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("facebook.likeMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}