package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
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
            BlockMetalObject blockMetalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            if(metal.equals(Metal.YTTRIUM)) {
                tab.accept(TinkersReforgedBlocks.YTTRIUM_ORE.get());
                tab.accept(TinkersReforgedBlocks.YTTRIUM_ORE.getDeepslateOre());
                tab.accept(TinkersReforgedBlocks.YTTRIUM_ORE.getRawOreBlock());
                tab.accept(TinkersReforgedBlocks.YTTRIUM_ORE.getRawItem());
            }
            else if(metal.equals(Metal.BARIUM)) {
                tab.accept(TinkersReforgedBlocks.BARIUM_ORE.get());
                tab.accept(TinkersReforgedBlocks.BARIUM_ORE.getRawOreBlock());
                tab.accept(TinkersReforgedBlocks.BARIUM_ORE.getRawItem());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                tab.accept(TinkersReforgedBlocks.THALLIUM_ORE.get());
                tab.accept(TinkersReforgedBlocks.THALLIUM_ORE.getRawOreBlock());
                tab.accept(TinkersReforgedBlocks.THALLIUM_ORE.getRawItem());
            }

            tab.accept(blockMetalObject.get());
            tab.accept(blockMetalObject.getPlatform());
            tab.accept(itemMetalObject.getIngot());
            tab.accept(itemMetalObject.getNugget());
            tab.accept(itemMetalObject.getDust());
            tab.accept(itemMetalObject.getPlate());
            tab.accept(itemMetalObject.getGear());
        }

        tab.accept(TinkersReforgedFluids.CHARRED_PRISMARINE.getBucket());
        tab.accept(TinkersReforgedFluids.MOLTEN_SERANDITE.getBucket());
        tab.accept(TinkersReforgedFluids.MOLTEN_URANOPHANE.getBucket());
        for(Metal metal: Metal.values) {
            tab.accept(TinkersReforgedFluids.METALS.get(metal).getBucket());
        }
    }
}
