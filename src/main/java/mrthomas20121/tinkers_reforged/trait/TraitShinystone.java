package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.modifiers.ModReinforced;

public class TraitShinystone extends AbstractTrait {

    public TraitShinystone() {
        super("ref_shinystone", 0x0);
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
        if(ToolHelper.getCurrentDurability(tool) >= ToolHelper.getDurabilityStat(tool)/2) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80));
        }
    }

    @Override
    public boolean canApplyTogether(IToolMod otherModifier) {
        return !(otherModifier instanceof ModReinforced);
    }

    @Override
    public boolean isCriticalHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target) {
        boolean result = false;
        if(this.isToolWithTrait(tool) && ToolHelper.getCurrentDurability(tool) < ToolHelper.getDurabilityStat(tool)) {
            result = true;
        }
        return result;
    }
}
