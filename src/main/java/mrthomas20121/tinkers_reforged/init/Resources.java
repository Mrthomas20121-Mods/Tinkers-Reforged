package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.registration.ModelFluidAttributes;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

import javax.annotation.Nonnull;

public class Resources {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(TinkersReforged.MOD_ID);

    public static final ItemGroup group = new ItemGroup(TinkersReforged.MOD_ID) {

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(aluminum_ingot.get());
        }
    };

    private static FluidAttributes.Builder hotBuilder() {
        return ModelFluidAttributes.builder().density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA);
    }

    public static FluidObject<ForgeFlowingFluid> duralumin = FLUIDS.register("duralumin", hotBuilder(), Material.LAVA, 0);
    public static FluidObject<ForgeFlowingFluid> electrical_copper = FLUIDS.register("electrical_copper", hotBuilder().temperature(800), Material.LAVA, 0);
    public static FluidObject<ForgeFlowingFluid> lavium = FLUIDS.register("lavium", hotBuilder().temperature(1500), Material.LAVA, 0);
    public static FluidObject<ForgeFlowingFluid> qivium = FLUIDS.register("qivium", hotBuilder().temperature(1500), Material.LAVA, 0);

    public static RegistryObject<Block> aluminum_ore = registerBlock("aluminum_ore");
    public static RegistryObject<Block> aluminum_block = registerBlock("aluminum_block");
    public static RegistryObject<Item> aluminum_ingot = ITEMS.register("aluminum_ingot", Resources::register);
    public static RegistryObject<Item> aluminum_nugget = ITEMS.register("aluminum_nugget", Resources::register);
    public static RegistryObject<Item> aluminum_dust = ITEMS.register("aluminum_dust", Resources::register);

    public static RegistryObject<Block> duralumin_block = registerBlock("duralumin_block");
    public static RegistryObject<Item> duralumin_ingot = ITEMS.register("duralumin_ingot", Resources::register);
    public static RegistryObject<Item> duralumin_nugget = ITEMS.register("duralumin_nugget", Resources::register);
    public static RegistryObject<Item> duralumin_dust = ITEMS.register("duralumin_dust", Resources::register);

    public static RegistryObject<Block> electrical_copper_block = registerBlock("electrical_copper_block");
    public static RegistryObject<Item> electrical_copper_ingot = ITEMS.register("electrical_copper_ingot", Resources::register);
    public static RegistryObject<Item> electrical_copper_nugget = ITEMS.register("electrical_copper_nugget", Resources::register);
    public static RegistryObject<Item> electrical_copper_dust = ITEMS.register("electrical_copper_dust", Resources::register);

    public static RegistryObject<Block> lavium_block = registerBlock("lavium_block");
    public static RegistryObject<Item> lavium_ingot = ITEMS.register("lavium_ingot", Resources::register);
    public static RegistryObject<Item> lavium_nugget = ITEMS.register("lavium_nugget", Resources::register);
    public static RegistryObject<Item> lavium_dust = ITEMS.register("lavium_dust", Resources::register);

    public static RegistryObject<Block> qivium_block = registerBlock("qivium_block");
    public static RegistryObject<Item> qivium_ingot = ITEMS.register("qivium_ingot", Resources::register);
    public static RegistryObject<Item> qivium_nugget = ITEMS.register("qivium_nugget", Resources::register);
    public static RegistryObject<Item> qivium_dust = ITEMS.register("qivium_dust", Resources::register);

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }

    public static BlockItem registerItemBlock(Block block) {
        return new BlockItem(block, new Item.Properties().tab(group));
    }

    public static RegistryObject<Block> registerBlock(String name) {
        Block block = new Block(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD));
        RegistryObject<Block> blockObj = BLOCKS.register(name, () -> block);
        ITEMS.register(name, () -> registerItemBlock(blockObj.get()));
        return blockObj;
    }
}
