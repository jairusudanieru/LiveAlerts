package plugin.livealerts.PlatformEvents.TwitchEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class BitsEvent {

    MessageType messageType = new MessageType();
    public void onBitsEvent(JavaPlugin plugin, String name, String amount) {
        String message = plugin.getConfig().getString("twitch.bitsMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name).replace("%amount%",amount);
        messageType.messageType(plugin, message);
    }
}