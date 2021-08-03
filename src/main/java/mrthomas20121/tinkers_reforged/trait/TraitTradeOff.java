package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;

import java.util.UUID;

public class TraitTradeOff extends ReforgedTrait {

    public static final AttributeModifier healthModifier = new AttributeModifier(UUID.fromString("4dd40d86-656f-4cb6-ac94-10509e7156b2"), "Tinkers Reforged Health Modifier", -10d, 0);

    public TraitTradeOff() {
        super("ref_tradeoff", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);

        data.attackSpeedMultiplier*=2;
        data.attack*=2;
        data.speed*=2;

        TagUtil.setToolTag(rootCompound, data.get());
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // do stuff if selected
        if(isSelected) {
            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)entity;
                if(!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(healthModifier) && !player.isCreative()) {
                    player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(healthModifier);
                }
            }
        }
        else {
            if(((EntityPlayer)entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(healthModifier)) {
                ((EntityPlayer)entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(healthModifier);
            }
        }
    }
}
