package team.dovecotmc.shazaft.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(RecordItem.class)
public interface AccessorRecordItem {
    @Accessor("BY_NAME")
    static Map<SoundEvent, RecordItem> getRecords() {
        throw new RuntimeException();
    }

    ;
}
