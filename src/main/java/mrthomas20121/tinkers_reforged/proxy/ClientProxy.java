package mrthomas20121.tinkers_reforged.proxy;

import mrthomas20121.tinkers_reforged.Client.TinkerBookTransformer;
import mrthomas20121.tinkers_reforged.Module.Materials;
import mrthomas20121.tinkers_reforged.Module.ModuleFluids;
import mrthomas20121.tinkers_reforged.Module.ModuleItems;
import mrthomas20121.tinkers_reforged.Module.Modules;
import mrthomas20121.tinkers_reforged.TinkersReforged;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
import slimeknights.tconstruct.library.book.TinkerBook;
import slimeknights.tconstruct.library.materials.Material;
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
        this.registerBookData();
        Modules.tools.init(e);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        TinkersReforged.logger.info("Client Stuff");
        for (Material mat : Materials.mats) {
            mat.setRenderInfo(mat.materialTextColor);
        }
    }
    @Override
    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
        ModelRegisterUtil.registerPartModel(part);
    }
    @Override
    public void registerBookData() {
        TinkerBook.INSTANCE.addTransformer(new TinkerBookTransformer());
    }

    @Override
    public void registerToolModel(ToolCore tc) {
        ModelRegisterUtil.registerToolModel(tc);
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        TinkersReforged.logger.info("Loading Model");
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
