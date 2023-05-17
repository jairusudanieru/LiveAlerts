package plugin.livealerts.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class LiveAlertsArgs {

    public void onAudienceTypeArgument(@NotNull CommandSender sender, String[] args, JavaPlugin plugin) {
        switch (args[2]) {
            case "everyone":
                String everyone = "everyone";
                plugin.getConfig().set("audienceType", everyone);
                plugin.saveConfig();
                sender.sendMessage("AudienceType changed to \"everyone\"");
                break;
            case "streamerOnly":
                String streamerOnly = "streamerOnly";
                plugin.getConfig().set("audienceType", streamerOnly);
                plugin.saveConfig();
                sender.sendMessage("AudienceType changed to \"streamerOnly\"");
                break;
        }
    }

    public void onMessageTypeArgument(@NotNull CommandSender sender, String[] args, JavaPlugin plugin) {
        switch (args[2]) {
            case "actionBar":
                String actionBar = "actionBar";
                plugin.getConfig().set("messageType", actionBar);
                plugin.saveConfig();
                sender.sendMessage("MessageType changed to \"actionBar\"");
                break;
            case "bossBar":
                String bossBar = "bossBar";
                plugin.getConfig().set("messageType", bossBar);
                plugin.saveConfig();
                sender.sendMessage("MessageType changed to \"bossBar\"");
                break;
            case "broadcast":
                String broadcast = "broadcast";
                plugin.getConfig().set("messageType", broadcast);
                plugin.saveConfig();
                sender.sendMessage("MessageType changed to \"broadcast\"");
                break;
        }
    }

    public void onBossBarColorArgument(@NotNull CommandSender sender, String[] args, JavaPlugin plugin) {
        switch (args[2]) {
            case "blue":
                String blue = "blue";
                plugin.getConfig().set("bossBarColor", blue);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"blue\"");
                break;
            case "green":
                String green = "green";
                plugin.getConfig().set("bossBarColor", green);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"green\"");
                break;
            case "pink":
                String pink = "pink";
                plugin.getConfig().set("bossBarColor", pink);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"pink\"");
                break;
            case "purple":
                String purple = "purple";
                plugin.getConfig().set("bossBarColor", purple);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"purple\"");
                break;
            case "red":
                String red = "red";
                plugin.getConfig().set("bossBarColor", red);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"red\"");
                break;
            case "white":
                String white = "white";
                plugin.getConfig().set("bossBarColor", white);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"white\"");
                break;
            case "yellow":
                String yellow = "yellow";
                plugin.getConfig().set("bossBarColor", yellow);
                plugin.saveConfig();
                sender.sendMessage("BossBarColor changed to \"yellow\"");
                break;
        }
    }

    public void onLiveAlertsArgs(@NotNull CommandSender sender, String[] args, JavaPlugin plugin) {
        switch (args[1]) {
            case "audienceType":
                onAudienceTypeArgument(sender, args, plugin);
                break;
            case "messageType":
                onMessageTypeArgument(sender, args, plugin);
                break;
            case "bossBarColor":
                onBossBarColorArgument(sender, args, plugin);
                break;
        }
    }

}
