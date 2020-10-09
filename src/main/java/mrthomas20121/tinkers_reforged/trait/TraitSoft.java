package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitSoft extends AbstractTrait {
    public TraitSoft()
    {
        super("ref_soft", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);

        data.harvestLevel=1;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
