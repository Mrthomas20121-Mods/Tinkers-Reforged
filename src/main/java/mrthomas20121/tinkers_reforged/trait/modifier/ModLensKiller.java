package mrthomas20121.tinkers_reforged.trait.modifier;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ModLensKiller extends ModifierTrait {

    public ModLensKiller()
    {
        super("lens_killer", 0x280407);
        this.addAspects(new ModifierAspect.SingleAspect(this), ModifierAspect.weaponOnly);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        ToolNBT data = TagUtil.getToolStats(rootCompound);
        data.attack += 7f;
        TagUtil.setToolTag(rootCompound, data.get());
    }
}
