package team.dovecotmc.shazaft;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import team.dovecotmc.shazaft.config.ShazaftConfig;

@Mod("shazaft")
public class Shazaft {
    public Shazaft() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest(() -> "", (a, b) -> true));
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ShazaftConfig.CFG);
    }
}
