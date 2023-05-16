package plugin.livealerts.MessageTypes;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SendBossBar {

    public void checkBarColor(JavaPlugin plugin) {
        String barColor = plugin.getConfig().getString("bossBarColor");
        if (barColor == null || barColor.isEmpty()) barColor = "white";
    }

    //If the audience type is everyone, this void will run
    public void everyone(JavaPlugin plugin, String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            BossBar bossBar = Bukkit.createBossBar(message, BarColor.WHITE, BarStyle.SEGMENTED_10);
            bossBar.addPlayer(player);
            bossBar.setProgress(1.0);
            bossBar.setVisible(true);
            Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                double progress = bossBar.getProgress();
                if (progress > 0.3333) {
                    bossBar.setProgress(progress - 0.3333);
                } else {
                    bossBar.setVisible(false);
                    bossBar.removeAll();
                }
            }, 20L, 20L);
        }
    }

    //If the audience type is streamerOnly, this void will run
    public void streamerOnly(JavaPlugin plugin, String message, Player player) {
        if (player == null || !player.isOnline()) return;
        BossBar bossBar = Bukkit.createBossBar(message, BarColor.WHITE, BarStyle.SEGMENTED_10);
        bossBar.addPlayer(player);
        bossBar.setProgress(1.0);
        bossBar.setVisible(true);
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            double progress = bossBar.getProgress();
            if (progress > 0.3333) {
                bossBar.setProgress(progress - 0.3333);
            } else {
                bossBar.setVisible(false);
                bossBar.removeAll();
            }
        }, 20L, 20L);
    }

    //Using the bossBar to send the event message
    public void sendBossBar(JavaPlugin plugin, String message) {
        String audience = plugin.getConfig().getString("audienceType");
        String streamer = plugin.getConfig().getString("streamerUsername");
        if (audience == null || audience.isEmpty()) return;

        //Checking the message audience
        if (audience.equalsIgnoreCase("everyone")) {
            everyone(plugin, message);
        } else if (audience.equalsIgnoreCase("streamerOnly")) {
            if (streamer == null) return;
            Player player = Bukkit.getPlayerExact(streamer);
            streamerOnly(plugin, message, player);
        } else {
            Bukkit.getLogger().severe("[LiveAlerts] The \"" + audience + "\" audience type is invalid!");
            Bukkit.getLogger().severe("[LiveAlerts] Audience types: \"everyone\",\"streamerOnly\"!");
            Bukkit.getLogger().severe("[LiveAlerts] Please fix your config.yml!");
        }
    }

}
