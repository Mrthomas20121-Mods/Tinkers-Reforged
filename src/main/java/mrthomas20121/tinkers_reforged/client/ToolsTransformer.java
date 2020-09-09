package mrthomas20121.tinkers_reforged.client;

import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.config.ConfigModule;
import mrthomas20121.tinkers_reforged.config.ConfigReforged;
import mrthomas20121.tinkers_reforged.modules.ModuleTools;
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

        if(ConfigReforged.gladius) addTool(section, ModuleTools.gladius);

        if(Loader.isModLoaded("atum") && ConfigModule.atum)
        {
            if(ConfigReforged.club) addTool(section, ModuleTools.club);
            if(ConfigReforged.greatsword) addTool(section, ModuleTools.greatsword);
            if(ConfigReforged.khopesh) addTool(section, ModuleTools.khopesh);
        }
        if(Loader.isModLoaded("roots") && ConfigModule.roots)
        {
            if(ConfigReforged.runedKnife) addTool(section, ModuleTools.knife);
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
