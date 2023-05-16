package plugin.livealerts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Commands.LiveAlertsCommand;
import plugin.livealerts.Utilities.PlatformType;

public final class LiveAlerts extends JavaPlugin {

    PlatformType platformType = new PlatformType();

    public void checkPlugin() {
        String token = getConfig().getString("socketToken");
        if (token == null || token.isEmpty() || token.equalsIgnoreCase("yourSocketToken")) {
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            Bukkit.getLogger().info("[LiveAlerts] Please set your socket token in config!");
            Bukkit.getLogger().info("[LiveAlerts] Plugin successfully disabled!");
            return;
        }
        getCommand("livealerts").setExecutor(new LiveAlertsCommand(this));
        platformType.platformType(this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        checkPlugin();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
