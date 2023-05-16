package plugin.livealerts.PlatformEvents.YouTubeEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Utilities.MessageType;

public class SubscribeEvent {

    MessageType messageType = new MessageType();
    public void onSubscribeEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("youtube.subscribeMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }

}
