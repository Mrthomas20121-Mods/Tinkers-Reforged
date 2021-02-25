package mrthomas20121.tinkers_reforged.library.book;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.tools.Tools;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.sectiontransformer.SectionTransformer;
import slimeknights.tconstruct.library.tools.TinkerToolCore;

public class ToolsTransformer extends SectionTransformer {

    public ToolsTransformer() {
        super("tools");
    }

    @Override
    public void transform(BookData book, SectionData section) {

        if(TinkersReforgedConfig.SettingTools.enableTools) {
            if(TinkersReforgedConfig.SettingTools.enableGladius) addTool(section, Tools.gladius);
            if(TinkersReforgedConfig.SettingTools.enableLightsword) addTool(section, Tools.swordLight);

            if(Loader.isModLoaded("atum") && TinkersReforgedConfig.SettingMaterials.modules.atum)
            {
                if(TinkersReforgedConfig.SettingTools.enableClub) addTool(section, Tools.club);
                if(TinkersReforgedConfig.SettingTools.enableGreatsword) addTool(section, Tools.greatsword);
                if(TinkersReforgedConfig.SettingTools.enableKhopesh) addTool(section, Tools.khopesh);
            }
            if(Loader.isModLoaded("roots") && TinkersReforgedConfig.SettingMaterials.modules.roots)
            {
                if(TinkersReforgedConfig.SettingTools.enableKnife) addTool(section, Tools.knife);
            }
        }
    }
    private static void addTool(SectionData section, TinkerToolCore tool)
    {
        ContentListing listing = (ContentListing)section.pages.get(0).content;
        PageData page = new PageData();
        page.source = new FileRepository("tconstruct:book");
        page.parent = section;
        page.type = "tool";
        page.data = "tools/" + tool.getLocalizedToolName() + ".json";
        section.pages.add(page);
        page.load();
        listing.addEntry(tool.getLocalizedName(), page);
    }
}