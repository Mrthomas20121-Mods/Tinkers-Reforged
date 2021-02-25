package mrthomas20121.tinkers_reforged.library.book.sectiontransformer;

import mrthomas20121.biolib.objects.book.ModifierSectionTransformer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModifiersSectionTransformer extends ModifierSectionTransformer {

    public ModifiersSectionTransformer()
    {
        super("ref_modifiers");
    }
}