package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.registry.ReforgedBlockDeferredRegister;
import net.minecraft.world.level.block.DropExperienceBlock;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.EnumMap;

public class TinkersReforgedBlocks {

    public static ReforgedBlockDeferredRegister BLOCKS = new ReforgedBlockDeferredRegister(TinkersReforged.MOD_ID);

    public static EnumMap<Metal, BlockMetalObject> METAl_BLOCKS = BLOCKS.registerEnumMetal(Metal.class);

    public static BlockOreObject YTTRIUM_ORE = BLOCKS.registerOverworldOre("yttrium");
    public static ItemObject<DropExperienceBlock> BARIUM_ORE = BLOCKS.registerOre("barium");
    public static ItemObject<DropExperienceBlock> THALLIUM_ORE = BLOCKS.registerOre("thallium");
}
