package plugin.livealerts.PlatformEvents.FacebookEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class StarsEvent {

    MessageType messageType = new MessageType();
    public void onStarsEvent(JavaPlugin plugin, String name, String amount) {
        String message = plugin.getConfig().getString("facebook.starsMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name).replace("%amount%",amount);
        messageType.messageType(plugin, message);
    }
}