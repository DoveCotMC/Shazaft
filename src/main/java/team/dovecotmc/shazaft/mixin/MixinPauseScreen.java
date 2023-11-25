package team.dovecotmc.shazaft.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.dovecotmc.shazaft.util.Utilities;

import java.awt.*;

@Mixin(PauseScreen.class)
public abstract class MixinPauseScreen extends Screen {
    protected MixinPauseScreen(Component component) {
        super(component);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/PauseScreen;drawCenteredString(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)V"))
    private void inject$render(PoseStack poseStack, int i, int j, float f, CallbackInfo ci) {
        final SoundInstance sound = ((AccessorMusicManager) Minecraft.getInstance().getMusicManager()).getCurrentMusic();
        if (sound == null) return;
        PauseScreen.drawString(poseStack, this.font, Component.translatable("record.nowPlaying",
                Utilities.getMusicName(sound.getSound().getLocation().toString())), 5, this.height - 15, Color.CYAN.getRGB());
    }
}
