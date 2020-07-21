package mrthomas20121.biolib;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public class SmelteryUtils {

    public static int VALUE_Gear = Material.VALUE_Ingot*4;

    public static void registerIngotCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("ingot"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
          TinkerRegistry.registerTableCasting(result, castIngot, fluid, Material.VALUE_Ingot);
        }
    }
    public static void registerCasting(String ore, Fluid fluid, int mat) {
        ItemStack result = OredictHelper.getOre(ore);
        if(!result.equals(ItemStack.EMPTY)) {
          TinkerRegistry.registerTableCasting(result, castIngot, fluid, mat);
        }
    }
    public static void registerPlateCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("plate"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
          TinkerRegistry.registerTableCasting(result, castPlate, fluid, Material.VALUE_Ingot);
        }
    }
    public static void registerGearCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("gear"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
          TinkerRegistry.registerTableCasting(result, castGear, fluid, VALUE_Gear);
        }
    }
    public static void registerGemCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("gem"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
            TinkerRegistry.registerTableCasting(result, castGem, fluid, Material.VALUE_Gem);
        }
    }
    public static void registerNuggetCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("nugget"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
            TinkerRegistry.registerTableCasting(result, castNugget, fluid, Material.VALUE_Nugget);
        }
    }
    public static void registerBlockCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("block"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
            TinkerRegistry.registerBasinCasting(result, ItemStack.EMPTY, fluid, Material.VALUE_Block);
        }
    }
    public static void registerSmallBlockCasting(String ore, Fluid fluid) {
        ItemStack result = OredictHelper.getOre("block"+ore);
        if(!result.equals(ItemStack.EMPTY)) {
            TinkerRegistry.registerBasinCasting(result, ItemStack.EMPTY, fluid, Material.VALUE_Ingot*4);
        }
    }
    public static void registerMelting(String ore, Fluid fluid) {
        registerIngotCasting(ore, fluid);
    }
    public static void registerDefaultMelting(String ore, Fluid fluid) {
        TinkerRegistry.registerMelting("ingot" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("block" + ore, fluid, Material.VALUE_Block);
        TinkerRegistry.registerMelting("ore" + ore, fluid, Material.VALUE_Ore());
        registerIngotCasting(ore, fluid);
    }
    public static void registerMelting(String ore, Fluid fluid, int mat) {
        TinkerRegistry.registerMelting(ore, fluid, mat);
    }
    public static void registerDefaultCasting(String oredict, Fluid fluid, boolean isgem) {

        String[] oredicts = { "block", "ingot", "plate", "gear", "nugget"};
        if(isgem) oredicts[1] = "gem";

        for(String ore: oredicts) {
            if(ore=="ingot") {
                registerIngotCasting(oredict, fluid);
            }
            else if(ore=="block") {
                registerBlockCasting(oredict, fluid);
            }
            else if(ore=="plate") {
                registerPlateCasting(oredict, fluid);
            }
            else if(ore=="nugget") {
                registerNuggetCasting(oredict, fluid);
            }
            else if(ore=="gear") {
                registerGearCasting(oredict, fluid);
            }
            else if(ore=="gem") {
                registerGemCasting(oredict, fluid);
            }
        }
    }
    public static void registerDefaultMelting(String ore, Fluid fluid, boolean cast) {
        TinkerRegistry.registerMelting("ingot" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("plate" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("gear" + ore, fluid, Material.VALUE_Ingot * 4);
        TinkerRegistry.registerMelting("block" + ore, fluid, Material.VALUE_Block);
        if (cast) {
            registerDefaultCasting(ore, fluid, false);
        }
    }
    public static void registerAlloy(FluidStack output, FluidStack... inputs) {
        AlloyRecipe recipe = new AlloyRecipe(output, inputs);
        TinkerRegistry.registerAlloy(recipe);
    }
    public static boolean checkIfAlloyRecipeExist(FluidStack output, FluidStack... inputs) {
        boolean exist = false;
        AlloyRecipe recipe = new AlloyRecipe(output, inputs);
        for(AlloyRecipe alloy: TinkerRegistry.getAlloys()) {
            if(alloy.equals(recipe)) {
                exist = true;
            }
        }
        return exist;
    }
}