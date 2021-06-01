package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitConsolationPrize extends AbstractTrait {

    public TraitConsolationPrize() {
        super("ref_consolation_prize", 0x0);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT tag = TagUtil.getToolStats(rootCompound);

        float min = getMin(tag.harvestLevel, tag.attack, tag.attackSpeedMultiplier, tag.speed);

        if(tag.speed == min) {
            tag.speed+=4;
        }
        else if(tag.harvestLevel == (int)min) {
            tag.harvestLevel++;
        }
        else if(tag.attackSpeedMultiplier == min) {
            tag.attackSpeedMultiplier+=0.5f;
        }
        else {
            tag.attack+=3.9f;
        }
        TagUtil.setToolTag(rootCompound, tag.get());
    }

    private float getMin(int harvestLevel, float attack, float attackSpeedMultiplier, float speed) {
        return Math.min(Math.min(Math.min(harvestLevel, attack), attackSpeedMultiplier), speed);
    }
}
