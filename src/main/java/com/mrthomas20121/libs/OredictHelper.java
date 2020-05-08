package com.mrthomas20121.libs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OredictHelper {
    public static void RegisterIngotItem(String ore, Item item) {
        OreDictionary.registerOre("ingot"+ore, item);
    }
    public static void RegisterGemItem(String ore, Item item) {
        OreDictionary.registerOre("gem"+ore, item);
    }
    public static void RegisterBucketItem(String ore, Item item) {
        OreDictionary.registerOre("bucket", item);
        OreDictionary.registerOre("bucket"+ore, item);
    }
    public static void RegisterBlock(String ore, Block block) {
        OreDictionary.registerOre("block"+ore, block);
    }
    public static void RegisterOreBlock(String ore, Block block) {
        OreDictionary.registerOre("ore"+ore, block);
    }
    public static boolean isOredictEmpty(String oredict) {
        return OreDictionary.getOres(oredict).isEmpty();
    }
    public static ItemStack removeOredict(ItemStack item, String oredict) {
        ItemStack result = ItemStack.EMPTY;
        for (ItemStack itemstack : OreDictionary.getOres(oredict)) {

            if(itemstack.getItem().getRegistryName().equals(item.getItem().getRegistryName())) {
                result = itemstack;
            }
        }
        if(!result.isEmpty()) {
            OreDictionary.getOres(oredict, false).remove(result);
        }
        return result;
    }
}
