package mrthomas20121.tinkers_reforged.library;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Utils {

    private static String modid = "tinkers_reforged";

    public static ResourceLocation getResource(String value) {
        return new ResourceLocation(modid, value);
    }

    public static Item getItem(String itemName) {
        return getItem(getResource(itemName));
    }
    public static Item getItem(ResourceLocation itemName) {
        return ForgeRegistries.ITEMS.getValue(itemName);
    }
}
