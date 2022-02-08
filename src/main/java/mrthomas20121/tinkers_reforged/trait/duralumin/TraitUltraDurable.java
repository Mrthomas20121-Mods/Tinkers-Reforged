package mrthomas20121.tinkers_reforged.trait.duralumin;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// bring back Duritos Trait from 1.12 Tinkers
// It has 50% chance to do nothing, 10% chance to use double durability and 40% chance to use no durability
// equalling to 70% durability used on average = 30% unbreakable
public class TraitUltraDurable extends Modifier {

    public TraitUltraDurable() {
        super(0xD1F1C1);
    }

    @Override
    public int onDamageTool(@Nonnull IModifierToolStack toolStack, int level, int amount, @Nullable LivingEntity holder) {
        float f = RANDOM.nextFloat();
        if(f < 0.1f) {
            return amount*2;
        }
        else if(f < 0.5f) {
            return 0;
        }
        else {
            return super.onDamageTool(toolStack, level, amount, holder);
        }
    }
}
