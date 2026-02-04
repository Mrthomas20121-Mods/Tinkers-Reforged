package mrthomas20121.tinkers_reforged.api.registry;

import mrthomas20121.tinkers_reforged.api.item.ItemGemObject;
import mrthomas20121.tinkers_reforged.api.item.ItemMetalObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;

import java.util.EnumMap;
import java.util.Locale;

public class ReforgedItemDeferredRegister extends ItemDeferredRegisterExtension {
    public ReforgedItemDeferredRegister(String modID) {
        super(modID);
    }

    public ItemMetalObject registerMetal(String metalName) {
        ItemObject<Item> ingot = register(metalName+"_ingot");
        ItemObject<Item> nugget = register(metalName+"_nugget");
        ItemObject<Item> dust = register(metalName+"_dust");
        ItemObject<Item> plate = register(metalName+"_plate");
        ItemObject<Item> gear = register(metalName+"_gear");

        return new ItemMetalObject(new ResourceLocation(this.modID, metalName), ingot, nugget, dust, plate, gear);
    }

    public <E extends Enum<E>> EnumMap<E, ItemMetalObject> registerEnumMetal(Class<E> e) {
        final EnumMap<E, ItemMetalObject> map = new EnumMap<>(e);
        E[] values = e.getEnumConstants();
        for(E value: values) {
            map.put(value, registerMetal(value.name().toLowerCase(Locale.ROOT)));
        }

        return map;
    }

    public ItemGemObject registerGem(String metalName) {
        ItemObject<Item> gem = register(metalName+"_gem");
        ItemObject<Item> nugget = register(metalName+"_nugget");
        ItemObject<Item> dust = register(metalName+"_dust");
        ItemObject<Item> plate = register(metalName+"_plate");
        ItemObject<Item> gear = register(metalName+"_gear");

        return new ItemGemObject(new ResourceLocation(this.modID, metalName), gem, nugget, dust, plate, gear);
    }
}
