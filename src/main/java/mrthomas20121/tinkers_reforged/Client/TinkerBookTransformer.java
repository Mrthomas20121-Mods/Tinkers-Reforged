package mrthomas20121.tinkers_reforged.Client;

import com.google.common.collect.Lists;
import mrthomas20121.tinkers_reforged.Modifiers.Modifiers;
import mrthomas20121.tinkers_reforged.Modifiers.ModuleModAA;
import mrthomas20121.tinkers_reforged.Module.ModuleTools;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.library.book.content.ContentListing;
import slimeknights.tconstruct.library.book.sectiontransformer.SectionTransformer;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.tools.TinkerToolCore;

import java.util.ArrayList;

public class TinkerBookTransformer extends SectionTransformer {

    public TinkerBookTransformer() {
        super("tools");
    }

    @Override
    public void transform(BookData book, SectionData section) {

        ArrayList<TinkerToolCore> tools = Lists.newArrayList(ModuleTools.gladius, ModuleTools.club, ModuleTools.greatsword, ModuleTools.khopesh);

        for(TinkerToolCore tool : tools)
        {
            if(!tool.getLocalizedToolName().equals(ModuleTools.gladius.getLocalizedToolName()))
            {
                if(tool.getLocalizedToolName().equals(ModuleTools.knife.getLocalizedToolName()))
                {
                    if(Loader.isModLoaded("roots"))
                    {
                        addTool(section, tool);
                    }
                }
                else if(Loader.isModLoaded("atum"))
                {
                    addTool(section, tool);
                }
            }
            else {
                addTool(section, tool);
            }
        }

        if(Loader.isModLoaded("actuallyadditions"))
        {
            addModifier(section, Modifiers.moduleModAA.getEnderStarMod());
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
    private static void addModifier(SectionData section, ModifierTrait mod)
    {
        ContentListing listing = (ContentListing)section.pages.get(0).content;
        PageData page = new PageData();
        page.source = new FileRepository("tconstruct:book");
        page.parent = section;
        page.type = "modifier";
        page.data = "modifiers/" + mod.identifier + ".json";
        section.pages.add(page);
        page.load();
        listing.addEntry(mod.getLocalizedName(), page);
    }
}
