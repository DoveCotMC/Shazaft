package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.dovecotmc.shazaft.listener.ShazaftListener;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Shadow
    @Final
    private SoundManager soundManager;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(GameConfig cfg, CallbackInfo ci) {
        soundManager.addListener(new ShazaftListener());
    }

}
