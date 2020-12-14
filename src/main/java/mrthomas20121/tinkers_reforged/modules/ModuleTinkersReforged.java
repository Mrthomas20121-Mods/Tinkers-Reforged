package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedRegistry;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitLifeSteal;
import mrthomas20121.tinkers_reforged.trait.TraitPyromancy;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleTinkersReforged implements ModuleBase {

    MaterialGen lavium = new MaterialGen("lavium", 0x9FAF59, "Lavium", 800);
    MaterialGen qivium = new MaterialGen("qivium", 0xAF7259, "Qivium", 800);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        lavium.preInit();
        lavium.getMaterial().addTrait(TinkerTraits.momentum);
        lavium.getMaterial().addTrait(new TraitLifeSteal(), MaterialTypes.HEAD);
        TinkerRegistry.addMaterial(lavium.getMaterial());
        TinkerRegistry.addMaterialStats(lavium.getMaterial(),
                new HeadMaterialStats(1000, 12.2f, 12.2f, HarvestLevels.COBALT),
                new HandleMaterialStats(1.3f, 100),
                new ExtraMaterialStats(100),
                new BowMaterialStats(5.2f, 5.1f, 5.2f));

        qivium.preInit();
        qivium.getMaterial().addTrait(TinkerTraits.momentum);
        qivium.getMaterial().addTrait(new TraitPyromancy(), MaterialTypes.HEAD);
        TinkerRegistry.addMaterial(qivium.getMaterial());
        TinkerRegistry.addMaterialStats(qivium.getMaterial(),
                new HeadMaterialStats(1000, 12.2f, 12.2f, HarvestLevels.COBALT),
                new HandleMaterialStats(1.3f, 100),
                new ExtraMaterialStats(100),
                new BowMaterialStats(5.2f, 5.2f, 5.2f));
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        lavium.init();
        qivium.init();

        if(TinkersReforgedConfig.SettingGeneral.enableAlloyRecipes)
        {
            FluidStack ardite =FluidRegistry.getFluidStack("ardite", 288);
            FluidStack purpleslime = FluidRegistry.getFluidStack("purpleslime", 144);
            FluidStack laviumStack = FluidRegistry.getFluidStack("lavium", 144);
            FluidStack glass = FluidRegistry.getFluidStack("glass", 1000);
            FluidStack qiviumStack = FluidRegistry.getFluidStack("qivium", 144);
            FluidStack kovarStack = FluidRegistry.getFluidStack("kovar", 144);
            TinkerRegistry.registerAlloy(laviumStack, glass, new FluidStack(FluidRegistry.getFluid("cobalt"), 288), purpleslime);
            TinkerRegistry.registerAlloy(qiviumStack, glass, ardite, purpleslime);
            TinkerRegistry.registerAlloy(kovarStack, laviumStack, qiviumStack);
            TinkerSmeltery.registerOredictMeltingCasting(kovarStack.getFluid(), "Kovar");
        }
    }

    public static void registerItems(IForgeRegistry<Item> r) {
        // kovar
        ReforgedRegistry.addItem(register(r, new Item(), "kovar_ingot"));
        ReforgedRegistry.addItem(register(r, new Item(), "kovar_dust"));
        ReforgedRegistry.addItem(register(r, new Item(), "kovar_nugget"));
        ReforgedRegistry.addItem(register(r, new Item(), "kovar_plate"));
        ReforgedRegistry.addItem(register(r, new Item(), "kovar_gear"));
        // lavium
        ReforgedRegistry.addItem(register(r, new Item(), "lavium_ingot"));
        ReforgedRegistry.addItem(register(r, new Item(), "lavium_dust"));
        ReforgedRegistry.addItem(register(r, new Item(), "lavium_nugget"));
        ReforgedRegistry.addItem(register(r, new Item(), "lavium_plate"));
        ReforgedRegistry.addItem(register(r, new Item(), "lavium_gear"));
        // qivium
        ReforgedRegistry.addItem(register(r, new Item(), "qivium_ingot"));
        ReforgedRegistry.addItem(register(r, new Item(), "qivium_dust"));
        ReforgedRegistry.addItem(register(r, new Item(), "qivium_nugget"));
        ReforgedRegistry.addItem(register(r, new Item(), "qivium_plate"));
        ReforgedRegistry.addItem(register(r, new Item(), "qivium_gear"));
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }

    private static Item register(IForgeRegistry<Item> r, Item item, String name) {
        item.setRegistryName(TinkersReforged.MODID, name);
        item.setTranslationKey(TinkersReforged.MODID+"."+name);
        r.register(item);
        addOredict(item, name);
        return item;
    }

    private static void addOredict(Item item, String name) {
        String[] ores = name.split("_");
        String ore = ores[1]+StringUtils.capitalize(ores[0]);
        OreDictionary.registerOre(ore, item);
    }
}
