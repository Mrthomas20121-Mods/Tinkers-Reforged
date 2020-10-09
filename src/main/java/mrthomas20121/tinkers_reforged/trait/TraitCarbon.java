package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitCarbon extends AbstractTrait {
    public TraitCarbon() {
        super("ref_carbon", 0xfff999);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.durability += 300;

        TagUtil.setToolTag(rootCompound, data.get());
    }
}