package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.CapabilityEnergy;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.modifiers.ModMendingMoss;

public class TraitFlux extends AbstractTrait {
    private int energyCost = 5;

    public TraitFlux() {
      super("ref_flux", 0x0f1000);
    }
    @Override
    public boolean canApplyCustom(ItemStack stack) {
      return !stack.hasCapability(CapabilityEnergy.ENERGY, null) && super.canApplyCustom(stack);
    }
    @Override
    public boolean canApplyTogether(IToolMod o) {
        return !(o instanceof ModMendingMoss);
    }
    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (entity.getEntityWorld().isRemote)
            return 0;
        if (newDamage > 0) {
            return energyCost;
        }
        return newDamage;
    }
}