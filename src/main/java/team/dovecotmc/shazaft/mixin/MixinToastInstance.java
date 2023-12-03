package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import team.dovecotmc.shazaft.config.ShazaftConfig;
import team.dovecotmc.shazaft.toast.PopupToast;

@Mixin(ToastComponent.ToastInstance.class)
public abstract class MixinToastInstance<T extends Toast> {
    @Shadow
    public abstract T getToast();

    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/components/toasts/Toast$Visibility;playSound(Lnet/minecraft/client/sounds/SoundManager;)V"
            )
    )
    private void redirect$render(Toast.Visibility instance, SoundManager manager) {
        if (!ShazaftConfig.silentToast.get() || !(getToast() instanceof PopupToast)) instance.playSound(manager);
    }
}