package mrthomas20121.tinkers_reforged.library;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ForgeUtils {

    public static Block getBlock(String mod, String name) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(mod, name));
    }

    public static Item getItem(String mod, String name) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(mod, name));
    }

    public static ItemStack getItemStack(String mod, String name, int meta) {
        return new ItemStack(getItem(mod, name), 1, meta);
    }
}
