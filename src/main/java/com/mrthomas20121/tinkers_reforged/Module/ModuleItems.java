package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.block.BlockGlassDefault;
import com.mrthomas20121.libs.item.ItemDust;
import com.mrthomas20121.libs.item.ItemGear;
import com.mrthomas20121.libs.item.ItemIngot;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.libs.item.ItemPlate;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import com.mrthomas20121.libs.OredictHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.*;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.TinkerSmeltery.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleItems extends ModuleBase {
    public static ItemIngot laviumIngot = new ItemIngot(TinkersReforged.MODID, "lavium");
    public static ItemDust laviumDust = new ItemDust(TinkersReforged.MODID, "lavium");
    public static ItemPlate laviumPlate = new ItemPlate(TinkersReforged.MODID, "lavium");
    public static ItemGear laviumGear = new ItemGear(TinkersReforged.MODID, "lavium");

    public static ItemIngot qiviumIngot = new ItemIngot(TinkersReforged.MODID, "qivium");
    public static ItemDust qiviumDust = new ItemDust(TinkersReforged.MODID, "qivium");
    public static ItemPlate qiviumPlate = new ItemPlate(TinkersReforged.MODID, "qivium");
    public static ItemGear qiviumGear = new ItemGear(TinkersReforged.MODID, "qivium");

    public static ItemIngot KovarIngot = new ItemIngot(TinkersReforged.MODID, "kovar");
    public static ItemDust KovarDust = new ItemDust(TinkersReforged.MODID, "kovar");
    public static ItemPlate KovarPlate = new ItemPlate(TinkersReforged.MODID, "kovar");
    public static ItemGear KovarGear = new ItemGear(TinkersReforged.MODID, "kovar");

    public static BlockGlassDefault kovar_glass = new BlockGlassDefault(TinkersReforged.MODID, "kovar");

    private static int level = 5;

    public RegistryLib lavium_mat = new RegistryLib(Materials.lavium);
    public RegistryLib qivium_mat = new RegistryLib(Materials.qivium);
    public RegistryLib kovar_mat = new RegistryLib(Materials.kovar);

    public ModuleItems() {
        lavium_mat.setCastable(true);
        lavium_mat.setCraftable(false);
        lavium_mat.registerMaterialTrait(TinkerTraits.momentum);
        lavium_mat.registerMaterialTrait(Traits.life_steal, MaterialTypes.HEAD);
        lavium_mat.registerHeadStats(1000, 14, 5.1f, level);
        lavium_mat.registerHandleStats(0.9f, 120);
        lavium_mat.registerExtraStats(400);

        qivium_mat.setCraftable(false).setCastable(true);
        qivium_mat.registerMaterialTrait(TinkerTraits.momentum);
        qivium_mat.registerMaterialTrait(Traits.fireman, MaterialTypes.HEAD);
        qivium_mat.registerHeadStats(1000, 11, 7f, level);
        qivium_mat.registerHandleStats(0.9f, 120);
        qivium_mat.registerExtraStats(350);

        kovar_mat.setCraftable(false).setCastable(true);
    }

    public void preInit(FMLPreInitializationEvent e) {

        HarvestLevels.harvestLevelNames.put(level, lavium_mat.getMat().getTextColor() + Util.translate("ui.mininglevel.lavium"));

        // register Oredicts
        oredictRegistry("Lavium", laviumIngot, laviumDust, laviumPlate, laviumGear);
        oredictRegistry("Qivium", qiviumIngot, qiviumDust, qiviumPlate, qiviumGear);
        oredictRegistry("Kovar", KovarIngot, KovarDust, KovarPlate, KovarGear);

        Materials.mats.add(qivium_mat.getMat());
        FluidRegistry.registerFluid(ModuleFluids.qivium);
        FluidRegistry.addBucketForFluid(ModuleFluids.qivium);
        qivium_mat.setFluid(ModuleFluids.qivium);
        qivium_mat.addCommonItems("Qivium");
        qivium_mat.setRepresentativeItem("ingotQivium");
        qivium_mat.registerPreInit("ingotQivium", ModuleFluids.qivium);

        Materials.mats.add(lavium_mat.getMat());
        FluidRegistry.registerFluid(ModuleFluids.lavium);
        FluidRegistry.addBucketForFluid(ModuleFluids.lavium);
        lavium_mat.setFluid(ModuleFluids.lavium);
        lavium_mat.addCommonItems("Lavium");
        lavium_mat.registerPreInit("ingotLavium", ModuleFluids.lavium);

        ModuleFluids.kovar.setDensity(8);
        ModuleFluids.kovar.setTemperature(750);
        FluidRegistry.registerFluid(ModuleFluids.kovar);
        FluidRegistry.addBucketForFluid(ModuleFluids.kovar);
    }
    public void init(FMLInitializationEvent e) {

        //lavium_mat.addCommonItems("Lavium");
        //qivium_mat.addCommonItems("Qivium");
        FluidStack ardite = new FluidStack(FluidRegistry.getFluid("ardite"), 288);
        FluidStack purpleslime = new FluidStack(FluidRegistry.getFluid("purpleslime"), 144);
        FluidStack blueslime = new FluidStack(FluidRegistry.getFluid("blueslime"), 144);
        FluidStack laviumStack = new FluidStack(ModuleFluids.lavium, 144);
        FluidStack glass = new FluidStack(FluidRegistry.getFluid("glass"), 1000);
        FluidStack qiviumStack = new FluidStack(ModuleFluids.qivium, 144);
        FluidStack kovarStack = new FluidStack(ModuleFluids.kovar, 144);
        TinkerRegistry.registerAlloy(laviumStack, glass, new FluidStack(FluidRegistry.getFluid("cobalt"), 288), blueslime);
        TinkerRegistry.registerAlloy(qiviumStack, glass, ardite, purpleslime);

        if(!OredictHelper.isOredictEmpty("ingotNickel")) {
            FluidStack cobalt = new FluidStack(FluidRegistry.getFluid("cobalt"), Material.VALUE_Block);
            FluidStack nickel = new FluidStack(FluidRegistry.getFluid("nickel"), 288);
            FluidStack iron = new FluidStack(FluidRegistry.getFluid("iron"), 144);
            TinkerRegistry.registerAlloy(kovarStack, cobalt, nickel, iron);
        }
        this.registerDefaultMelting("Lavium", ModuleFluids.lavium, true);
        this.registerDefaultMelting("Qivium", ModuleFluids.qivium, true);
    }
    public void postInit(FMLPostInitializationEvent e) {
        ItemStack kovarglass = new ItemStack(kovar_glass);
        ItemStack glass = new ItemStack(Blocks.GLASS);
        //TinkerRegistry.registerBasinCasting(kovarglass, glass, ModuleFluids.kovar, Material.VALUE_Block);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        r.registerAll(laviumIngot, laviumDust, laviumPlate, laviumGear);
        r.registerAll(qiviumIngot, qiviumDust, qiviumPlate, qiviumGear);
        r.registerAll(KovarIngot, KovarDust, KovarPlate, KovarGear);
    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        r.register(kovar_glass);
    }

    public static void oredictRegistry(String ore, Item... items) {
        for(Item item : items) {
            if(item.getRegistryName().toString().contains("gear"))  OreDictionary.registerOre("gear"+ore, item);
            else if(item.getRegistryName().toString().contains("ingot"))  OreDictionary.registerOre("ingot"+ore, item);
            else if(item.getRegistryName().toString().contains("dust"))  OreDictionary.registerOre("dust"+ore, item);
            else if(item.getRegistryName().toString().contains("plate"))  OreDictionary.registerOre("plate"+ore, item);
        }
    }

    public static ArrayList<Item> genArrayList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(laviumPlate);
        items.add(laviumDust);
        items.add(laviumGear);
        items.add(laviumIngot);
        items.add(qiviumPlate);
        items.add(qiviumDust);
        items.add(qiviumGear);
        items.add(qiviumIngot);
        items.add(KovarIngot);
        items.add(KovarDust);
        items.add(KovarPlate);
        items.add(KovarGear);
        return items;
    }
}
