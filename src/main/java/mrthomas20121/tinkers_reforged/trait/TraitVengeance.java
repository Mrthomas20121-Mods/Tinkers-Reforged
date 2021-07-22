package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * TraitVengeance.java
 * @author mrthomas20121
 * Trait Effect - Increase attack damage based on the last damage taken.
 */
public class TraitVengeance extends RightClickTrait {

    private final String key = "lastTakenDmg";

    public TraitVengeance() {
        super("ref_vengeance", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        NBTTagCompound tag = tool.getTagCompound();
        if(tag != null && !tag.isEmpty()) {
            if(tag.hasKey(key)) {
                return damage+(tag.getFloat(key)/2);
            }
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }

    @Override
    public void onPlayerHurt(ItemStack tool, EntityPlayer player, EntityLivingBase attacker, LivingHurtEvent event) {
        NBTTagCompound tag = tool.getTagCompound();

        if(tag != null && !tag.isEmpty()) {
            tag.setFloat(key, event.getAmount());
        }
    }
}
