package plugin.livealerts;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.livealerts.Options.PlatformType;

public final class LiveAlerts extends JavaPlugin {

    PlatformType platformType = new PlatformType();

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        platformType.platformType(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
