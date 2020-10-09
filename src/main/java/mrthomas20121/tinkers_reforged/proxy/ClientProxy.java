package mrthomas20121.tinkers_reforged.proxy;

import mrthomas20121.biolib.objects.book.BookHelper;
import mrthomas20121.biolib.objects.material.MaterialWrapper;
import mrthomas20121.tinkers_reforged.modules.*;
import mrthomas20121.tinkers_reforged.TinkersReforged;

import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.util.ArrayList;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        for (MaterialWrapper resource : Resources.materials) {
            resource.getMaterial().setRenderInfo(resource.getMaterial().materialTextColor);
        }
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
        if(ModuleTools.gladius != null)
        {
            ToolBuildGuiInfo gladiusGui = new ToolBuildGuiInfo(ModuleTools.gladius);
            gladiusGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            gladiusGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            gladiusGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(gladiusGui);
        }
        if(ModuleTools.knife != null)
        {
            ToolBuildGuiInfo runedKnifeGui = new ToolBuildGuiInfo(ModuleTools.knife);
            runedKnifeGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            runedKnifeGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            runedKnifeGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(runedKnifeGui);
        }
        if(ModuleTools.club != null)
        {
            ToolBuildGuiInfo clubGui = new ToolBuildGuiInfo(ModuleTools.club);
            clubGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            clubGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(clubGui);
        }
        if(ModuleTools.greatsword != null)
        {
            ToolBuildGuiInfo greatSwordGui = new ToolBuildGuiInfo(ModuleTools.greatsword);
            greatSwordGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            greatSwordGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            greatSwordGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(greatSwordGui);
        }
        if(ModuleTools.khopesh != null)
        {
            ToolBuildGuiInfo khopeshGui = new ToolBuildGuiInfo(ModuleTools.khopesh);
            khopeshGui.addSlotPosition(33 - 20 - 1, 42 + 20);
            khopeshGui.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            khopeshGui.addSlotPosition(33 - 2 - 1, 42 + 2);
            TinkerRegistryClient.addToolBuilding(khopeshGui);
        }
    }

    @Override
    public void registerBookData() {
        BookHelper book = new BookHelper(TinkersReforged.MODID);
        book.addRepository();
        book.addModifierTransformer("ref_");
        book.addToolTransformer("ref_");
    }

    @Override
    public void registerToolModel(ToolCore tc) {
        ModelRegisterUtil.registerToolModel(tc);
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        TinkersReforged.getLogger().info("Loading Model");
        ArrayList<Item> items = ModuleItems.genArrayList();
        for(Item item : items) {
            ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        for(ItemBlock itemBlock: ModuleFluids.blockFluids) {
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(itemBlock.getRegistryName(), "normal"));
            ModelLoader.setCustomStateMapper(itemBlock.getBlock(), new StateMapperBase() {
                @Override
                public ModelResourceLocation getModelResourceLocation(IBlockState state) {
                    return new ModelResourceLocation(itemBlock.getRegistryName(), "normal");
                }});
        }
        ModuleItems.InitModels();
    }
}
