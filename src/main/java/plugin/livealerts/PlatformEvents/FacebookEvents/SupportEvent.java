package plugin.livealerts.PlatformEvents.FacebookEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class SupportEvent {

    MessageType messageType = new MessageType();
    public void onSupportEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("facebook.supportMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}