package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.item.ItemMetalObject;
import mrthomas20121.tinkers_reforged.api.registry.ReforgedItemDeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;

public class TinkersReforgedItems {

    public static ReforgedItemDeferredRegister ITEMS = new ReforgedItemDeferredRegister(TinkersReforged.MOD_ID);

    public static DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersReforged.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        TABS.register(bus);
    }

    public static EnumMap<Metal, ItemMetalObject> METALS = ITEMS.registerEnumMetal(Metal.class);

    public static RegistryObject<CreativeModeTab> METAL_TAB = TABS.register("metal_tabs", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(METALS.get(Metal.GRAPHITE).get()))
            .title(Component.translatable("itemGroup.tinkers_reforged.metal"))
            .displayItems(TinkersReforgedItems::displayMetals).build());

    private static void displayMetals(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output tab) {
        for(Metal metal: Metal.values) {
            String name = metal.getSerializedName();
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            tab.accept(itemMetalObject.getIngot());
            tab.accept(itemMetalObject.getNugget());
            tab.accept(itemMetalObject.getDust());
            tab.accept(itemMetalObject.getPlate());
            tab.accept(itemMetalObject.getGear());
        }
    }
}
