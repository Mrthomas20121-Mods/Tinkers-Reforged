package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Fey Trait
 * give the tool an overall stats boost but reduce the attack speed.
 */
public class TraitFey extends AbstractTrait {
    public TraitFey()
    {
        super("ref_fey", 0x67AFAF);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability += 200;

        if(data.harvestLevel < HarvestLevels.OBSIDIAN) {
            data.harvestLevel++;
        }

        data.attack += 2f;
        data.speed += 2f;
        data.modifiers += 1;
        data.attackSpeedMultiplier*=0.5f;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
