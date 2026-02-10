package mrthomas20121.tinkers_reforged.api.registry;

import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
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

    public ItemObject<DropExperienceBlock> registerOre(String name) {
        return register(name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
    }

    public BlockOreObject registerOverworldOre(String name) {
        ItemObject<DropExperienceBlock> ore = register(name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<DropExperienceBlock> deepslate_ore = register("deepslate_"+ name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
        return new BlockOreObject(ore, deepslate_ore);
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
