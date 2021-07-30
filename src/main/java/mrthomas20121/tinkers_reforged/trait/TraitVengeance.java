package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * TraitVengeance.java
 * @author mrthomas20121
 * Trait Effect - Increase attack damage based on the last damage taken.
 * credit goes to Saereth from the Minecraft Pack Dev Discord for the idea.
 */
public class TraitVengeance extends ReforgedTrait {

    private final String key = "ref_last_dmg";

    public TraitVengeance() {
        super("ref_vengeance", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        NBTTagCompound tag = tool.getTagCompound();
        if(tag != null) {
            if(tag.hasKey(key)) {
                return damage+(tag.getFloat(key)/2);
            }
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }

    @Override
    public void onPlayerHurt(ItemStack tool, EntityPlayer player, EntityLivingBase attacker, LivingHurtEvent event) {
        NBTTagCompound tag = tool.getTagCompound();

        if(tag != null) {
            // check if you're not the attacker
            if(!attacker.getUniqueID().equals(player.getUniqueID())) {
                tag.setFloat(key, event.getAmount());
            }
        }
    }
}
