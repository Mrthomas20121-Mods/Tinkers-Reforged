package mrthomas20121.tinkers_reforged.modules;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.recipes.AltarRecipe;
import de.ellpeck.naturesaura.api.recipes.OfferingRecipe;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import de.ellpeck.naturesaura.items.ModItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.modifier.ModToken;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleNaturesAura implements ModuleBase {

    Material infused_iron = new Material("ref_infused_iron", 0x34BA3D);
    Material sky = new Material("ref_sky", 0x9BDFFF);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.infused_iron) {
            infused_iron.addTrait(ReforgedTraits.auraInfusion, MaterialTypes.HEAD);
            infused_iron.addTrait(TinkerTraits.magnetic2);
            TinkerRegistry.addMaterial(infused_iron);
            TinkerRegistry.addMaterialStats(infused_iron,
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 1.9f, 7.9f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.sky) {
            sky.addTrait(ReforgedTraits.godGift);
            sky.addTrait(ReforgedTraits.auraInfusion, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(sky);
            TinkerRegistry.addMaterialStats(sky,
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 1.9f, 7.9f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        OreDictionary.registerOre("blockInfusedIron", ModBlocks.INFUSED_IRON);
        OreDictionary.registerOre("ingotInfusedIron", ModItems.INFUSED_IRON);
        OreDictionary.registerOre("ingotSky", ModItems.SKY_INGOT);

        if(TinkersReforgedConfig.SettingMaterials.materials.infused_iron) {
            infused_iron.setCraftable(false).setCastable(false);
            infused_iron.setRepresentativeItem("ingotInfusedIron");
            infused_iron.addItemIngot("ingotInfusedIron");
            for(IToolPart part : TinkerRegistry.getToolParts()) {

                if(part.canUseMaterial(infused_iron) && (part.canBeCasted() || part.canBeCrafted())) {
                    Material mat = TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.mods.infusedIron.material);
                    ResourceLocation name = new ResourceLocation(TinkersReforged.MODID, "infusion_"+mat.getIdentifier()+"_"+part.getOutlineRenderStack().getItem().getRegistryName().getPath());
                    ItemStack input = part.getItemstackWithMaterial(mat);
                    ItemStack output = part.getItemstackWithMaterial(infused_iron);
                    NaturesAuraAPI.ALTAR_RECIPES.put(name, new AltarRecipe(name, Ingredient.fromStacks(input), output, Ingredient.EMPTY, TinkersReforgedConfig.SettingGeneral.mods.infusedIron.aura_cost, TinkersReforgedConfig.SettingGeneral.mods.infusedIron.time));
                }
            }
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.sky) {
            sky.setCraftable(false).setCastable(false);
            sky.setRepresentativeItem("ingotSky");
            sky.addItemIngot("ingotSky");
            for(IToolPart part : TinkerRegistry.getToolParts()) {

                if(part.canUseMaterial(sky) && (part.canBeCasted() || part.canBeCrafted())) {
                    Material mat = TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.mods.sky.material);
                    ResourceLocation name = new ResourceLocation(TinkersReforged.MODID, "offering_"+mat.getIdentifier()+"_"+part.getOutlineRenderStack().getItem().getRegistryName().getPath());
                    ItemStack input = part.getItemstackWithMaterial(mat);
                    input.setCount(3);
                    ItemStack output = part.getItemstackWithMaterial(sky);
                    NaturesAuraAPI.OFFERING_RECIPES.put(name, new OfferingRecipe(name, Ingredient.fromStacks(input), Ingredient.fromItem(ModItems.CALLING_SPIRIT), output));
                }
            }
        }

        ModToken token = new ModToken();
        token.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(ModItems.TOKEN_EUPHORIA), new ItemStack(ModItems.TOKEN_TERROR), new ItemStack(ModItems.TOKEN_RAGE), new ItemStack(ModItems.TOKEN_GRIEF)));
        ModuleManager.addModifier(token);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
