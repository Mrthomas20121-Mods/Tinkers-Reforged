package mrthomas20121.tinkers_reforged.api.block;

import net.minecraft.world.level.block.Block;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.Objects;
import java.util.function.Supplier;

public class BlockMetalObject extends ItemObject<Block> {

    private final Supplier<? extends PlatformBlock> platform;

    public BlockMetalObject(ItemObject<Block> block, ItemObject<PlatformBlock> platform) {
        super(block);
        this.platform = platform;
    }

    public PlatformBlock getPlatform() {
        return Objects.requireNonNull(platform.get(), "BlockMetalObject is missing platform block");
    }
}
