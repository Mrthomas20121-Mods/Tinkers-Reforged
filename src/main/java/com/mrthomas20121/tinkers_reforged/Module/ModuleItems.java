package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.item.ItemDust;
import com.mrthomas20121.libs.item.ItemGear;
import com.mrthomas20121.libs.item.ItemIngot;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.libs.item.ItemPlate;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleItems extends ModuleBase {
    public static ItemIngot laviumIngot = new ItemIngot(TinkersReforged.MODID, "lavium");
    public static ItemIngot qiviumIngot = new ItemIngot(TinkersReforged.MODID, "qivium");
    public static ItemDust laviumDust = new ItemDust(TinkersReforged.MODID, "lavium");
    public static ItemDust qiviumDust = new ItemDust(TinkersReforged.MODID, "qivium");
    public static ItemPlate laviumPlate = new ItemPlate(TinkersReforged.MODID, "lavium");
    public static ItemPlate qiviumPlate = new ItemPlate(TinkersReforged.MODID, "qivium");
    public static ItemGear laviumGear = new ItemGear(TinkersReforged.MODID, "lavium");
    public static ItemGear qiviumGear = new ItemGear(TinkersReforged.MODID, "qivium");

    public RegistryLib lavium_mat = new RegistryLib(Materials.lavium);
    public RegistryLib qivium_mat = new RegistryLib(Materials.qivium);

    public ModuleItems() {
        lavium_mat.addCommonItems("Lavium");
        lavium_mat.setCastable(true);
        lavium_mat.setCraftable(false);
        lavium_mat.registerMaterialTrait(Traits.MOB_DRAIN);
        lavium_mat.registerMaterialTrait(TinkerTraits.momentum, MaterialTypes.HEAD);
        lavium_mat.registerHeadStats(1000, 14, 5.1f, HarvestLevels.COBALT);
        lavium_mat.registerHandleStats(0.9f, 120);
        lavium_mat.registerExtraStats(400);
        lavium_mat.addIngotItem(laviumIngot);
        Materials.mats.add(lavium_mat.getMat());

        qivium_mat.addCommonItems("Qivium");
        qivium_mat.setCraftable(false).setCastable(true);
        qivium_mat.registerMaterialTrait(Traits.fireman);
        qivium_mat.registerMaterialTrait(TinkerTraits.momentum, MaterialTypes.HEAD);
        qivium_mat.registerHeadStats(1000, 11, 7f, HarvestLevels.COBALT);
        qivium_mat.registerHandleStats(0.9f, 120);
        qivium_mat.registerExtraStats(350);
        qivium_mat.addIngotItem(qiviumIngot);
        Materials.mats.add(qivium_mat.getMat());
    }

    public void preInit(FMLPreInitializationEvent e) {
        FluidRegistry.registerFluid(ModuleFluids.qivium);
        FluidRegistry.addBucketForFluid(ModuleFluids.qivium);
        FluidRegistry.registerFluid(ModuleFluids.lavium);
        FluidRegistry.addBucketForFluid(ModuleFluids.lavium);
        lavium_mat.setFluid(ModuleFluids.lavium);
        lavium_mat.registerPreInit("Lavium", ModuleFluids.lavium);
        qivium_mat.setFluid(ModuleFluids.qivium);
        qivium_mat.registerPreInit("Qivium", ModuleFluids.qivium);
    }
    public void init(FMLInitializationEvent e) {

        FluidStack cobalt = new FluidStack(FluidRegistry.getFluid("cobalt"), 288);
        FluidStack ardite = new FluidStack(FluidRegistry.getFluid("ardite"), 288);
        FluidStack purpleslime = new FluidStack(FluidRegistry.getFluid("purpleslime"), 144);
        FluidStack blueslime = new FluidStack(FluidRegistry.getFluid("blueslime"), 144);
        FluidStack laviumStack = new FluidStack(ModuleFluids.lavium, 144);
        FluidStack dirtStack = new FluidStack(FluidRegistry.getFluid("dirt"), 288);
        FluidStack qiviumStack = new FluidStack(ModuleFluids.qivium, 144);
        TinkerRegistry.registerAlloy(laviumStack, cobalt, dirtStack, blueslime);
        TinkerRegistry.registerAlloy(qiviumStack, ardite, dirtStack, purpleslime);
        this.registerDefaultMelting("Lavium", ModuleFluids.lavium, true);
        this.registerDefaultMelting("Qivium", ModuleFluids.qivium, true);
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        r.registerAll(laviumIngot, laviumDust, laviumPlate, laviumGear);
        r.registerAll(qiviumIngot, qiviumDust, qiviumPlate, qiviumGear);
        oredictRegistry("Lavium", laviumIngot, laviumDust, laviumPlate, laviumGear);
        oredictRegistry("Qivium", qiviumIngot, qiviumDust, qiviumPlate, qiviumGear);
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
        return items;
    }
}
