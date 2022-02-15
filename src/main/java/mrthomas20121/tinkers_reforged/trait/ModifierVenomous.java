package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ModifierVenomous extends Modifier {

    public ModifierVenomous() {
        super(0x1B893E);
    }

    @Override
    public int afterEntityHit(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        LivingEntity target = Objects.requireNonNull(context.getLivingTarget());
        target.addEffect(new EffectInstance(Effects.POISON, (int) (9*damageDealt), 0, false, false, false));
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
