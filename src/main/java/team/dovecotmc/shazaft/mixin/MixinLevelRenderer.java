package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import team.dovecotmc.shazaft.config.ShazaftConfig;

@Mixin(LevelRenderer.class)
public abstract class MixinLevelRenderer {
    @Redirect(
            method = "playStreamingMusic(Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/RecordItem;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/Gui;setNowPlaying(Lnet/minecraft/network/chat/Component;)V"
            )
    )
    private void redirect$playStreamingMusic(Gui instance, Component music) {
        if (ShazaftConfig.recordPopupStyle.get().equals(ShazaftConfig.PopupStyle.OVERLAY))
            instance.setNowPlaying(music);
    }
}
