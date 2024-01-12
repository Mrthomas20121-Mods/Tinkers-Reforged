package mrthomas20121.tinkers_reforged.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

public class EffectFreeze extends NoMilkEffect {

    public EffectFreeze() {
        super(MobEffectCategory.HARMFUL, 0xC53439, true);

        addAttributeModifier(Attributes.MOVEMENT_SPEED, "8322ac4f-ddef-4bdb-9978-b2f8ff4b11f8", 0, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public boolean isDurationEffectTick(int tick, int level) {
        return tick > 0 && tick % 20 == 0;
    }
}