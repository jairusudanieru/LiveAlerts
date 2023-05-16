package plugin.livealerts.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.StreamingPlatform.FacebookPlatform;
import plugin.livealerts.StreamingPlatform.TwitchPlatform;
import plugin.livealerts.StreamingPlatform.YouTubePlatform;

public class PlatformType {

    FacebookPlatform facebookPlatform = new FacebookPlatform();
    TwitchPlatform twitchPlatform = new TwitchPlatform();
    YouTubePlatform youTubePlatform = new YouTubePlatform();

    public void platformType(JavaPlugin plugin) {
        String platform = plugin.getConfig().getString("streamingPlatform");
        if (platform == null || platform.isEmpty()) return;

        switch (platform) {
            case "facebook":
               facebookPlatform.onFacebookEvent(plugin);
               break;
            case "twitch":
                twitchPlatform.onTwitchEvent(plugin);
                break;
            case "youtube":
                youTubePlatform.onYouTubeEvent(plugin);
                break;
            default:
                Bukkit.getLogger().severe("[LiveAlerts] The \"" + platform + "\" streaming platform is invalid!");
                Bukkit.getLogger().severe("[LiveAlerts] Streaming platforms: \"twitch\",\"youtube\",\"facebook\"!");
                Bukkit.getLogger().severe("[LiveAlerts] Please fix your config.yml!");
                break;
        }
    }

}
