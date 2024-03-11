package mrthomas20121.tinkers_reforged.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public record OverworldOreBlock(RegistryObject<Block> ore, RegistryObject<Block> deepslateOre) implements IOreBlock {
}
