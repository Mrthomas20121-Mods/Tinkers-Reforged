package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsBlueSkies extends ModuleReforgedBase {

    private MaterialGen horizonnite = new MaterialGen("horizonite", 0xF27B2B, "Horizonite", 700);
    private MaterialGen charoite = new MaterialGen("charoite", 0x9A7FBA, "Charoite", 500, true);
    private MaterialGen diopside = new MaterialGen("diopside", 0x4CE849, "Diopside", 500, true);
    private MaterialGen pyrope = new MaterialGen("pyrope", 0xDA283E, "Pyrope", 500, true);
    private MaterialGen turquoise = new MaterialGen("turquoise", 0x5AE7D1, "Turquoise", 500, true);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.blue_skies;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.horizonite) {
            horizonnite.preInit();
            horizonnite.getMaterial().addTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
            horizonnite.getMaterial().addTrait(ReforgedTraits.pyromency);
            TinkerRegistry.addMaterial(horizonnite.getMaterial());
            TinkerRegistry.addMaterialStats(horizonnite.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3.5f, 2.2f, 4.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.charoite) {
            charoite.preInit();
            charoite.getMaterial().addTrait(TinkerTraits.lightweight);
            TinkerRegistry.addMaterial(charoite.getMaterial());
            TinkerRegistry.addMaterialStats(charoite.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2.5f, 3.2f, 3.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.diopside) {
            diopside.preInit();
            diopside.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(diopside.getMaterial());
            TinkerRegistry.addMaterialStats(diopside.getMaterial(),
                    new HeadMaterialStats(400, 8f, 8f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 90),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(3, 8.2f, 2.1f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.pyrope) {
            pyrope.preInit();
            pyrope.getMaterial().addTrait(ReforgedTraits.fast);
            TinkerRegistry.addMaterial(pyrope.getMaterial());
            TinkerRegistry.addMaterialStats(pyrope.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3.5f, 2.2f, 4.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.turquoise) {
            turquoise.preInit();
            turquoise.getMaterial().addTrait(TinkerTraits.fractured);
            TinkerRegistry.addMaterial(turquoise.getMaterial());
            TinkerRegistry.addMaterialStats(turquoise.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3.5f, 2.2f, 4.2f));
        }
    }

    @Override
    public void init() {
        String[] gems = { "pyrope", "turquoise", "charoite", "diopside" };

        for(String gem: gems) {
            OreDictionary.registerOre("gem"+ StringUtils.capitalize(gem), ForgeUtils.getItem(Reference.blue_skies, gem.equals("charoite")? gem: gem+"_gem"));
            OreDictionary.registerOre("ore"+ StringUtils.capitalize(gem), ForgeUtils.getBlock(Reference.blue_skies, "everdawn_"+gem+"_ore"));
            OreDictionary.registerOre("ore"+ StringUtils.capitalize(gem), ForgeUtils.getBlock(Reference.blue_skies, "everbright_"+gem+"_ore"));
            OreDictionary.registerOre("block"+ StringUtils.capitalize(gem), ForgeUtils.getBlock(Reference.blue_skies, gem+"_block"));
        }
        OreDictionary.registerOre("ingotHorizonite", ForgeUtils.getItem(Reference.blue_skies, "horizonite_ingot"));
        OreDictionary.registerOre("oreHorizonite", ForgeUtils.getBlock(Reference.blue_skies, "horizonite_ore"));
        OreDictionary.registerOre("blockHorizonnite", ForgeUtils.getBlock(Reference.blue_skies, "horizonite_block"));

        if(TinkersReforgedConfig.SettingMaterials.materials.horizonite) {
            horizonnite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.charoite) {
            charoite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.diopside) {
            diopside.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.pyrope) {
            pyrope.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.turquoise) {
            turquoise.init();
        }
    }
}
