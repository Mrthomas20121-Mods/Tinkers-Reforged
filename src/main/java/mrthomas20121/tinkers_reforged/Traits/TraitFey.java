package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;

public class TraitFey extends AbstractTraitLeveled {
    private int boost = 2;
    public TraitFey()
    {
        super("ref_fey", 0x67AFAF, 3, 0);
        this.aspects.add(ModifierAspect.harvestOnly);
    }
    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        float originalSpeed = event.getOriginalSpeed();
        event.setNewSpeed(originalSpeed+ (boost+levels) );
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        return newDamage+ (boost+levels);
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        return newAmount+ (boost+levels);
    }
}
