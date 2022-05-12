package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class TinkersReforgedItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);

    public static Map<CastType, RegistryObject<Item>> casts = new HashMap<>();

    public static final CreativeModeTab group = new CreativeModeTab(TinkersReforged.MOD_ID) {

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(aluminum_ingot.get());
        }
    };

    public static RegistryObject<Item> aluminum_ingot = ITEMS.register("aluminum_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_dust = ITEMS.register("aluminum_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_nugget = ITEMS.register("aluminum_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_block = ITEMS.register("aluminum_block", () -> registerItemBlock(TinkersReforgedBlocks.aluminum_block.get()));
    public static RegistryObject<Item> aluminum_ore = ITEMS.register("aluminum_ore", () -> registerItemBlock(TinkersReforgedBlocks.aluminum_ore.get()));

    public static RegistryObject<Item> duralumin_ingot = ITEMS.register("duralumin_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_dust = ITEMS.register("duralumin_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_nugget = ITEMS.register("duralumin_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_block = ITEMS.register("duralumin_block", () -> registerItemBlock(TinkersReforgedBlocks.duralumin_block.get()));

    public static RegistryObject<Item> electrical_copper_ingot = ITEMS.register("electrical_copper_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_dust = ITEMS.register("electrical_copper_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_nugget = ITEMS.register("electrical_copper_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_block = ITEMS.register("electrical_copper_block", () -> registerItemBlock(TinkersReforgedBlocks.electrical_copper_block.get()));

    public static RegistryObject<Item> felsteel_ingot = ITEMS.register("felsteel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_dust = ITEMS.register("felsteel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_nugget = ITEMS.register("felsteel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_block = ITEMS.register("felsteel_block", () -> registerItemBlock(TinkersReforgedBlocks.felsteel_block.get()));

    public static RegistryObject<Item> gausum_ingot = ITEMS.register("gausum_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_dust = ITEMS.register("gausum_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_nugget = ITEMS.register("gausum_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_block = ITEMS.register("gausum_block", () -> registerItemBlock(TinkersReforgedBlocks.gausum_block.get()));

    public static RegistryObject<Item> kepu_ingot = ITEMS.register("kepu_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> kepu_dust = ITEMS.register("kepu_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> kepu_nugget = ITEMS.register("kepu_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> kepu_block = ITEMS.register("kepu_block", () -> registerItemBlock(TinkersReforgedBlocks.kepu_block.get()));
    public static RegistryObject<Item> kepu_ore = ITEMS.register("kepu_ore", () -> registerItemBlock(TinkersReforgedBlocks.kepu_ore.get()));

	public static RegistryObject<Item> lavium_ingot = ITEMS.register("lavium_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_dust = ITEMS.register("lavium_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_nugget = ITEMS.register("lavium_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_block = ITEMS.register("lavium_block", () -> registerItemBlock(TinkersReforgedBlocks.lavium_block.get()));

	public static RegistryObject<Item> qivium_ingot = ITEMS.register("qivium_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_dust = ITEMS.register("qivium_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_nugget = ITEMS.register("qivium_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_block = ITEMS.register("qivium_block", () -> registerItemBlock(TinkersReforgedBlocks.qivium_block.get()));

    public static RegistryObject<Item> shulker_metal_ingot = ITEMS.register("shulker_metal_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> shulker_metal_dust = ITEMS.register("shulker_metal_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> shulker_metal_nugget = ITEMS.register("shulker_metal_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> shulker_metal_block = ITEMS.register("shulker_metal_block", () -> registerItemBlock(TinkersReforgedBlocks.shulker_metal_block.get()));

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }

    public static BlockItem registerItemBlock(Block block) {
        return new BlockItem(block, new Item.Properties().tab(group));
    }

    public static void registerCasts() {
        for(CastType type : CastType.values()) {
            RegistryObject<Item> cast = TinkersReforgedItems.ITEMS.register(String.format("cast_%s", type.name().toLowerCase()), TinkersReforgedItems::register);
            casts.put(type, cast);
        }
    }
}
