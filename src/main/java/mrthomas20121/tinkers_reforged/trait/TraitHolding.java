package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitHolding extends AbstractTrait {

    public TraitHolding() {
        super("ref_holding", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getOriginalToolStats(rootCompound);

        data.durability *= 4;
        data.harvestLevel--;
        data.attack *= 1.5f;
        data.speed *= 1.5f;
        data.modifiers *= 1.5f;
        data.attackSpeedMultiplier*=1.5f;



        TagUtil.setToolTag(rootCompound, data.get());
    }
}
