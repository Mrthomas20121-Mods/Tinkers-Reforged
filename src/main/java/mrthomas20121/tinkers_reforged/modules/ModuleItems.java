package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.objects.block.BlockGlassCustom;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.objects.item.ItemBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.Traits;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.tinkers_reforged.config.ConfigReforged;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.client.CreativeTab;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleItems implements ModuleBase {
    public static ItemBase laviumNugget = new ItemBase(TinkersReforged.MODID, "lavium_nugget");
    public static ItemBase laviumIngot = new ItemBase(TinkersReforged.MODID, "lavium_ingot");
    public static ItemBase laviumDust = new ItemBase(TinkersReforged.MODID, "lavium_dust");
    public static ItemBase laviumPlate = new ItemBase(TinkersReforged.MODID, "lavium_plate");
    public static ItemBase laviumGear = new ItemBase(TinkersReforged.MODID, "lavium_gear");

    public static ItemBase qiviumNugget = new ItemBase(TinkersReforged.MODID, "qivium_nugget");
    public static ItemBase qiviumIngot = new ItemBase(TinkersReforged.MODID, "qivium_ingot");
    public static ItemBase qiviumDust = new ItemBase(TinkersReforged.MODID, "qivium_dust");
    public static ItemBase qiviumPlate = new ItemBase(TinkersReforged.MODID, "qivium_plate");
    public static ItemBase qiviumGear = new ItemBase(TinkersReforged.MODID, "qivium_gear");

    public static ItemBase KovarNugget = new ItemBase(TinkersReforged.MODID, "kovar_nugget");
    public static ItemBase KovarIngot = new ItemBase(TinkersReforged.MODID, "kovar_ingot");
    public static ItemBase KovarDust = new ItemBase(TinkersReforged.MODID, "kovar_dust");
    public static ItemBase KovarPlate = new ItemBase(TinkersReforged.MODID, "kovar_plate");
    public static ItemBase KovarGear = new ItemBase(TinkersReforged.MODID, "kovar_gear");

    public static BlockGlassCustom kovar_glass = new BlockGlassCustom(TinkersReforged.MODID, "kovar");
    public static final CreativeTabs creativetab = new CreativeTab("tinkers_reforged",new ItemStack(laviumIngot, 1));

    public ModuleItems() {
    }

    public void preInit(FMLPreInitializationEvent e) {

        Resources.kovar.getFluidWrapper().registerFluid();

        MaterialStats baseStats = new MaterialStats();
        baseStats.setHeadMaterialStats(1000, 12.2f, 12.2f, HarvestLevels.COBALT);
        baseStats.setHandleMaterialStats(1.3f, 100);
        baseStats.setExtraMaterialStats(300);
        baseStats.setBowMaterialStats(9.2f, 7.1f, 5.2f);

        Resources.qivium.addTrait(TinkerTraits.momentum);
        Resources.qivium.addTrait(Traits.pyromancy, MaterialTypes.HEAD);
        Resources.qivium.createMaterial(baseStats);

        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(Resources.qivium, baseStats, 0);
        }
        Resources.materials.add(Resources.qivium);

        Resources.lavium.addTrait(TinkerTraits.momentum);
        Resources.lavium.addTrait(Traits.life_steal, MaterialTypes.HEAD);
        Resources.lavium.createMaterial(baseStats);

        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(Resources.lavium, baseStats, 0);
        }
        Resources.materials.add(Resources.lavium);
    }
    public void init(FMLInitializationEvent e) {
        if(ConfigReforged.alloyrecipes)
        {
            FluidStack ardite = new FluidStack(FluidRegistry.getFluid("ardite"), 288);
            FluidStack purpleslime = new FluidStack(FluidRegistry.getFluid("purpleslime"), 144);
            FluidStack laviumStack = new FluidStack(FluidRegistry.getFluid("lavium"), 144);
            FluidStack glass = new FluidStack(FluidRegistry.getFluid("glass"), 1000);
            FluidStack qiviumStack = new FluidStack(FluidRegistry.getFluid("qivium"), 144);
            FluidStack kovarStack = new FluidStack(FluidRegistry.getFluid("kovar"), 144);
            SmelteryUtils.registerAlloy(laviumStack, glass, new FluidStack(FluidRegistry.getFluid("cobalt"), 288), purpleslime);
            SmelteryUtils.registerAlloy(qiviumStack, glass, ardite, purpleslime);
            SmelteryUtils.registerAlloy(kovarStack, laviumStack, qiviumStack);
        }
        SmelteryUtils.registerDefaultMelting("Kovar", FluidRegistry.getFluid("kovar"), true);
    }

    public void postInit(FMLPostInitializationEvent e) {
        ItemStack glass_kovar = new ItemStack(kovar_glass);
        TinkerRegistry.registerBasinCasting(new CastingRecipe(glass_kovar,
        RecipeMatch.of(Blocks.GLASS),
        new FluidStack(FluidUtils.getFluid("kovar"), Material.VALUE_Block),
        true, true));

        for(String fuel : ConfigReforged.fuels)
        {
            String[] entries = fuel.split(":");
            if(Loader.isModLoaded(entries[0]))
            {
                if(FluidRegistry.isFluidRegistered(entries[1]))
                {
					Fluid fluid = FluidUtils.getFluid(entries[1]);
					fluid.setTemperature(Integer.getInteger(entries[2], 2000).intValue());
					FluidStack stack = new FluidStack(fluid, Integer.getInteger(entries[3], 1000).intValue());
                    TinkerRegistry.registerSmelteryFuel(stack, Integer.getInteger(entries[4], 1000).intValue());
                }
            }
        }
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegisterCreativeTab(genArrayList());
        IForgeRegistry<Item> r = event.getRegistry();
        r.registerAll(laviumNugget, laviumIngot, laviumDust, laviumPlate, laviumGear);
        r.registerAll(qiviumNugget, qiviumIngot, qiviumDust, qiviumPlate, qiviumGear);
        r.registerAll(KovarNugget, KovarIngot, KovarDust, KovarPlate, KovarGear);

        r.register(new ItemBlock(kovar_glass).setRegistryName(kovar_glass.getRegistryName()));

        oredictRegistry("Lavium", laviumIngot, laviumDust, laviumPlate, laviumGear, laviumNugget);
        oredictRegistry("Qivium", qiviumIngot, qiviumDust, qiviumPlate, qiviumGear, qiviumNugget);
        oredictRegistry("Kovar", KovarIngot, KovarDust, KovarPlate, KovarGear, KovarNugget);
    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        r.register(kovar_glass);
    }

    private static void oredictRegistry(String ore, Item... items) {
        for(Item item : items) {
            if(item.getRegistryName().toString().contains("gear"))  OreDictionary.registerOre("gear"+ore, item);
            else if(item.getRegistryName().toString().contains("ingot"))  OredictHelper.RegisterIngotItem(ore, item);
            else if(item.getRegistryName().toString().contains("dust"))  OreDictionary.registerOre("dust"+ore, item);
            else if(item.getRegistryName().toString().contains("plate"))  OreDictionary.registerOre("plate"+ore, item);
            else if(item.getRegistryName().toString().contains("nugget"))  OreDictionary.registerOre("nugget"+ore, item);
        }
    }

    public static ArrayList<Item> genArrayList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(laviumPlate);
        items.add(laviumDust);
        items.add(laviumGear);
        items.add(laviumIngot);
        items.add(laviumNugget);
        items.add(qiviumPlate);
        items.add(qiviumDust);
        items.add(qiviumGear);
        items.add(qiviumIngot);
        items.add(qiviumNugget);
        items.add(KovarNugget);
        items.add(KovarIngot);
        items.add(KovarDust);
        items.add(KovarPlate);
        items.add(KovarGear);
        return items;
    }
    public static void InitModels() {
        kovar_glass.initModels();
    }

    private static void RegisterCreativeTab(ArrayList<Item> items) {
        for(Item item : items) {
            item.setCreativeTab(creativetab);
        }
    }
}
