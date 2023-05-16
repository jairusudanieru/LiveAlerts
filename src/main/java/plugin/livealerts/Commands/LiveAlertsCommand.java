package plugin.livealerts.Commands;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import plugin.livealerts.Utilities.TabCompleteArray;

import java.util.List;

public class LiveAlertsCommand implements CommandExecutor, TabCompleter {

    JavaPlugin plugin;
    TabCompleteArray tabCompleteArray = new TabCompleteArray();
    LiveAlertsArgs liveAlertsArgs = new LiveAlertsArgs();

    public LiveAlertsCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        return tabCompleteArray.tabCompleteArgs(args);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("livealerts")) return false;
        if (args[0].equalsIgnoreCase("set")) {
            liveAlertsArgs.onLiveAlertsArgs(sender, args, plugin);
        } else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("Plugin: LiveAlerts");
        } else {
            return false;
        }
        return true;
    }


}
