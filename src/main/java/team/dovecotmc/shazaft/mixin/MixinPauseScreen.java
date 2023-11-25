package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.dovecotmc.shazaft.ShazaftClient;
import team.dovecotmc.shazaft.config.ShazaftConfig;
import team.dovecotmc.shazaft.util.Utilities;

import java.awt.*;

@Mixin(PauseScreen.class)
public abstract class MixinPauseScreen extends Screen {
    protected MixinPauseScreen(Component component) {
        super(component);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"))
    private void inject$render(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        final SoundInstance sound = ((AccessorMusicManager) Minecraft.getInstance().getMusicManager()).getCurrentMusic();
        if (sound == null) return;
        final ShazaftConfig cfg = ShazaftClient.getCfg();
        final int w = (int) (this.width * cfg.width_coefficient_screen_width + cfg.width_constant);
        final int h = (int) (this.height * cfg.height_coefficient_screen_height + cfg.height_constant);
        if (cfg.centered)
            guiGraphics.drawCenteredString(this.font, Component.translatable("record.nowPlaying",
                    Utilities.getMusicName(sound.getSound().getLocation().toString())), w, h, Color.CYAN.getRGB());
        else guiGraphics.drawString(this.font, Component.translatable("record.nowPlaying",
                Utilities.getMusicName(sound.getSound().getLocation().toString())), w, h, Color.CYAN.getRGB());
    }
}
