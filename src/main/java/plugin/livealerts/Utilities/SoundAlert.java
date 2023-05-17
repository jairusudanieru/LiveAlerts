package plugin.livealerts.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundAlert {

    public void onEveryone(JavaPlugin plugin) {
        boolean enabled = plugin.getConfig().getBoolean("soundOnAlert");

        if (!enabled) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
        }
    }

    public void onStreamerOnly(JavaPlugin plugin) {
        boolean enabled = plugin.getConfig().getBoolean("soundOnAlert");
        String streamer = plugin.getConfig().getString("streamerUsername");

        if (!enabled || streamer == null) return;
        Player player = Bukkit.getPlayerExact(streamer);
        if (player == null) return;
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
    }
}
