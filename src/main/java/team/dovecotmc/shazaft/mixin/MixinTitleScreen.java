package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.dovecotmc.shazaft.util.Utilities;

import static team.dovecotmc.shazaft.config.ShazaftConfig.*;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {
    protected MixinTitleScreen(Component title) {
        super(title);
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void inject$render(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        if (!title_enabled.get()) return;
        final SoundInstance sound = ((AccessorMusicManager) Minecraft.getInstance().getMusicManager()).getCurrentMusic();
        if (sound == null) return;
        final int w = (int) (this.width * title_width_coefficient_screen_width.get() +
                title_width_constant.get());
        final int h = (int) (this.height * title_height_coefficient_screen_height.get() +
                title_height_constant.get());
        if (title_centered.get())
            guiGraphics.drawCenteredString(
                    this.font,
                    Utilities.getNowPlaying(sound.getSound().getLocation().toString()),
                    w, h, title_now_color.get());
        else guiGraphics.drawString(
                this.font,
                Utilities.getNowPlaying(sound.getSound().getLocation().toString()),
                w, h, title_now_color.get());
    }
}
