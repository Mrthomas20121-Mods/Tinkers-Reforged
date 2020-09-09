package mrthomas20121.tinkers_reforged.modules;

import com.google.common.collect.Lists;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.config.ConfigModule;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.ConfigReforged;
import mrthomas20121.tinkers_reforged.tools.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleTools implements ModuleBase {

    // tool parts
    public static ToolPart clubHead;
    public static ToolPart greatBlade;
    public static ToolPart CurvedBlade;

    // tools
    public static SwordGladius gladius = null;
    public static ToolClub club = null;
    public static SwordGreatSword greatsword = null;
    public static SwordKhopesh khopesh = null;
    public static ToolRunicKnife knife = null;

    public void preInit(FMLPreInitializationEvent e)
    {
    }
    public void init(FMLInitializationEvent e)
    {
        for(IModifier modifier : getTinkerModifiers())
        {
            TinkersReforged.proxy.registerModifierModel(modifier,
                    new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modifier.getIdentifier()));
        }
    }

    public void postInit(FMLPostInitializationEvent event) { }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();

        TinkerTools.registerToolForgeBlock(registry, "blockTitanium");
        TinkerTools.registerToolForgeBlock(registry, "blockAluminium");
        TinkerTools.registerToolForgeBlock(registry, "blockIridium");
        TinkerTools.registerToolForgeBlock(registry, "blockRuby");
        TinkerTools.registerToolForgeBlock(registry, "blockAmethyst");
        TinkerTools.registerToolForgeBlock(registry, "blockSapphire");

        if(ConfigModule.naturesaura) {
            TinkerTools.registerToolForgeBlock(registry, "blockInfusedIron");
        }

        if(ConfigModule.thermalfoundation) {
            TinkerTools.registerToolForgeBlock(registry, "blockConstantan");
            TinkerTools.registerToolForgeBlock(registry, "blockLumium");
            TinkerTools.registerToolForgeBlock(registry, "blockSignalum");
            TinkerTools.registerToolForgeBlock(registry, "blockEnderium");
        }
        if(ConfigModule.botania) {
            TinkerTools.registerToolForgeBlock(registry, "blockManasteel");
            TinkerTools.registerToolForgeBlock(registry, "blockElementium");
            TinkerTools.registerToolForgeBlock(registry, "blockTerrasteel");
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();

        if(ConfigReforged.tools)
        {
            if(ConfigReforged.gladius) {

                gladius = new SwordGladius();
                gladius.setRegistryName(TinkersReforged.MODID, "gladius");
                gladius.setTranslationKey(TinkersReforged.MODID + ".gladius");
                r.register(gladius);
                TinkersReforged.proxy.registerToolModel(gladius);
                TinkerRegistry.registerToolForgeCrafting(gladius);
            }

            if(ConfigReforged.runedKnife && Loader.isModLoaded("roots")) {
                knife = new ToolRunicKnife();
                knife.setRegistryName(TinkersReforged.MODID, "runic_knife");
                knife.setTranslationKey(TinkersReforged.MODID + ".runic_knife");
                r.register(knife);
                TinkersReforged.proxy.registerToolModel(knife);
                TinkerRegistry.registerToolForgeCrafting(knife);
            }

            if(ConfigReforged.club && Loader.isModLoaded("atum")) {
                clubHead = new ToolPart(Material.VALUE_Ingot*3);
                clubHead.setRegistryName(TinkersReforged.MODID,"club_head");
                clubHead.setTranslationKey(TinkersReforged.MODID + ".club_head");
                r.register(clubHead);
                TinkersReforged.proxy.registerToolPartModel(clubHead);
                registerStencil(clubHead);

                club = new ToolClub();
                club.setRegistryName(TinkersReforged.MODID, "club");
                club.setTranslationKey(TinkersReforged.MODID + ".club");
                r.register(club);
                TinkersReforged.proxy.registerToolModel(club);
                TinkerRegistry.registerToolForgeCrafting(club);
            }

            if(ConfigReforged.greatsword && Loader.isModLoaded("atum")) {
                greatBlade = new ToolPart(Material.VALUE_Ingot*4);
                greatBlade.setRegistryName(TinkersReforged.MODID,"great_blade");
                greatBlade.setTranslationKey(TinkersReforged.MODID + ".great_blade");
                r.register(greatBlade);
                TinkersReforged.proxy.registerToolPartModel(greatBlade);
                registerStencil(greatBlade);

                greatsword = new SwordGreatSword();
                greatsword.setRegistryName(TinkersReforged.MODID, "greatsword");
                greatsword.setTranslationKey(TinkersReforged.MODID + ".greatsword");
                TinkersReforged.proxy.registerToolModel(greatsword);
                r.register(greatsword);
                TinkerRegistry.registerToolForgeCrafting(greatsword);
            }

            if(ConfigReforged.khopesh && Loader.isModLoaded("atum")) {
                CurvedBlade = new ToolPart(Material.VALUE_Ingot*3);
                CurvedBlade.setRegistryName(TinkersReforged.MODID,"curved_blade");
                CurvedBlade.setTranslationKey(TinkersReforged.MODID + ".curved_blade");
                TinkersReforged.proxy.registerToolPartModel(CurvedBlade);
                r.register(CurvedBlade);
                registerStencil(CurvedBlade);

                khopesh = new SwordKhopesh();
                khopesh.setRegistryName(TinkersReforged.MODID, "khopesh");
                khopesh.setTranslationKey(TinkersReforged.MODID + ".khopesh");
                TinkersReforged.proxy.registerToolModel(khopesh);
                r.register(khopesh);
                TinkerRegistry.registerToolForgeCrafting(khopesh);
            }
        }
    }
    private static void registerStencil(ToolPart part) {
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
    }
    private static ArrayList<IModifier> getTinkerModifiers()
    {
        ArrayList<IModifier> modifiers = Lists.newArrayList(
                TinkerModifiers.modBaneOfArthopods,
                TinkerModifiers.modBeheading,
                TinkerModifiers.modDiamond,
                TinkerModifiers.modEmerald,
                TinkerModifiers.modGlowing,
                TinkerModifiers.modHaste,
                TinkerModifiers.modFiery,
                TinkerModifiers.modKnockback,
                TinkerModifiers.modLuck,
                TinkerModifiers.modMendingMoss,
                TinkerModifiers.modNecrotic,
                TinkerModifiers.modReinforced,
                TinkerModifiers.modSharpness,
                TinkerModifiers.modShulking,
                TinkerModifiers.modSilktouch,
                TinkerModifiers.modSmite,
                TinkerModifiers.modSoulbound,
                TinkerModifiers.modWebbed,
                TinkerModifiers.modBlasting
        );
        return modifiers;
    }
}
