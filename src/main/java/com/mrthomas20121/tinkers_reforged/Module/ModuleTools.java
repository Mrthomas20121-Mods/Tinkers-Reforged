package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Config.ConfigModules;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Tools.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.typesafe.config.Optional;
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

    // tool parts
    public static ToolPart clubHead;
    public static ToolPart greatBlade;
    public static ToolPart CurvedBlade;

    // tools
    public static SwordGladius gladius;
    public static ToolClub club;
    public static SwordGreatSword greatsword;
    public static SwordKhopesh khopesh;
    public static ToolRunicKnife knife;

    public void preInit(FMLPreInitializationEvent e) {

    }
    public void init(FMLInitializationEvent e) {
        if(Config.tools) {
            // gladius
            if(Config.toolGladius) {
                TinkerRegistry.registerToolForgeCrafting(gladius);
                registerDefaultForgeRecipe(gladius, 3);
            }
            // knife
            if(Config.toolRunedKnife && Loader.isModLoaded("roots")) {
                TinkerRegistry.registerToolForgeCrafting(knife);
                registerDefaultForgeRecipe(knife, 3);
            }
            // club
            if((Config.toolClub && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
                TinkerRegistry.registerToolForgeCrafting(club);
                registerStencil(clubHead);
                registerDefaultForgeRecipe(club, 2);
            }
            // greatsword
            if((Config.toolGreatsword && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
                TinkerRegistry.registerToolForgeCrafting(greatsword);
                registerStencil(greatBlade);
                registerDefaultForgeRecipe(greatsword, 3);
            }
            // khopesh
            if((Config.toolKhopesh && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
                TinkerRegistry.registerToolForgeCrafting(khopesh);
                registerStencil(CurvedBlade);
                registerDefaultForgeRecipe(khopesh, 3);
            }
        }
        else {
            TinkersReforged.logger.info("Tool module is disabled");
        }
    }

    public static void postInit(FMLPostInitializationEvent event) { }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        if(ConfigModules.naturesaura && Loader.isModLoaded("naturesaura")) {
            TinkerTools.registerToolForgeBlock(registry, "blockInfusedIron");
        }

        if(ConfigModules.thermal && Loader.isModLoaded("thermalfoundation")) {
            TinkerTools.registerToolForgeBlock(registry, "blockConstantan");
            TinkerTools.registerToolForgeBlock(registry, "blockLumium");
            TinkerTools.registerToolForgeBlock(registry, "blockSignalum");
            TinkerTools.registerToolForgeBlock(registry, "blockEnderium");
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();

        if(Config.toolGladius) {

            gladius = new SwordGladius();
            gladius.setRegistryName(TinkersReforged.MODID, "gladius");
            gladius.setTranslationKey(TinkersReforged.MODID + ".gladius");
            r.register(gladius);
            TinkersReforged.proxy.registerToolModel(gladius);
        }

        if(Config.toolRunedKnife && Loader.isModLoaded("roots")) {
            knife = new ToolRunicKnife();
            knife.setRegistryName(TinkersReforged.MODID, "runic_knife");
            knife.setTranslationKey(TinkersReforged.MODID + ".runic_knife");
            r.register(knife);
            TinkersReforged.proxy.registerToolModel(knife);
        }

        if((Config.toolClub && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
            clubHead = new ToolPart(Material.VALUE_Ingot*3);
            clubHead.setRegistryName(TinkersReforged.MODID,"club_head");
            clubHead.setTranslationKey(TinkersReforged.MODID + ".club_head");
            r.register(clubHead);
            TinkersReforged.proxy.registerToolPartModel(clubHead);

            club = new ToolClub();
            club.setRegistryName(TinkersReforged.MODID, "club");
            club.setTranslationKey(TinkersReforged.MODID + ".club");
            r.register(club);
            TinkersReforged.proxy.registerToolModel(club);
        }

        if((Config.toolGreatsword && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
            greatBlade = new ToolPart(Material.VALUE_Ingot*4);
            greatBlade.setRegistryName(TinkersReforged.MODID,"great_blade");
            greatBlade.setTranslationKey(TinkersReforged.MODID + ".great_blade");
            r.register(greatBlade);
            TinkersReforged.proxy.registerToolPartModel(greatBlade);

            greatsword = new SwordGreatSword();
            greatsword.setRegistryName(TinkersReforged.MODID, "greatsword");
            greatsword.setTranslationKey(TinkersReforged.MODID + ".greatsword");
            TinkersReforged.proxy.registerToolModel(greatsword);
            r.register(greatsword);
        }

        if((Config.toolKhopesh && Loader.isModLoaded("atum")) || !(Config.atum_requirement_for_tools)) {
            CurvedBlade = new ToolPart(Material.VALUE_Ingot*3);
            CurvedBlade.setRegistryName(TinkersReforged.MODID,"curved_blade");
            CurvedBlade.setTranslationKey(TinkersReforged.MODID + ".curved_blade");
            TinkersReforged.proxy.registerToolPartModel(CurvedBlade);
            r.register(CurvedBlade);

            khopesh = new SwordKhopesh();
            khopesh.setRegistryName(TinkersReforged.MODID, "khopesh");
            khopesh.setTranslationKey(TinkersReforged.MODID + ".khopesh");
            TinkersReforged.proxy.registerToolModel(khopesh);
            r.register(khopesh);
        }
    }

    private static void registerDefaultForgeRecipe(ToolCore tool, @Optional  int nb) {
        ToolBuildGuiInfo info = new ToolBuildGuiInfo(tool);

        if(nb == 2) {
            info.addSlotPosition(33 - 20 - 1, 42 + 20);
            info.addSlotPosition(33 - 2 - 1, 42 + 2);
        }
        else if(nb == 3) {
            info.addSlotPosition(33 - 20 - 1, 42 + 20);
            info.addSlotPosition(33 + 20 - 5, 42 - 20 + 4);
            info.addSlotPosition(33 - 2 - 1, 42 + 2);
        }
        TinkerRegistryClient.addToolBuilding(info);
    }
    private static void registerStencil(ToolPart part) {
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
    }
}
