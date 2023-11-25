package team.dovecotmc.shazaft.mixin;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MusicManager.class)
public interface AccessorMusicManager {
    @Accessor
    SoundInstance getCurrentMusic();
}
