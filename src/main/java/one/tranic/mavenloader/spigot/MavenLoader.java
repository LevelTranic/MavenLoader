package one.tranic.mavenloader.spigot;

import one.tranic.mavenloader.loader.Loader;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MavenLoader extends JavaPlugin {
    private final Logger logger = LoggerFactory.getLogger("MavenLoaderAPI");
    private Metrics metrics;

    public MavenLoader() {
        super();
        Loader.MainLoader(getDataFolder().toPath(), logger);
    }

    @Override
    public void onEnable() {
        logger.info("Initializing MavenLoaderAPI (Spigot)");
        metrics = new Metrics(this, 23501);
    }

    @Override
    public void onDisable() {
        logger.info("Shutting down MavenLoaderAPI (Spigot)");
        if (metrics != null) {
            metrics.shutdown();
        }
    }
}
