package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class TraitPiercingDamage extends ReforgedTrait {

    public TraitPiercingDamage() {
        super("ref_piercing_damage", 0x0);
    }

    @Override
    public boolean isCriticalHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target) {
        return false;
    }

    @Override
    public void onEntityAttack(ItemStack tool, EntityPlayer player, EntityLivingBase target, DamageSource source, float amount, LivingAttackEvent event) {
        if(this.isToolWithTrait(tool)) {
            if(!source.isMagicDamage()) {
                event.setCanceled(true);
                target.attackEntityFrom(source.setMagicDamage().setDifficultyScaled(), amount);
            }
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit) target.attackEntityFrom(DamageSource.causeIndirectMagicDamage(target, player).setDamageBypassesArmor(), damageDealt/4);
    }
}
