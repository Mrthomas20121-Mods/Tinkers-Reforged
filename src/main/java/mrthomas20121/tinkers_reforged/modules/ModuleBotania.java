package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.biolib.library.Registry;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitLiving;
import mrthomas20121.tinkers_reforged.trait.TraitManaBoost;
import mrthomas20121.tinkers_reforged.trait.TraitManaInfusion;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.common.block.ModBlocks;

public class ModuleBotania implements ModuleBase {

    Material manasteel = new Material("manasteel", 0x3389FF);
    Material livingwood = new Material("livingwood", 0x2E1106);
    Material livingrock = new Material("livingrock", 0xCCCEBC);
    Material dreamwood = new Material("dreamwood", 0xA6BCB6);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(manasteel.getIdentifier())) {
            manasteel.addTrait(new TraitManaInfusion(), MaterialTypes.HEAD);
            manasteel.addTrait(new TraitManaBoost());
            TinkerRegistry.addMaterial(manasteel);
            TinkerRegistry.addMaterialStats(manasteel,
                    new HeadMaterialStats(204, 6f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 9),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.5f, 1.4f, 7f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(livingwood.getIdentifier())) {
            livingwood.addTrait(new TraitLiving());
            TinkerRegistry.addMaterial(livingwood);
            TinkerRegistry.addMaterialStats(livingwood,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.IRON),
                    new HandleMaterialStats(1.2f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(2f, 1.7f, 5f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(livingrock.getIdentifier())) {
            livingrock.addTrait(new TraitLiving());
            TinkerRegistry.addMaterial(livingrock);
            TinkerRegistry.addMaterialStats(livingrock,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.IRON),
                    new HandleMaterialStats(1.2f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3f, 1.7f, 3f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dreamwood.getIdentifier())) {
            dreamwood.addTrait(TinkerTraits.ecological);
            TinkerRegistry.addMaterial(dreamwood);
            TinkerRegistry.addMaterialStats(dreamwood,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.3f, 0),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3f, 1.7f, 3f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(manasteel.getIdentifier())) {
            manasteel.setRepresentativeItem("ingotManasteel");
            for(IToolPart part : TinkerRegistry.getToolParts())
            {
                if(part.canUseMaterial(manasteel))
                {
                    BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(manasteel), part.getItemstackWithMaterial(TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.infusionMaterial)), TinkersReforgedConfig.SettingGeneral.manaCost));
                }
            }
            OreDictionary.registerOre("blockManasteel", new ItemStack(ModBlocks.storage, 1, 0));
            Registry.addBToolForgeBlock("blockManasteel");
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(livingwood.getIdentifier())) {
            livingwood.addItem(ModBlocks.livingwood, 1);
            livingwood.setRepresentativeItem(ModBlocks.livingwood);
            livingwood.setCraftable(true);
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(livingrock.getIdentifier())) {
            livingwood.addItem(ModBlocks.livingwood, 1);
            livingwood.setRepresentativeItem(ModBlocks.livingwood);
            livingwood.setCraftable(true);
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dreamwood.getIdentifier())) {
            dreamwood.setCraftable(true);
            dreamwood.addItem(ModBlocks.dreamwood, 1);
            dreamwood.setRepresentativeItem(ModBlocks.dreamwood);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
