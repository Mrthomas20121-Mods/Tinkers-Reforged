package mrthomas20121.tinkers_reforged.api.registry;

import mrthomas20121.tinkers_reforged.api.block.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.item.ItemMetalObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.BlockDeferredRegisterExtension;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import java.util.EnumMap;
import java.util.Locale;

public class ReforgedBlockDeferredRegister extends BlockDeferredRegisterExtension {

    public ReforgedBlockDeferredRegister(String modID) {
        super(modID);
    }

    public BlockMetalObject registerMetal(String name) {
        ItemObject<Block> block = register(name + "_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0f)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<PlatformBlock> platform = register(name + "_platform", () -> new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).noOcclusion()), (b) -> new BlockItem(b, new Item.Properties()));
        return new BlockMetalObject(block, platform);
    }

    public <E extends Enum<E>> EnumMap<E, BlockMetalObject> registerEnumMetal(Class<E> e) {
        final EnumMap<E, BlockMetalObject> map = new EnumMap<>(e);
        E[] values = e.getEnumConstants();
        for(E value: values) {
            map.put(value, registerMetal(value.name().toLowerCase(Locale.ROOT)));
        }

        return map;
    }
}
