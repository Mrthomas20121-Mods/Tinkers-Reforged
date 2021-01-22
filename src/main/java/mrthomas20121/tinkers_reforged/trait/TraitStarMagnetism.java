package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitStarMagnetism extends AbstractTrait {

    private long time;

    public TraitStarMagnetism() {
        super("ref_star_magnetism", 0xffffff);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            this.time = world.getWorldTime();
            NBTTagCompound tag = tool.serializeNBT();
            tag.setLong("time", this.time);
            tool.deserializeNBT(tag);
        }
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        long t = rootCompound.getLong("time");

        ToolNBT stats = TagUtil.getToolStats(rootCompound);

        if(t > 0) {
            if(t >= 13000) {
                stats.attack +=2;
            }
        }

        TagUtil.setToolTag(rootCompound, stats.get());
    }
}