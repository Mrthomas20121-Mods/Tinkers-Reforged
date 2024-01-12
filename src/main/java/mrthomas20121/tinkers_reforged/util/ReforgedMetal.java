package mrthomas20121.tinkers_reforged.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public enum ReforgedMetal implements EnumData {
    ALUMINUM(true),
    BLAZIUM,
    BOMIN,
    DURALUMIN,
    DURASTEEL,
    ELECTRIC_COPPER,
    ETRYX,
    FEROBOLT,
    GALLIUM(true),
    HOSIUM,
    KEPU(true),
    LAVIUM,
    MOSITE,
    QIVIUM,
    TIBERIUM,
    TITANIUM(true);

    private final boolean isOre;

    ReforgedMetal(boolean isOre) {
        this.isOre = isOre;
    }

    ReforgedMetal() {
        this(false);
    }

    public boolean isThisOre() {
        return isOre;
    }

    public enum BlockType implements EnumData {
        BLOCK(() -> new Block(BlockBehaviour.Properties.of(Material.METAL))),
        PLATFORM(() -> new PlatformBlock(BlockBehaviour.Properties.of(Material.METAL)));

        private final Supplier<Block> consumer;

        BlockType(Supplier<Block> consumer) {
            this.consumer = consumer;
        }

        public Supplier<Block> getBlock() {
            return this.consumer;
        }
    }

    public enum ItemType implements EnumData {
        INGOT,
        NUGGET,
        DUST,
        PLATE;
    }
}
