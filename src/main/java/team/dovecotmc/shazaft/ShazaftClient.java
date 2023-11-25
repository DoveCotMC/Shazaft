package team.dovecotmc.shazaft;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import team.dovecotmc.shazaft.config.ConfigLoader;
import team.dovecotmc.shazaft.config.ShazaftConfig;

public class ShazaftClient implements ClientModInitializer {
    public static Logger LOGGER = LogUtils.getLogger();
    private static ShazaftConfig cfg;

    @Override
    public void onInitializeClient() {
        cfg = ConfigLoader.getConfig();
    }

    public static ShazaftConfig getCfg() {
        return cfg;
    }
}
