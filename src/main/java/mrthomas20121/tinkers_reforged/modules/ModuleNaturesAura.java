package mrthomas20121.tinkers_reforged.modules;

import de.ellpeck.naturesaura.items.ModItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitAuraInfusion;
import mrthomas20121.tinkers_reforged.trait.TraitGodGift;
import mrthomas20121.tinkers_reforged.trait.modifier.ModToken;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleNaturesAura implements ModuleBase {

    MaterialGen infused_iron = new MaterialGen("infused_iron", 0x0,"InfusedIron", 700);
    MaterialGen sky = new MaterialGen("material_of_the_sky", 0x0,"Sky", 500);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(infused_iron.getIdentifier())) {
            infused_iron.preInit();
            infused_iron.getMaterial().addTrait(new TraitAuraInfusion(), MaterialTypes.HEAD);
            infused_iron.getMaterial().addTrait(TinkerTraits.magnetic2);
            TinkerRegistry.addMaterial(infused_iron.getMaterial());
            TinkerRegistry.addMaterialStats(infused_iron.getMaterial(),
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 1.9f, 7.9f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(sky.getIdentifier())) {
            sky.preInit();
            sky.getMaterial().addTrait(new TraitGodGift());
            sky.getMaterial().addTrait(new TraitAuraInfusion(), MaterialTypes.HEAD);
            TinkerRegistry.addMaterialStats(sky.getMaterial(),
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 1.9f, 7.9f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(infused_iron.getIdentifier())) {
            infused_iron.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(sky.getIdentifier())) {
            sky.init();
        }

        ModToken token = new ModToken();
        token.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(ModItems.TOKEN_EUPHORIA), new ItemStack(ModItems.TOKEN_TERROR), new ItemStack(ModItems.TOKEN_RAGE), new ItemStack(ModItems.TOKEN_GRIEF)));
        TinkersReforged.proxy.registerModifierModel(token,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + token.getIdentifier()));
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
