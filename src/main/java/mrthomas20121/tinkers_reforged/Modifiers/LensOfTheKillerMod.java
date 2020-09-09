package mrthomas20121.tinkers_reforged.Modifiers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

public class LensOfTheKillerMod extends ModifierTrait {

    public LensOfTheKillerMod()
    {
        super("lens_killer", 0x280407);
        this.aspects.add(ModifierAspect.weaponOnly);
    }
    @Override
    public void apply(ItemStack stack) {
        super.apply(stack);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(target instanceof EntityMob)
        {
            return isCritical ? newDamage*2+5:newDamage*2;
        }
        return newDamage;
    }
}
