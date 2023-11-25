package team.dovecotmc.shazaft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;
import team.dovecotmc.shazaft.ShazaftClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ConfigLoader {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final Path cfgPathRoot = FabricLoader.getInstance().getConfigDir();

    public static ShazaftConfig getConfig() {
        final Path cfgPath = cfgPathRoot.resolve("shazaft.json");
        ShazaftConfig config = new ShazaftConfig();
        if (cfgPath.toFile().isFile()) {
            try {
                config = GSON.fromJson(FileUtils.readFileToString(cfgPath.toFile(),
                        StandardCharsets.UTF_8), ShazaftConfig.class);
            } catch (IOException e) {
                ShazaftClient.LOGGER.error(String.format("Failed to parse shazaft config \"%s\"", cfgPath), e);
                FileUtils.deleteQuietly(cfgPath.toFile());
                return createOffsetConfig(cfgPath, config) ? config : null;
            }
            return config;
        } else return createOffsetConfig(cfgPath, config) ? config : null;
    }

    public static boolean createOffsetConfig(Path cfgPath, ShazaftConfig config) {
        try {
            FileUtils.write(cfgPath.toFile(), GSON.toJson(config), StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            ShazaftClient.LOGGER.error(String.format("Failed to create shazaft config \"%s\"", cfgPath), e);
        }
        return false;
    }
}
