package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Tools.ToolGladius;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerTools;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleTools {
    public static ToolPart gladiusBindings;
    public static ToolGladius gladius;

    public void preInit(FMLPreInitializationEvent e) {

    }
    public void init(FMLInitializationEvent e) {
        TinkerRegistry.registerToolForgeCrafting(gladius);

        registerStencil(gladiusBindings);
    }

    @SideOnly(Side.CLIENT)
    public static void postInit(FMLPostInitializationEvent event) {
        registerDefaultForgeGui(gladius);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        gladiusBindings = new ToolPart(Material.VALUE_Ingot);
        gladiusBindings.setRegistryName(TinkersReforged.MODID,"gladius_bindings");
        gladiusBindings.setTranslationKey(TinkersReforged.MODID + ".gladius_bindings");
        TinkersReforged.proxy.registerToolPartModel(gladiusBindings);
        r.register(gladiusBindings);


        // Sword
        gladius = new ToolGladius();


        gladius.setRegistryName(TinkersReforged.MODID, "gladius");
        gladius.setTranslationKey(TinkersReforged.MODID + ".gladius");
        TinkersReforged.proxy.registerToolModel(gladius);
        r.register(gladius);
    }
    private static void registerToolForgeGui(ToolCore tool, int[][] pos) {
        TinkersReforged.logger.info("registering the ");
        ToolBuildGuiInfo t = new ToolBuildGuiInfo(tool);
        for(int[] p : pos) {
            t.addSlotPosition(p[0], p[1]);
        }
        TinkerRegistryClient.addToolBuilding(t);
    }
    private static void registerDefaultForgeGui(ToolCore tool) {
        TinkerRegistryClient.addToolBuilding(ToolBuildGuiInfo.default3Part(tool));
    }
    private static void registerStencil(ToolPart part) {
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
    }
}
