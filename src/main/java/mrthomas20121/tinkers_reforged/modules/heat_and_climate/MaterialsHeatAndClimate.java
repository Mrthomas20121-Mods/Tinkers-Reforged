package mrthomas20121.tinkers_reforged.modules.heat_and_climate;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsHeatAndClimate implements ModuleBase {

    private MaterialGen nickel_silver = new MaterialGen("nickelsilver", 0xC6D2D1, "Nickelsilver", 800);
    private MaterialGen tool_steel = new MaterialGen("tool_steel", 0x85AB93, "ToolSteel", 900);
    private MaterialGen titanium_alloy = new MaterialGen("titanium_alloy", 0x9F8E73, "TitaniumAlloy", 700);
    private MaterialGen mangalloy = new MaterialGen("mangalloy", 0xC66B6E, "Mangalloy", 700);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.nickel_silver) {
            nickel_silver.preInit();
            nickel_silver.getMaterial().addTrait(TinkerTraits.magnetic);
            TinkerRegistry.addMaterial(nickel_silver.getMaterial());
            TinkerRegistry.addMaterialStats(nickel_silver.getMaterial(),
                    new HeadMaterialStats(500, 7.5f, 8, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.1f, 100),
                    new ExtraMaterialStats(20));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.tool_steel) {
            tool_steel.preInit();
            tool_steel.getMaterial().addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            tool_steel.getMaterial().addTrait(TinkerTraits.stiff);
            TinkerRegistry.addMaterial(tool_steel.getMaterial());
            TinkerRegistry.addMaterialStats(tool_steel.getMaterial(),
                    new HeadMaterialStats(1200, 16.5f, 17, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(0.9f, 500),
                    new ExtraMaterialStats(100));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.titanium_alloy) {
            titanium_alloy.preInit();
            titanium_alloy.getMaterial().addTrait(TinkerTraits.lightweight, MaterialTypes.HEAD);
            titanium_alloy.getMaterial().addTrait(TinkerTraits.crumbling);
            TinkerRegistry.addMaterial(titanium_alloy.getMaterial());
            TinkerRegistry.addMaterialStats(titanium_alloy.getMaterial(),
                    new HeadMaterialStats(500, 11.5f, 13, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.5f, 80),
                    new ExtraMaterialStats(10));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.mangalloy) {
            mangalloy.preInit();
            mangalloy.getMaterial().addTrait(TinkerTraits.lightweight, MaterialTypes.HEAD);
            mangalloy.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(mangalloy.getMaterial());
            TinkerRegistry.addMaterialStats(mangalloy.getMaterial(),
                    new HeadMaterialStats(500, 17.5f, 18, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.5f, 120),
                    new ExtraMaterialStats(10));
        }


    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(FluidRegistry.isFluidRegistered("manganese")) {
            TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("manganese"), "Manganese");
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.nickel_silver) {
            nickel_silver.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.tool_steel) {
            tool_steel.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.titanium_alloy) {
            titanium_alloy.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.mangalloy) {
            mangalloy.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
