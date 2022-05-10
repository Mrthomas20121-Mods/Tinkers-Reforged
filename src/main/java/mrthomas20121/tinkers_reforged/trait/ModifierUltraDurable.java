package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

// bring back Duritos Trait from 1.12 Tinkers
// It has 50% chance to do nothing, 10% chance to use double durability and 40% chance to use no durability
// equalling to 70% durability used on average = 30% unbreakable
public class ModifierUltraDurable extends Modifier {

    @Override
    public int onDamageTool(@Nonnull IToolStackView tool, int level, int amount, @Nullable LivingEntity holder) {
        float f = RANDOM.nextFloat();
        if(f < 0.1f) {
            return amount*2;
        }
        else if(f < 0.5f) {
            return 0;
        }
        else {
            return super.onDamageTool(tool, level, amount, holder);
        }
    }
}
