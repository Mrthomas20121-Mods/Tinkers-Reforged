package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleCommonMaterials implements ModuleBase {

    public ModuleCommonMaterials() {

        Resources.sapphire.builder.setTrait(Traits.carbon, MaterialTypes.HEAD);
        Resources.sapphire.builder.setTrait(TinkerTraits.sharp);
        Resources.sapphire.builder.setHeadStats(300, 5f, 5f, HarvestLevels.DIAMOND);
        Resources.sapphire.builder.setHandleStats(1.2f, 5);
        Resources.sapphire.builder.setExtraStats(30);

        Resources.ruby.builder.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        Resources.ruby.builder.setTrait(TinkerTraits.sharp);
        Resources.ruby.builder.setHeadStats(300, 5f, 5f, HarvestLevels.DIAMOND);
        Resources.ruby.builder.setHandleStats(1.2f, 5);
        Resources.ruby.builder.setExtraStats(30);

        Resources.amethyst.builder.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        Resources.amethyst.builder.setTrait(TinkerTraits.sharp);
        Resources.amethyst.builder.setHeadStats(300, 6f, 5f, HarvestLevels.DIAMOND);
        Resources.amethyst.builder.setHandleStats(1, 200);
        Resources.amethyst.builder.setExtraStats(30);

        Resources.platinum.builder.setTrait(TinkerTraits.dense);
        Resources.platinum.builder.setHeadStats(500, 7.0f, 6.5f, HarvestLevels.OBSIDIAN);
        Resources.platinum.builder.setHandleStats(0.9f, 90);
        Resources.platinum.builder.setExtraStats(10);
        Resources.platinum.builder.setBowStats(2, 1.5f, 7);

        Resources.iridium.builder.setHeadStats(500, 7.1f, 6.4f, HarvestLevels.OBSIDIAN);
        Resources.iridium.builder.setHandleStats(1f, 90);
        Resources.iridium.builder.setExtraStats(15);
        Resources.iridium.builder.setTrait(TinkerTraits.dense);
        Resources.iridium.builder.setBowStats(2, 1.5f, 7);

        Resources.invar.builder.setHeadStats(500, 5.7f, 6.3f, HarvestLevels.OBSIDIAN);
        Resources.invar.builder.setHandleStats(1f, 90);
        Resources.invar.builder.setExtraStats(15);
        Resources.invar.builder.setTrait(TinkerTraits.hellish);
        Resources.invar.builder.setBowStats(2, 1.5f, 7);

        Resources.aluminium.builder.setHeadStats(450, 6.1f, 6f, HarvestLevels.OBSIDIAN);
        Resources.aluminium.builder.setHandleStats(1f, 70);
        Resources.aluminium.builder.setExtraStats(30);
        Resources.aluminium.builder.setTrait(TinkerTraits.dense);
        Resources.aluminium.builder.setBowStats(2, 1.5f, 7);

        Resources.titanium.builder.setHeadStats(480, 6.1f, 6f, HarvestLevels.OBSIDIAN);
        Resources.titanium.builder.setHandleStats(1.2f, 0);
        Resources.titanium.builder.setExtraStats(5);
        Resources.titanium.builder.setTrait(TinkerTraits.lightweight);
        Resources.titanium.builder.setBowStats(2, 1.5f, 7);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        Resources.ruby.registerFluid();
        Resources.platinum.registerFluid();
        Resources.iridium.registerFluid();
        Resources.aluminium.registerFluid();
        Resources.invar.registerFluid();
        Resources.amethyst.registerFluid();
        Resources.sapphire.registerFluid();
        Resources.titanium.registerFluid();

        if(ConfigMaterials.platinum)
        {
            Resources.platinum.builder.addCommonItems("Platinum");
            Resources.platinum.builder.preInit("Platinum", FluidUtils.getFluid("platinum"));
            Resources.materials.add(Resources.platinum);
        }
        if(ConfigMaterials.iridium)
        {
            Resources.iridium.builder.addCommonItems("Iridium");
            Resources.iridium.builder.preInit("iridium", FluidUtils.getFluid("iridium"));
            Resources.materials.add(Resources.iridium);
        }
        if(ConfigMaterials.invar)
        {
            Resources.invar.builder.addCommonItems("Invar");
            Resources.invar.builder.preInit("Invar", FluidUtils.getFluid("invar"));
            Resources.materials.add(Resources.invar);
        }
        if(ConfigMaterials.aluminium)
        {
            Resources.aluminium.builder.addCommonItems("Aluminium");
            Resources.aluminium.builder.preInit("Aluminium", FluidUtils.getFluid("aluminium"));
            Resources.materials.add(Resources.aluminium);
        }
        if(ConfigMaterials.titanium)
        {
            Resources.titanium.builder.addCommonItems("Titanium");
            Resources.titanium.builder.preInit("Titanium", FluidUtils.getFluid("titanium"));
            Resources.materials.add(Resources.titanium);
        }
        if(ConfigMaterials.amethyst)
        {
            Resources.amethyst.builder.addItem("Amethyst", Material.VALUE_Ingot);
            Resources.amethyst.builder.setRepresentativeItem("gemAmethyst");
            Resources.amethyst.builder.preInit("Amethyst", FluidUtils.getFluid("amethyst"));
            Resources.materials.add(Resources.amethyst);
        }
        if(ConfigMaterials.sapphire)
        {
            Resources.sapphire.builder.addItem("Sapphire", Material.VALUE_Ingot);
            Resources.sapphire.builder.setRepresentativeItem("gemSapphire");
            Resources.sapphire.builder.preInit("Sapphire",FluidUtils.getFluid("sapphire"));
            Resources.materials.add(Resources.sapphire);
        }
        if(ConfigMaterials.ruby)
        {
            Resources.ruby.builder.addItem("Ruby", Material.VALUE_Ingot);
            Resources.ruby.builder.addCommonItems("Ruby");
            Resources.ruby.builder.setRepresentativeItem("gemRuby");
            Resources.ruby.builder.preInit("Ruby", FluidUtils.getFluid("ruby"));
            Resources.materials.add(Resources.ruby);
        }

        if(Loader.isModLoaded("conarm"))
        {
            if(ConfigMaterials.titanium) armorUtils.setArmorStats(Resources.titanium.builder, 1);
            if(ConfigMaterials.invar) armorUtils.setArmorStats(Resources.invar.builder, 1);
            if(ConfigMaterials.platinum) armorUtils.setArmorStats(Resources.platinum.builder, 1);
            if(ConfigMaterials.iridium) armorUtils.setArmorStats(Resources.iridium.builder, 1);
            if(ConfigMaterials.aluminium) armorUtils.setArmorStats(Resources.aluminium.builder, 1);
            if(ConfigMaterials.amethyst) armorUtils.setArmorStats(Resources.amethyst.builder, 2);
            if(ConfigMaterials.ruby) armorUtils.setArmorStats(Resources.ruby.builder, 0);
            if(ConfigMaterials.sapphire) armorUtils.setArmorStats(Resources.sapphire.builder, 0);
        }
    }

    @Override
    public void init(FMLInitializationEvent e) {}
    @Override
    public void postInit(FMLPostInitializationEvent e) {}
}
