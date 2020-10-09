package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitFey extends AbstractTrait {
    private int boost = 2;
    public TraitFey()
    {
        super("ref_fey", 0x67AFAF);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability += 100;

        if(data.harvestLevel < HarvestLevels.OBSIDIAN) {
            data.harvestLevel++;
        }

        data.attack += 1f;
        data.speed += 1f;
        data.modifiers += 1;
        data.attackSpeedMultiplier+=0.5f;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
