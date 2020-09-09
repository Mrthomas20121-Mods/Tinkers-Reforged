package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.config.ConfigReforged;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
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
        Resources.manasteel.builder.setCastable(false);
        Resources.manasteel.builder.setTrait(Traits.traitManaInfusion, MaterialTypes.HEAD);
        Resources.manasteel.builder.setTrait(Traits.traitManaBoost);
        Resources.manasteel.builder.setHeadStats(204, 6f, 4f, HarvestLevels.DIAMOND);
        Resources.manasteel.builder.setHandleStats(1.20f, 0);
        Resources.manasteel.builder.setExtraStats(50);

        Resources.livingwood.builder.setCraftable(false);
        Resources.livingwood.builder.setTrait(Traits.traitLiving, MaterialTypes.HEAD);
        Resources.livingwood.builder.setTrait(TinkerTraits.ecological);
        Resources.livingwood.builder.setHeadStats(200, 4f, 3f, HarvestLevels.STONE);
        Resources.livingwood.builder.setHandleStats(1f, 0);
        Resources.livingwood.builder.setExtraStats(50);

        Resources.livingrock.builder.setCraftable(false);
        Resources.livingrock.builder.setTrait(Traits.traitLiving, MaterialTypes.HEAD);
        Resources.livingrock.builder.setTrait(TinkerTraits.cheap);
        Resources.livingrock.builder.setHeadStats(199, 5f, 3f, HarvestLevels.IRON);
        Resources.livingrock.builder.setHandleStats(1.4f, 0);
        Resources.livingrock.builder.setExtraStats(0);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if(ConfigMaterials.manasteel)
        {
            Resources.manasteel.builder.setRepresentativeItem("ingotManaSteel");
            Resources.manasteel.builder.addCommonItems("Manasteel");
            Resources.manasteel.builder.addBlock("Manasteel");
            Resources.manasteel.builder.preInit("Manasteel");
        }
        if(ConfigMaterials.livingwood)
        {
            Resources.livingwood.builder.addItem("livingwood", 1);
            Resources.livingwood.builder.setRepresentativeItem("livingwood");
            Resources.livingwood.builder.preInit("livingwood");
        }
        if(ConfigMaterials.livingrock)
        {
            Resources.livingrock.builder.addItem("livingrock", 1);
            Resources.livingrock.builder.setRepresentativeItem("livingrock");
            Resources.livingrock.builder.preInit("livingrock");
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {

        OreDictionary.registerOre("blockManasteel", new ItemStack(ModBlocks.storage, 1, 0));
        OreDictionary.registerOre("blockTerrasteel", new ItemStack(ModBlocks.storage, 1, 1));
        OreDictionary.registerOre("blockElementium", new ItemStack(ModBlocks.storage, 1, 2));

        for(IToolPart part : TinkerRegistry.getToolParts())
        {
            if(part.canUseMaterial(Resources.manasteel.builder.getMat()) && ConfigMaterials.manasteel)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.manasteel.builder.getMat()), part.getItemstackWithMaterial(TinkerMaterials.iron), ConfigReforged.mana));
            }
            if(part.canUseMaterial(Resources.livingrock.builder.getMat()) && ConfigMaterials.livingrock)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.livingrock.builder.getMat()), part.getItemstackWithMaterial(TinkerMaterials.stone), ConfigReforged.mana));
            }
            if(part.canUseMaterial(Resources.livingwood.builder.getMat()) && ConfigMaterials.livingwood)
            {
                BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(part.getItemstackWithMaterial(Resources.livingwood.builder.getMat()), part.getItemstackWithMaterial(TinkerMaterials.wood), ConfigReforged.mana));
            }
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
