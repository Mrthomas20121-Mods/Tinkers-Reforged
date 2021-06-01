package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitBlessedSyringe extends AbstractTrait {

    public TraitBlessedSyringe() {
        super("ref_blessed_syringe", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)entity;
                player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 80, 1));
            }
        }
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability *= 0.5f;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
