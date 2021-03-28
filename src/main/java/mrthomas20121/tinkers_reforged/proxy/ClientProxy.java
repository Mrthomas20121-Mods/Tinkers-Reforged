package mrthomas20121.tinkers_reforged.proxy;

import mrthomas20121.tinkers_reforged.ReforgedRegistry;
import mrthomas20121.tinkers_reforged.TinkersReforged;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.book.ModifiersTransformer;
import mrthomas20121.tinkers_reforged.library.book.ToolsTransformer;
import mrthomas20121.tinkers_reforged.library.book.sectiontransformer.ModifiersSectionTransformer;
import mrthomas20121.tinkers_reforged.library.book.sectiontransformer.ToolsSectiontransformer;
import mrthomas20121.tinkers_reforged.tools.Tools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.book.TinkerBook;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        TinkerRegistry.getAllMaterials().forEach((material) -> { if(material.getIdentifier().contains("ref_")) material.setRenderInfo(material.materialTextColor); });
    }
    @Override
    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
        ModelRegisterUtil.registerPartModel(part);
    }
    @Override
    public void registerModifierModel(IModifier mod, ResourceLocation rl) {
        ModelRegisterUtil.registerModifierModel(mod, rl);
    }

    @Override
    public void registerToolCrafting()
    {
        if(Tools.gladius != null)
        {
            ToolBuildGuiInfo gladiusGui = new ToolBuildGuiInfo(Tools.gladius);
            gladiusGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            gladiusGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            gladiusGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(gladiusGui);
        }
        if(Tools.swordLight != null)
        {
            ToolBuildGuiInfo lightsword_gui = new ToolBuildGuiInfo(Tools.swordLight);
            lightsword_gui.addSlotPosition(33 - 20 - 1, 42 + 20);
            lightsword_gui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            lightsword_gui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(lightsword_gui);
        }
        if(Tools.knife != null)
        {
            ToolBuildGuiInfo runedKnifeGui = new ToolBuildGuiInfo(Tools.knife);
            runedKnifeGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            runedKnifeGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            runedKnifeGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(runedKnifeGui);
        }
        if(Tools.club != null)
        {
            ToolBuildGuiInfo clubGui = new ToolBuildGuiInfo(Tools.club);
            clubGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            clubGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(clubGui);
        }
        if(Tools.greatsword != null)
        {
            ToolBuildGuiInfo greatSwordGui = new ToolBuildGuiInfo(Tools.greatsword);
            greatSwordGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            greatSwordGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            greatSwordGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(greatSwordGui);
        }
        if(Tools.khopesh != null)
        {
            ToolBuildGuiInfo khopeshGui = new ToolBuildGuiInfo(Tools.khopesh);
            khopeshGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            khopeshGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            khopeshGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(khopeshGui);
        }
    }

    @Override
    public void registerBookData() {
        //TinkerBook.INSTANCE.addRepository(new FileRepository(TinkersReforged.MODID+":book"));

        // add modifiers transformers
        //TinkerBook.INSTANCE.addTransformer(new ModifiersSectionTransformer());
        //TinkerBook.INSTANCE.addTransformer(new ModifiersTransformer());

        // add tools if they are loaded
        if(TinkersReforgedConfig.SettingTools.enableTools) {
            //TinkerBook.INSTANCE.addTransformer(new ToolsSectiontransformer());
            //TinkerBook.INSTANCE.addTransformer(new ToolsTransformer());
        }
    }

    @Override
    public void registerToolModel(ToolCore tc) {
        ModelRegisterUtil.registerToolModel(tc);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for(Item item : ReforgedRegistry.getItems()) {
            ModelRegisterUtil.registerItemModel(item);
        }
        for(Block block: ReforgedRegistry.getBlocks()) {
            ModelRegisterUtil.registerItemModel(block);
        }
    }
}
