package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.DeferredRegistrerFluid;
import mrthomas20121.tinkers_reforged.api.ReforgedFluid;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class Resources {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);
    public static final DeferredRegistrerFluid FLUIDS = new DeferredRegistrerFluid();

    public static final ItemGroup group = new ItemGroup(TinkersReforged.MOD_ID) {

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(aluminum_ingot.get());
        }
    };

    public static ReforgedFluid redstone = FLUIDS.register("molten_redstone", 800, 0);
    public static ReforgedFluid blazing_copper = FLUIDS.register("molten_blazing_copper", 1700, 12);
    public static ReforgedFluid duralumin = FLUIDS.register("molten_duralumin", 1000, 7);
    public static ReforgedFluid electrical_copper = FLUIDS.register("molten_electrical_copper", 1100, 12);
    public static ReforgedFluid lavium = FLUIDS.register("molten_lavium", 1500, 12);
    public static ReforgedFluid qivium = FLUIDS.register("molten_qivium", 1500, 12);

    public static RegistryObject<Block> aluminum_ore = BLOCKS.register("aluminum_ore", Resources::registerOreBlock);
    public static RegistryObject<Item> aluminum__ore_item = ITEMS.register("aluminum_ore", () -> Resources.registerItemBlock(aluminum_ore.get()));
    public static RegistryObject<Block> aluminum_block = BLOCKS.register("aluminum_block", Resources::registerMetalBlock);
    public static RegistryObject<Item> aluminum_item_block = ITEMS.register("aluminum_block", () -> Resources.registerItemBlock(aluminum_block.get()));
    public static RegistryObject<Item> aluminum_ingot = ITEMS.register("aluminum_ingot", Resources::registerItem);
    public static RegistryObject<Item> aluminum_nugget = ITEMS.register("aluminum_nugget", Resources::registerItem);
    public static RegistryObject<Item> aluminum_dust = ITEMS.register("aluminum_dust", Resources::registerItem);

    public static RegistryObject<Block> duralumin_block = BLOCKS.register("duralumin_block", Resources::registerMetalBlock);
    public static RegistryObject<Item> duralumin_item_block = ITEMS.register("duralumin_block", () -> Resources.registerItemBlock(duralumin_block.get()));
    public static RegistryObject<Item> duralumin_ingot = ITEMS.register("duralumin_ingot", Resources::registerItem);
    public static RegistryObject<Item> duralumin_nugget = ITEMS.register("duralumin_nugget", Resources::registerItem);
    public static RegistryObject<Item> duralumin_dust = ITEMS.register("duralumin_dust", Resources::registerItem);

    public static RegistryObject<Block> electrical_copper_block = BLOCKS.register("electrical_copper_block", Resources::registerMetalBlock);
    public static RegistryObject<Item> electrical_copper_item_block = ITEMS.register("electrical_copper_block", () -> Resources.registerItemBlock(electrical_copper_block.get()));
    public static RegistryObject<Item> electrical_copper_ingot = ITEMS.register("electrical_copper_ingot", Resources::registerItem);
    public static RegistryObject<Item> electrical_copper_nugget = ITEMS.register("electrical_copper_nugget", Resources::registerItem);
    public static RegistryObject<Item> electrical_copper_dust = ITEMS.register("electrical_copper_dust", Resources::registerItem);

    public static RegistryObject<Block> lavium_block = BLOCKS.register("lavium_block", Resources::registerMetalBlock);
    public static RegistryObject<Item> lavium_item_block = ITEMS.register("lavium_block", () -> Resources.registerItemBlock(lavium_block.get()));
    public static RegistryObject<Item> lavium_ingot = ITEMS.register("lavium_ingot", Resources::registerItem);
    public static RegistryObject<Item> lavium_nugget = ITEMS.register("lavium_nugget", Resources::registerItem);
    public static RegistryObject<Item> lavium_dust = ITEMS.register("lavium_dust", Resources::registerItem);

    public static RegistryObject<Block> qivium_block = BLOCKS.register("qivium_block", Resources::registerMetalBlock);
    public static RegistryObject<Item> qivium_item_block = ITEMS.register("qivium_block", () -> Resources.registerItemBlock(qivium_block.get()));
    public static RegistryObject<Item> qivium_ingot = ITEMS.register("qivium_ingot", Resources::registerItem);
    public static RegistryObject<Item> qivium_nugget = ITEMS.register("qivium_nugget", Resources::registerItem);
    public static RegistryObject<Item> qivium_dust = ITEMS.register("qivium_dust", Resources::registerItem);

    public static Item registerItem() {
        return new Item(new Item.Properties().tab(group));
    }

    public static BlockItem registerItemBlock(Block block) {
        return new BlockItem(block, new Item.Properties().tab(group));
    }

    public static Block registerOreBlock() {
        return new Block(AbstractBlock.Properties.of(Material.STONE).strength(2.5F).sound(SoundType.STONE));
    }

    public static Block registerMetalBlock() {
        return new Block(AbstractBlock.Properties.of(Material.METAL).strength(2.5F).sound(SoundType.METAL));
    }
}
