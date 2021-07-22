package mrthomas20121.tinkers_reforged.modules;

import de.ellpeck.naturesaura.blocks.ModBlocks;
import de.ellpeck.naturesaura.items.ModItems;
import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.compat.NaturesAuraCompat;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import mrthomas20121.tinkers_reforged.trait.modifier.ModToken;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.List;

public class MaterialsNaturesAura extends ModuleBase {

    private final Material infused_iron = new Material("ref_infused_iron", 0x34BA3D);
    private final Material sky = new Material("ref_sky", 0x9BDFFF);

    public MaterialsNaturesAura() {
        super(new ResourceLocation(Reference.naturesaura, "module"));
    }

    public static final ModToken token = new ModToken();

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.naturesaura;
    }

    @Override
    public void preInit() {
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
    public void registerModifiers(List<Modifier> modifiers) {
        if(TinkersReforgedConfig.SettingMaterials.modifiers.token) {
            token.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(ModItems.TOKEN_EUPHORIA), new ItemStack(ModItems.TOKEN_TERROR), new ItemStack(ModItems.TOKEN_RAGE), new ItemStack(ModItems.TOKEN_GRIEF)));
            modifiers.add(token);
        }
    }

    @Override
    public void init() {
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
                    ResourceLocation name = new ResourceLocation(TinkersReforged.MODID, "infusion_"+mat.getIdentifier()+"_"+part.getItemstackWithMaterial(mat).getItem().getRegistryName().getPath());
                    ItemStack input = part.getItemstackWithMaterial(mat);
                    ItemStack output = part.getItemstackWithMaterial(infused_iron);
                    NaturesAuraCompat.addAltarRecipe(name, input, output);
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
                    ResourceLocation name = new ResourceLocation(TinkersReforged.MODID, "offering_"+mat.getIdentifier()+"_"+part.getItemstackWithMaterial(mat).getItem().getRegistryName().getPath());
                    ItemStack input = part.getItemstackWithMaterial(mat);
                    input.setCount(3);
                    ItemStack output = part.getItemstackWithMaterial(sky);

                    NaturesAuraCompat.addOfferingRecipe(name, input, output);
                }
            }
        }
    }
}
