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
import team.dovecotmc.shazaft.util.Utilities;

import static team.dovecotmc.shazaft.config.ShazaftConfig.*;

@Mixin(PauseScreen.class)
public abstract class MixinPauseScreen extends Screen {
    protected MixinPauseScreen(Component title) {
        super(title);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"))
    private void inject$render(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        if (!pause_enabled.get()) return;
        final SoundInstance sound = ((AccessorMusicManager) Minecraft.getInstance().getMusicManager()).getCurrentMusic();
        if (sound == null) return;
        final int w = (int) (this.width * pause_width_coefficient_screen_width.get() +
                pause_width_constant.get());
        final int h = (int) (this.height * pause_height_coefficient_screen_height.get() +
                pause_height_constant.get());
        if (pause_centered.get())
            guiGraphics.drawCenteredString(
                    this.font,
                    Utilities.getNowPlaying(sound.getSound().getLocation().toString()),
                    w, h, pause_now_color.get()
            );
        else guiGraphics.drawString(
                this.font,
                Utilities.getNowPlaying(sound.getSound().getLocation().toString()),
                w, h, pause_now_color.get()
        );
    }
}
