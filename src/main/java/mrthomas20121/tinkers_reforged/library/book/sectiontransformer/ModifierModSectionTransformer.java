package mrthomas20121.tinkers_reforged.library.book.sectiontransformer;

import mrthomas20121.tinkers_reforged.library.book.data.PageDataMod;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.content.ContentModifier;
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ModifierSectionTransformer;
import slimeknights.tconstruct.library.modifiers.IModifier;

@SideOnly(Side.CLIENT)
public class ModifierModSectionTransformer extends ContentListingSectionTransformer {

    public ModifierModSectionTransformer()
    {
        super("ref_modifiers");
    }

    @Override
    protected void processPage(BookData book, ContentListing listing, PageData page) {
        if(page instanceof PageDataMod) {
            String modid = ((PageDataMod) page).mod;
            if(page.content instanceof ContentModifier) {
                IModifier modifier = TinkerRegistry.getModifier(((ContentModifier) page.content).modifierName);
                if(modifier != null && Loader.isModLoaded(modid)) {
                    listing.addEntry(modifier.getLocalizedName(), page);
                }
            }
        }
    }
}