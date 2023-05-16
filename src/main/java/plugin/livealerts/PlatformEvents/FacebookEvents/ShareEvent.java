package plugin.livealerts.PlatformEvents.FacebookEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class ShareEvent {

    MessageType messageType = new MessageType();
    public void onShareEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("facebook.shareMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}