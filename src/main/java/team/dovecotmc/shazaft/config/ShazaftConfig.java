package team.dovecotmc.shazaft.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import team.dovecotmc.shazaft.Shazaft;

import java.awt.*;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Shazaft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShazaftConfig {
    public static final ForgeConfigSpec CFG;
    public static final ForgeConfigSpec.BooleanValue pause_enabled;
    public static final ForgeConfigSpec.BooleanValue pause_centered;
    public static final ForgeConfigSpec.IntValue pause_now_color;
    public static final ForgeConfigSpec.DoubleValue pause_height_coefficient_screen_height;
    public static final ForgeConfigSpec.IntValue pause_height_constant;
    public static final ForgeConfigSpec.DoubleValue pause_width_coefficient_screen_width;
    public static final ForgeConfigSpec.IntValue pause_width_constant;
    public static final ForgeConfigSpec.BooleanValue title_enabled;
    public static final ForgeConfigSpec.BooleanValue title_centered;
    public static final ForgeConfigSpec.IntValue title_now_color;
    public static final ForgeConfigSpec.DoubleValue title_height_coefficient_screen_height;
    public static final ForgeConfigSpec.IntValue title_height_constant;
    public static final ForgeConfigSpec.DoubleValue title_width_coefficient_screen_width;
    public static final ForgeConfigSpec.IntValue title_width_constant;
    public static final ForgeConfigSpec.EnumValue<PopupStyle> musicPopupStyle;
    public static final ForgeConfigSpec.EnumValue<PopupStyle> recordPopupStyle;
    public static final ForgeConfigSpec.LongValue toastExpiration;
    public static final ForgeConfigSpec.ConfigValue<String> _defaultToastIcon;
    public static final ForgeConfigSpec.BooleanValue silentToast;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Text");
        builder.push("Pause");
        pause_enabled = builder
                .define("pause_enabled", true);
        pause_centered = builder
                .define("pause_centered", false);
        pause_now_color = builder
                .defineInRange("pause_now_color", Color.CYAN.getRGB(), Color.BLACK.getRGB(), Color.WHITE.getRGB());
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
        title_enabled = builder
                .define("title_enabled", true);
        title_centered = builder
                .define("title_centered", false);
        title_now_color = builder
                .defineInRange("title_now_color", Color.CYAN.getRGB(), Color.BLACK.getRGB(), Color.WHITE.getRGB());
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
        builder.push("Popup");
        musicPopupStyle = builder
                .defineEnum("musicPopupStyle", PopupStyle.TOAST);
        recordPopupStyle = builder
                .defineEnum("recordPopupStyle", PopupStyle.TOAST);
        builder.push("Toast");
        toastExpiration = builder
                .defineInRange("toastExpiration", 5000L, 500L, 20000L);
        _defaultToastIcon = builder
                .define("defaultToastIcon", "minecraft:music_disc_far",
                        o -> o instanceof String s && ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(s)));
        silentToast = builder
                .define("silentToast", true);
        builder.pop();
        builder.pop();
        CFG = builder.build();
    }

    public enum PopupStyle {
        TOAST,
        OVERLAY,
        DISABLED;
    }

    private static ItemStack defaultToastIcon = Items.MUSIC_DISC_FAR.getDefaultInstance();

    public static ItemStack getDefaultToastIcon() {
        return defaultToastIcon;
    }

    @SubscribeEvent
    public static void onCfgLoad(ModConfigEvent event) {
        defaultToastIcon = Objects.requireNonNull(ForgeRegistries.ITEMS
                .getValue(ResourceLocation.tryParse(_defaultToastIcon.get()))).getDefaultInstance();
    }
}
