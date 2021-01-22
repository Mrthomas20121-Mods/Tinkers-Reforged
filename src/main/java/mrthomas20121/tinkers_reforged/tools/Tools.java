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
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class Tools {

    // tool parts
    public static ToolPart clubHead;
    public static ToolPart greatBlade;
    public static ToolPart curvedBlade;
    public static ToolPart propickHead;
    public static ToolPart lightblade;

    // tools
    public static SwordGladius gladius = null;
    public static ToolClub club = null;
    public static SwordGreat greatsword = null;
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
                gladius = registerTool(r, "gladius", new SwordGladius());
            }

            if(TinkersReforgedConfig.SettingTools.enableLightsword) {
                lightblade = registerPart(r, "light_blade", Material.VALUE_Ingot*3);
				swordLight = registerTool(r, "lightsword", new SwordLight());
            }

            if(TinkersReforgedConfig.SettingTools.enableKnife && Loader.isModLoaded("roots")) {
                knife = registerTool(r, "runic_knife", new ToolRunicKnife());
            }

            if(ModuleManager.isModLoaded("atum") && TinkersReforgedConfig.SettingMaterials.modules.atum) {
                if(TinkersReforgedConfig.SettingTools.enableClub)
                {
                    clubHead = registerPart(r, "club_head", Material.VALUE_Ingot*3);
                    club = registerTool(r, "club", new ToolClub());
                }

                if(TinkersReforgedConfig.SettingTools.enableGreatsword) {
                    greatBlade = registerPart(r, "great_blade", Material.VALUE_Ingot*4);
                    greatsword = registerTool(r, "greatsword", new SwordGreat());
                }

                if(TinkersReforgedConfig.SettingTools.enableKhopesh) {
                    curvedBlade = registerPart(r, "curved_blade", Material.VALUE_Ingot*3);
                    khopesh = registerTool(r, "khopesh", new SwordKhopesh());
                }
            }

            if(ModuleManager.isModLoaded("geolosys"))
            {
                propickHead = registerPart(r, "propick_head", Material.VALUE_Ingot*3);
                propick = registerTool(r, "propick", new ToolProPick());
            }

            for(IModifier modifier : getTinkerModifiers())
            {
                TinkersReforged.proxy.registerModifierModel(modifier,
                        new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modifier.getIdentifier()));
            }
        }
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

    private static ToolPart registerPart(IForgeRegistry<Item> r, String name, int cost) {
        ToolPart part = new ToolPart(cost);
        part.setRegistryName(TinkersReforged.MODID,name);
        part.setTranslationKey(TinkersReforged.MODID + "."+name);
        TinkersReforged.proxy.registerToolPartModel(part);
        r.register(part);
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
        return part;
    }

    private static <T extends ToolCore> T registerTool(IForgeRegistry<Item> r, String name, T tool) {
        tool.setRegistryName(TinkersReforged.MODID,name);
        tool.setTranslationKey(TinkersReforged.MODID + "."+name);
        TinkersReforged.proxy.registerToolModel(tool);
        r.register(tool);
        TinkerRegistry.registerToolForgeCrafting(tool);
        return tool;
    }
}
