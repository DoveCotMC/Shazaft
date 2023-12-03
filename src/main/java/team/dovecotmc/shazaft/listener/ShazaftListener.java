package team.dovecotmc.shazaft.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEventListener;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.sounds.SoundSource;
import team.dovecotmc.shazaft.config.ShazaftConfig;
import team.dovecotmc.shazaft.toast.PopupToast;
import team.dovecotmc.shazaft.util.Utilities;

public class ShazaftListener implements SoundEventListener {
    @Override
    public void onPlaySound(SoundInstance sound, WeighedSoundEvents events) {
        final SoundSource source = sound.getSource();
        if (source.equals(SoundSource.MUSIC)) {
            switch (ShazaftConfig.musicPopupStyle.get()) {
                case DISABLED -> {
                }
                case TOAST -> Minecraft.getInstance().getToasts()
                        .addToast(new PopupToast(Utilities.getMusicName(sound.getSound().getLocation().toString())));
                case OVERLAY -> Minecraft.getInstance().gui
                        .setOverlayMessage(Utilities.getNowPlaying(sound.getSound().getLocation().toString()), true);
            }
        } else if (source.equals(SoundSource.RECORDS) && ShazaftConfig.recordPopupStyle.get().equals(ShazaftConfig.PopupStyle.TOAST)) {
            Minecraft.getInstance().getToasts()
                    .addToast(new PopupToast(
                            Utilities.getMusicName(sound.getSound().getLocation().toString()),
                            Utilities.getItemFromSound(sound.getLocation())
                    ));
        }
    }
}
