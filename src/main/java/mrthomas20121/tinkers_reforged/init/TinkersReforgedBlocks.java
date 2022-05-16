package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TinkersReforgedBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);

    // block properties
    private static final BlockBehaviour.Properties METAL = Block.Properties.of(Material.METAL).strength(5F, 1200f).sound(SoundType.METAL);
    private static final BlockBehaviour.Properties ORE = Block.Properties.of(Material.STONE).strength(2.5F, 5f).sound(SoundType.STONE);
    private static final BlockBehaviour.Properties RAW_BLOCK = BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK);

    public static RegistryObject<Block> aluminum_ore = BLOCKS.register("aluminum_ore", () -> new Block(ORE));
    public static RegistryObject<Block> deepslate_aluminum_ore = BLOCKS.register("deepslate_aluminum_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));
    public static RegistryObject<Block> aluminum_block = BLOCKS.register("aluminum_block", () -> new Block(METAL));
    public static RegistryObject<Block> raw_aluminum_block = BLOCKS.register("raw_aluminum_block", () -> new Block(RAW_BLOCK));
    public static RegistryObject<Block> duralumin_block = BLOCKS.register("duralumin_block", () -> new Block(METAL));
    public static RegistryObject<Block> electrical_copper_block = BLOCKS.register("electrical_copper_block", () -> new Block(METAL));
    public static RegistryObject<Block> felsteel_block = BLOCKS.register("felsteel_block", () -> new Block(METAL));
    public static RegistryObject<Block> gausum_block = BLOCKS.register("gausum_block", () -> new Block(METAL));
    public static RegistryObject<Block> kepu_ore = BLOCKS.register("kepu_ore", () -> new Block(ORE));
    public static RegistryObject<Block> raw_kepu_block = BLOCKS.register("raw_kepu_block", () -> new Block(RAW_BLOCK));
    public static RegistryObject<Block> kepu_block = BLOCKS.register("kepu_block", () -> new Block(METAL));
    public static RegistryObject<Block> lavium_block = BLOCKS.register("lavium_block", () -> new Block(METAL));
    public static RegistryObject<Block> qivium_block = BLOCKS.register("qivium_block", () -> new Block(METAL));
    public static RegistryObject<Block> chorus_metal_block = BLOCKS.register("chorus_metal_block", () -> new Block(METAL));

}
