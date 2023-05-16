package plugin.livealerts.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

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

    public void onLiveAlertsArgs(@NotNull CommandSender sender, String[] args, JavaPlugin plugin) {
        switch (args[1]) {
            case "audienceType":
                onAudienceTypeArgument(sender, args, plugin);
                break;
            case "messageType":
                onMessageTypeArgument(sender, args, plugin);
                break;
        }
    }

}
