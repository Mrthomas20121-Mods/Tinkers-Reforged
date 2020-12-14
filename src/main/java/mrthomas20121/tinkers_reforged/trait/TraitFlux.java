package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.biolib.objects.capability.BioEnergyWrapper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.tools.modifiers.ModMendingMoss;

import java.util.Objects;

public class TraitFlux extends AbstractTrait {
    private int energyCost = 5;

    public TraitFlux() {
        super("ref_flux", 0x0f1000);
    }

    @Override
    public boolean canApplyCustom(ItemStack stack) {
        return (!stack.hasCapability(CapabilityEnergy.ENERGY, null)
                || stack.getCapability(CapabilityEnergy.ENERGY, null) instanceof BioEnergyWrapper)
                && super.canApplyCustom(stack);
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
            int level = ModifierNBT.readTag(TinkerUtil.getModifierTag(tool, identifier)).level;
            double chance = 0.5 + (level - 1) * 0.2;
            float rand = random.nextFloat();
            if (chance > 0 && rand <= chance) {
                int energy = Objects.requireNonNull(tool.getTagCompound()).getInteger("bioEnergy");
                int cost = newDamage * energyCost;
                if (energy >= cost) {
                    tool.getTagCompound().setInteger("bioEnergy", energy - cost);
                    return 0;
                }
            }
        }
        return newDamage;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);
        if (!rootCompound.hasKey("bioEnergy")) {
            rootCompound.setInteger("bioEnergy", 0);
        }
        rootCompound.setInteger("bioEnergyCapacity",
                ModifierNBT.readTag(modifierTag).level * 2);
    }
}