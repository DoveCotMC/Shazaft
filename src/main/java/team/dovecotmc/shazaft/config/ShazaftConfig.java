package team.dovecotmc.shazaft.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.awt.*;

public class ShazaftConfig {
    public static final ForgeConfigSpec CFG;
    public static final ForgeConfigSpec.BooleanValue pause_enabled;
    public static final ForgeConfigSpec.BooleanValue pause_centered;
    public static final ForgeConfigSpec.IntValue pause_color;
    public static final ForgeConfigSpec.DoubleValue pause_height_coefficient_screen_height;
    public static final ForgeConfigSpec.IntValue pause_height_constant;
    public static final ForgeConfigSpec.DoubleValue pause_width_coefficient_screen_width;
    public static final ForgeConfigSpec.IntValue pause_width_constant;
    public static final ForgeConfigSpec.BooleanValue title_enabled;
    public static final ForgeConfigSpec.BooleanValue title_centered;
    public static final ForgeConfigSpec.IntValue title_color;
    public static final ForgeConfigSpec.DoubleValue title_height_coefficient_screen_height;
    public static final ForgeConfigSpec.IntValue title_height_constant;
    public static final ForgeConfigSpec.DoubleValue title_width_coefficient_screen_width;
    public static final ForgeConfigSpec.IntValue title_width_constant;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Display");
        builder.push("Pause");
        pause_enabled = builder.define("pause_enabled", true);
        pause_centered = builder.define("pause_centered", false);
        pause_color = builder.defineInRange("pause_color", Color.CYAN.getRGB(), Color.BLACK.getRGB(), Color.WHITE.getRGB());
        pause_height_coefficient_screen_height = builder
                .defineInRange("pause_height_coefficient_screen_height", 1.0, 0.0, 1.0);
        pause_height_constant = builder
                .defineInRange("pause_height_constant", -15, -32768, 32767);
        pause_width_coefficient_screen_width = builder
                .defineInRange("pause_width_coefficient_screen_width", 0.0, 0.0, 1.0);
        pause_width_constant = builder
                .defineInRange("pause_width_constant", 2, -32768, 32767);
        builder.pop();
        builder.push("Title");
        title_enabled = builder.define("title_enabled", true);
        title_centered = builder.define("title_centered", false);
        title_color = builder.defineInRange("title_color", Color.CYAN.getRGB(), Color.BLACK.getRGB(), Color.WHITE.getRGB());
        title_height_coefficient_screen_height = builder
                .defineInRange("title_height_coefficient_screen_height", 0.0, 0.0, 1.0);
        title_height_constant = builder
                .defineInRange("title_height_constant", 5, -32768, 32767);
        title_width_coefficient_screen_width = builder
                .defineInRange("title_width_coefficient_screen_width", 0.0, 0.0, 1.0);
        title_width_constant = builder
                .defineInRange("title_width_constant", 2, -32768, 32767);
        builder.pop();
        builder.pop();
        CFG = builder.build();
    }
}
