package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitFast extends AbstractTrait {

    public TraitFast()
    {
        super("ref_fast", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);

        data.speed+=5;
        data.durability=(int)(data.durability*0.5f);

        TagUtil.setToolTag(rootCompound, data.get());
    }
}
