package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitExperimental extends AbstractTrait {

    public TraitExperimental() {
        super("ref_experimental", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability *= 0.5f;
        data.harvestLevel = HarvestLevels.STONE;

        data.attack *= 0.5f;
        data.speed *= 1.5f;
        data.attackSpeedMultiplier*=1.5f;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
