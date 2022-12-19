package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;

import java.util.UUID;

public class TraitTradeOff extends ReforgedTrait {

    public static final AttributeModifier healthModifier = new AttributeModifier(UUID.fromString("4dd40d86-656f-4cb6-ac94-10509e7156b2"), "Tinkers Reforged Health Modifier", -0.5d, 2);

    public TraitTradeOff() {
        super("ref_tradeoff", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound,modifierTag);
        ToolNBT data = TagUtil.getToolStats(rootCompound);

        data.attackSpeedMultiplier *= 2;
        data.attack *= 2;
        data.speed *= 2;

        TagUtil.setToolTag(rootCompound, data.get());
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // do stuff if selected
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            IAttributeInstance i=player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
            if (isSelected) {
                if (!i.hasModifier(healthModifier) && !player.capabilities.isCreativeMode) {
                    i.applyModifier(healthModifier);
                    if(player.getHealth()>i.getAttributeValue())
                    {
                        player.setHealth((float)i.getAttributeValue());
                    }
                }
            } else {
                if (i.hasModifier(healthModifier)){
                    i.removeModifier(healthModifier);
                }
            }
        }
    }
}
