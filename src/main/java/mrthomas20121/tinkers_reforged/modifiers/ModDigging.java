package mrthomas20121.tinkers_reforged.modifiers;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;

public class ModDigging extends ModifierTrait {

    private final int max;

    public ModDigging(int max)
    {
        super("ref_digging", 0xAF4C13);

        this.max = max;
        addAspects(new ModifierAspect.MultiAspect(this, 5, max, 1), ModifierAspect.harvestOnly);
    }
    public ModDigging()
    {
        this(8);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);

        ToolNBT toolData = TagUtil.getOriginalToolStats(rootCompound);
        float miningspeed = toolData.speed;
        int level = data.current / max;
        for(int count = data.current; count > 0; count--) {
            if(miningspeed <= 10f) {

                miningspeed += 0.05f - 0.025f * miningspeed / 10f;
            }
            else if(miningspeed <= 20f) {

                miningspeed += 0.025f - 0.01 * miningspeed / 20f;
            }
            else {

                miningspeed += 0.015;
            }
        }

        miningspeed += level * 0.25f;

        // save it to the tool
        NBTTagCompound tag = TagUtil.getToolTag(rootCompound);
        miningspeed -= toolData.attack;
        miningspeed += tag.getFloat(Tags.MININGSPEED);
        tag.setFloat(Tags.MININGSPEED, miningspeed);
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        return getLeveledTooltip(modifierTag, detailed);
    }
}
