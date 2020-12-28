package mrthomas20121.tinkers_reforged.tools;

import com.google.common.collect.Lists;

import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.TinkersReforged;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.AoeToolCore;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class Tools {

    // tool parts
    public static ToolPart clubHead;
    public static ToolPart greatBlade;
    public static ToolPart CurvedBlade;
    public static ToolPart propickHead;
    public static ToolPart lightblade;

    // tools
    public static SwordGladius gladius = null;
    public static ToolClub club = null;
    public static SwordGreatSword greatsword = null;
    public static SwordKhopesh khopesh = null;
    public static ToolRunicKnife knife = null;
    public static AoeToolCore propick = null;
    public static SwordLight swordLight = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();

        if(TinkersReforgedConfig.SettingTools.enableTools)
        {
            if(TinkersReforgedConfig.SettingTools.enableGladius) {

                gladius = new SwordGladius();
                gladius.setRegistryName(TinkersReforged.MODID, "gladius");
                gladius.setTranslationKey(TinkersReforged.MODID + ".gladius");
                r.register(gladius);
                TinkersReforged.proxy.registerToolModel(gladius);
                TinkerRegistry.registerToolForgeCrafting(gladius);
            }

            if(TinkersReforgedConfig.SettingTools.enableLightsword) {

                lightblade = new ToolPart(Material.VALUE_Ingot*3);
                lightblade.setRegistryName(TinkersReforged.MODID, "light_blade");
                lightblade.setTranslationKey(TinkersReforged.MODID+".light_blade");
                TinkersReforged.proxy.registerToolPartModel(lightblade);
                r.register(lightblade);

				swordLight = new SwordLight();
                swordLight.setRegistryName(TinkersReforged.MODID, "lightsword");
                swordLight.setTranslationKey(TinkersReforged.MODID + ".lightsword");
                r.register(swordLight);
                TinkersReforged.proxy.registerToolModel(swordLight);
                TinkerRegistry.registerToolForgeCrafting(swordLight);
                r.register(swordLight);
            }

            if(TinkersReforgedConfig.SettingTools.enableKnife && Loader.isModLoaded("roots")) {
                knife = new ToolRunicKnife();
                knife.setRegistryName(TinkersReforged.MODID, "runic_knife");
                knife.setTranslationKey(TinkersReforged.MODID + ".runic_knife");
                r.register(knife);
                TinkersReforged.proxy.registerToolModel(knife);
                TinkerRegistry.registerToolForgeCrafting(knife);
            }

            if(ModuleManager.isModLoaded("atum")) {
                if(TinkersReforgedConfig.SettingTools.enableClub)
                {
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

                if(TinkersReforgedConfig.SettingTools.enableGreatsword) {
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

                if(TinkersReforgedConfig.SettingTools.enableKhopesh) {
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

            if(ModuleManager.isModLoaded("geolosys"))
            {
                propickHead = new ToolPart(Material.VALUE_Ingot*3);
                propickHead.setRegistryName(TinkersReforged.MODID,"propick_head");
                propickHead.setTranslationKey(TinkersReforged.MODID + ".propick_head");
                TinkersReforged.proxy.registerToolPartModel(propickHead);
                r.register(propickHead);
                registerStencil(propickHead);

                propick = new ToolProPick();
                propick.setRegistryName(TinkersReforged.MODID, "propick");
                propick.setTranslationKey(TinkersReforged.MODID+".propick");
                TinkersReforged.proxy.registerToolModel(propick);
                r.register(propick);

                TinkerRegistry.registerToolForgeCrafting(propick);
            }

            for(IModifier modifier : getTinkerModifiers())
            {
                TinkersReforged.proxy.registerModifierModel(modifier,
                        new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modifier.getIdentifier()));
            }
        }
    }
    private static void registerStencil(ToolPart part) {
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
    }
    private static ArrayList<Modifier> getTinkerModifiers()
    {
        return Lists.newArrayList(
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
    }
}
