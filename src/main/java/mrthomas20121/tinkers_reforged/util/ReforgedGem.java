package mrthomas20121.tinkers_reforged.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.function.Supplier;

public enum ReforgedGem implements EnumData {
    EPIDOTE,
    HUREAULITE,
    RED_BERYL;

    public enum ItemType implements EnumData {
        GEM,
        DUST,
        PLATE;
    }
}
