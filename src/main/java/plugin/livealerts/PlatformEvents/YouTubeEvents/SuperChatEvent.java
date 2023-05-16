package plugin.livealerts.PlatformEvents.YouTubeEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class SuperChatEvent {

    MessageType messageType = new MessageType();
    public void onSuperChatEvent(JavaPlugin plugin, String name, int amounts) {
        String amount = Integer.toString(amounts);
        String message = plugin.getConfig().getString("youtube.superChatMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name).replace("%amount%",amount);
        messageType.messageType(plugin, message);
    }

}
