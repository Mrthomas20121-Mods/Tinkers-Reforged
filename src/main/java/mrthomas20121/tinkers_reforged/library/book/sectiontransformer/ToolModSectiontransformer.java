package mrthomas20121.tinkers_reforged.library.book.sectiontransformer;

import mrthomas20121.tinkers_reforged.library.book.data.PageDataMod;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.content.ContentTool;
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.ToolSectionTransformer;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.util.Optional;

@SideOnly(Side.CLIENT)
public class ToolModSectiontransformer extends ContentListingSectionTransformer {

    public ToolModSectiontransformer() {
        super("ref_tools");
    }

    @Override
    protected void processPage(BookData book, ContentListing listing, PageData page) {
        // only add tool pages if the tool exists
        if(page instanceof PageDataMod) {
            String modid = ((PageDataMod) page).mod;
            if(page.content instanceof ContentTool && Loader.isModLoaded(modid)) {
                String toolName = ((ContentTool) page.content).toolName;
                Optional<ToolCore> tool = TinkerRegistry.getTools().stream()
                        .filter(toolCore -> toolName.equals(toolCore.getIdentifier()))
                        .findFirst();

                tool.ifPresent(toolCore -> listing.addEntry(toolCore.getLocalizedName(), page));
            }
        }
    }
}
