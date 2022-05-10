package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TinkersReforgedBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);

    public static RegistryObject<Block> aluminum_ore = BLOCKS.register("aluminum_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.5F).sound(SoundType.STONE)));
    public static RegistryObject<Block> aluminum_block = BLOCKS.register("aluminum_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
    public static RegistryObject<Block> electrical_copper_block = BLOCKS.register("electrical_copper_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
    public static RegistryObject<Block> duralumin_block = BLOCKS.register("duralumin_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
    public static RegistryObject<Block> gausum_block = BLOCKS.register("gausum_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
    public static RegistryObject<Block> lavium_block = BLOCKS.register("lavium_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
    public static RegistryObject<Block> qivium_block = BLOCKS.register("qivium_block", () -> new Block(Block.Properties.of(Material.STONE).strength(4F).sound(SoundType.METAL)));
}
