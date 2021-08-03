package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.tools.modifiers.ModFiery;

public class TraitFiery extends ReforgedTrait {

    public TraitFiery() {
        super("ref_fiery", 0x0);
    }

    @Override
    public boolean canApplyTogether(IToolMod o) {
        return !(o instanceof ModFiery);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit) {
            target.setFire(10);
        }
    }
}
