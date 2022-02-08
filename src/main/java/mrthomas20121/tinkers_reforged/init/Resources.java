package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class Resources {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);

    private static final ItemGroup group = new ItemGroup(TinkersReforged.MOD_ID) {

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(aluminum_ingot.get());
        }
    };

    public static RegistryObject<Block> aluminum_block = registerBlock("aluminum");
    public static RegistryObject<Item> aluminum_ingot = ITEMS.register("aluminum_ingot", Resources::register);
    public static RegistryObject<Item> aluminum_nugget = ITEMS.register("aluminum_nugget", Resources::register);
    public static RegistryObject<Item> aluminum_dust = ITEMS.register("aluminum_dust", Resources::register);

    public static RegistryObject<Block> duralumin_block = registerBlock("duralumin");
    public static RegistryObject<Item> duralumin_ingot = ITEMS.register("duralumin_ingot", Resources::register);
    public static RegistryObject<Item> duralumin_nugget = ITEMS.register("duralumin_nugget", Resources::register);
    public static RegistryObject<Item> duralumin_dust = ITEMS.register("duralumin_dust", Resources::register);

    public static RegistryObject<Block> electrical_copper_block = registerBlock("electrical_copper");
    public static RegistryObject<Item> electrical_copper_ingot = ITEMS.register("electrical_copper_ingot", Resources::register);
    public static RegistryObject<Item> electrical_copper_nugget = ITEMS.register("electrical_copper_nugget", Resources::register);
    public static RegistryObject<Item> electrical_copper_dust = ITEMS.register("electrical_copper_dust", Resources::register);

    public static RegistryObject<Block> lavium_block = registerBlock("lavium");
    public static RegistryObject<Item> lavium_ingot = ITEMS.register("lavium_ingot", Resources::register);
    public static RegistryObject<Item> lavium_nugget = ITEMS.register("lavium_nugget", Resources::register);
    public static RegistryObject<Item> lavium_dust = ITEMS.register("lavium_dust", Resources::register);

    public static RegistryObject<Block> qivium_block = registerBlock("qivium");
    public static RegistryObject<Item> qivium_ingot = ITEMS.register("qivium_ingot", Resources::register);
    public static RegistryObject<Item> qivium_nugget = ITEMS.register("qivium_nugget", Resources::register);
    public static RegistryObject<Item> qivium_dust = ITEMS.register("qivium_dust", Resources::register);

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }

    public static BlockItem registerItemBlock(Block block) {
        return new BlockItem(block, new Item.Properties().tab(group));
    }

    public static RegistryObject<Block> registerBlock(String metal) {
        Block block = new Block(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD));
        String name = String.format("%s_block", metal);
        RegistryObject<Block> blockObj = BLOCKS.register(name, () -> block);
        ITEMS.register(name, () -> registerItemBlock(blockObj.get()));
        return blockObj;
    }
}
