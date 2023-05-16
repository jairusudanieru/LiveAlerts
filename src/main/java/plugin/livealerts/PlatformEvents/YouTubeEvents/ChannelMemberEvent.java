package plugin.livealerts.PlatformEvents.YouTubeEvents;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.MessageType;

public class ChannelMemberEvent {

    MessageType messageType = new MessageType();
    public void onChannelMemberEvent(JavaPlugin plugin, String name) {
        String message = plugin.getConfig().getString("youtube.channelMemberMessage");
        if (message == null || message.isEmpty()) return;
        message = message.replace("%name%",name);
        messageType.messageType(plugin, message);
    }

}
