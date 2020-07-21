package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.block.BlockGlassCustom;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.item.ItemBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.biolib.common.OredictHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
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

    private static int level = HarvestLevels.COBALT;

    public MaterialBuilder lavium_mat = new MaterialBuilder(Materials.lavium);
    public MaterialBuilder qivium_mat = new MaterialBuilder(Materials.qivium);
    public MaterialBuilder kovar_mat = new MaterialBuilder(Materials.kovar);

    public ModuleItems() {
        lavium_mat.setCastable(true);
        lavium_mat.setCraftable(false);
        lavium_mat.setTrait(TinkerTraits.momentum);
        lavium_mat.setTrait(Traits.life_steal, MaterialTypes.HEAD);
        lavium_mat.setHeadStats(1000, 14, 5.1f, level);
        lavium_mat.setHandleStats(0.9f, 120);
        lavium_mat.setExtraStats(400);

        qivium_mat.setCraftable(false).setCastable(true);
        qivium_mat.setTrait(TinkerTraits.momentum);
        qivium_mat.setTrait(Traits.pyromancy, MaterialTypes.HEAD);
        qivium_mat.setHeadStats(1000, 11, 7f, level);
        qivium_mat.setHandleStats(0.9f, 120);
        qivium_mat.setExtraStats(350);

        kovar_mat.setCraftable(false).setCastable(true);
    }

    public void preInit(FMLPreInitializationEvent e) {

        qivium_mat.setFluid(ModuleFluids.qivium);
        qivium_mat.addCommonItems("Qivium");
        qivium_mat.setRepresentativeItem("ingotQivium");
        qivium_mat.preInit("Qivium", ModuleFluids.qivium);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(qivium_mat, 0);
        }
        Materials.mats.add(qivium_mat.getMat());

        lavium_mat.setFluid(ModuleFluids.lavium);
        lavium_mat.addCommonItems("Lavium");
        lavium_mat.setRepresentativeItem("ingotLavium");
        lavium_mat.preInit("Lavium", ModuleFluids.lavium);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(lavium_mat, 0);
        }
        Materials.mats.add(lavium_mat.getMat());
    }
    public void init(FMLInitializationEvent e) {
        FluidStack ardite = new FluidStack(FluidRegistry.getFluid("ardite"), 288);
        FluidStack purpleslime = new FluidStack(FluidRegistry.getFluid("purpleslime"), 144);
        FluidStack laviumStack = new FluidStack(ModuleFluids.lavium, 144);
        FluidStack glass = new FluidStack(FluidRegistry.getFluid("glass"), 1000);
        FluidStack qiviumStack = new FluidStack(ModuleFluids.qivium, 144);
        FluidStack kovarStack = new FluidStack(ModuleFluids.kovar, 144);
        SmelteryUtils.registerAlloy(laviumStack, glass, new FluidStack(FluidRegistry.getFluid("cobalt"), 288), purpleslime);
        SmelteryUtils.registerAlloy(qiviumStack, glass, ardite, purpleslime);
        SmelteryUtils.registerAlloy(kovarStack, laviumStack, qiviumStack);
        SmelteryUtils.registerDefaultMelting("Kovar", ModuleFluids.kovar, true);
    }
    public void postInit(FMLPostInitializationEvent e) {
        ItemStack glass_kovar = new ItemStack(kovar_glass);
        TinkerRegistry.registerBasinCasting(new CastingRecipe(glass_kovar,
        RecipeMatch.of(Blocks.GLASS),
        new FluidStack(ModuleFluids.kovar, Material.VALUE_Block),
        true, true));
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
