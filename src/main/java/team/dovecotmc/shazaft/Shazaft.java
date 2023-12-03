package team.dovecotmc.shazaft;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import team.dovecotmc.shazaft.config.ShazaftConfig;

@Mod(Shazaft.MODID)
public class Shazaft {
    public static final String MODID = "shazaft";
    public Shazaft() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ShazaftConfig.CFG);
    }
}
