package team.dovecotmc.shazaft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ShazaftConfig {
    public static final ForgeConfigSpec CFG;
    public static final ForgeConfigSpec.BooleanValue centered;
    public static final ForgeConfigSpec.DoubleValue height_coefficient_screen_height;
    public static final ForgeConfigSpec.IntValue height_constant;
    public static final ForgeConfigSpec.DoubleValue width_coefficient_screen_width;
    public static final ForgeConfigSpec.IntValue width_constant;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("display");
        centered = builder.define("centered", false);
        height_coefficient_screen_height = builder.defineInRange("height_coefficient_screen_height", 1.0, 0.0, 1.0);
        height_constant = builder.defineInRange("height_constant", -15, -32768, 32767);
        width_coefficient_screen_width = builder.defineInRange("width_coefficient_screen_width", 0.0, 0.0, 1.0);
        width_constant = builder.defineInRange("width_constant", 5, -32768, 32767);
        builder.pop();
        CFG = builder.build();
    }
}
