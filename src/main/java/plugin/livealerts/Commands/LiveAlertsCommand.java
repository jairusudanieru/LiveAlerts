package plugin.livealerts.Commands;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LiveAlertsCommand implements CommandExecutor, TabCompleter {

    JavaPlugin plugin;
    LiveAlertsTabComplete liveAlertsTabComplete = new LiveAlertsTabComplete();
    LiveAlertsArgs liveAlertsArgs = new LiveAlertsArgs();

    public LiveAlertsCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        return liveAlertsTabComplete.tabCompleteArgs(args);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("livealerts")) return false;
        if (args[0].equalsIgnoreCase("set")) {
            liveAlertsArgs.onLiveAlertsArgs(sender, args, plugin);
        } else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("Live Alerts Help");
            sender.sendMessage("If you find any issues, please message me in my discord - Jairusu#5237");
        } else {
            return false;
        }
        return true;
    }


}
