package plugin.livealerts.PlatformEvents.TwitchEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class SubscriptionEvent {

    MessageType messageType = new MessageType();
    public void onSubscriptionEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("twitch.subscriptionMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }
}