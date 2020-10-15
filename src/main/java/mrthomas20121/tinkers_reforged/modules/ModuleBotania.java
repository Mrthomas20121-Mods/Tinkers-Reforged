package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.trait.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.config.ConfigReforged;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.common.block.ModBlocks;

public class ModuleBotania implements ModuleBase {

    public ModuleBotania()
    {

    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        MaterialStats living = new MaterialStats();
        living.setHeadMaterialStats(200, 4f, 4f, HarvestLevels.IRON);
        living.setHandleMaterialStats(1.4f, 0);
        living.setExtraMaterialStats(0);
        living.setBowMaterialStats(0.9f, 1.7f, 5f);

        if(ConfigMaterials.manasteel)
        {
            MaterialStats manasteelStats = new MaterialStats();
            manasteelStats.setHeadMaterialStats(204, 6f, 4f, HarvestLevels.DIAMOND);
            manasteelStats.setHandleMaterialStats(1.2f, 9);
            manasteelStats.setExtraMaterialStats(50);
            manasteelStats.setBowMaterialStats(0.5f, 1.4f, 7f);

            Resources.manasteel.addTrait(Traits.traitManaInfusion, MaterialTypes.HEAD);
            Resources.manasteel.addTrait(Traits.traitManaBoost);
            Resources.manasteel.setOredict();
            Resources.manasteel.createIngotMaterial(manasteelStats);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.manasteel, manasteelStats, 1f);
            }
        }
        if(ConfigMaterials.livingwood)
        {
            Resources.livingwood.setOredict("");
            Resources.livingwood.addTrait(Traits.traitLiving, MaterialTypes.HEAD);
            Resources.livingwood.addTrait(TinkerTraits.cheapskate);
            Resources.livingwood.createMaterial(living, "livingwood");
        }
        if(ConfigMaterials.livingrock)
        {
            Resources.livingrock.setOredict("");
            Resources.livingrock.addTrait(Traits.traitLiving, MaterialTypes.HEAD);
            Resources.livingrock.addTrait(TinkerTraits.cheapskate);
            Resources.livingrock.createMaterial(living, "livingrock");
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {

        OreDictionary.registerOre("blockManasteel", new ItemStack(ModBlocks.storage, 1, 0));
        OreDictionary.registerOre("blockTerrasteel", new ItemStack(ModBlocks.storage, 1, 1));
        OreDictionary.registerOre("blockElementium", new ItemStack(ModBlocks.storage, 1, 2));

        String[] data = ConfigReforged.materialsBotania.split(":");
        Material manasteel = TinkerRegistry.getMaterial(data[0]);
        Material livingwood = TinkerRegistry.getMaterial(data[1]);
        Material livingrock = TinkerRegistry.getMaterial(data[2]);

        for(IToolPart part : TinkerRegistry.getToolParts())
        {
            if(part.canUseMaterial(Resources.manasteel.getMaterial()) && ConfigMaterials.manasteel)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.manasteel.getMaterial()), part.getItemstackWithMaterial(manasteel), ConfigReforged.mana));
            }
            if(part.canUseMaterial(Resources.livingrock.getMaterial()) && ConfigMaterials.livingrock)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.livingrock.getMaterial()), part.getItemstackWithMaterial(livingrock), ConfigReforged.mana));
            }
            if(part.canUseMaterial(Resources.livingwood.getMaterial()) && ConfigMaterials.livingwood)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.livingwood.getMaterial()), part.getItemstackWithMaterial(livingwood), ConfigReforged.mana));
            }
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
