package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class CastItems {

    public static Map<CastType, RegistryObject<Item>> casts = new HashMap<>();

    public static void registerCasts() {
        for(CastType type : CastType.values()) {
            RegistryObject<Item> cast = Resources.ITEMS.register(String.format("cast_%s", type.name().toLowerCase()), Resources::registerItem);
            casts.put(type, cast);
        }
    }
}
