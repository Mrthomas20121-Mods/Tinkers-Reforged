package mrthomas20121.tinkers_reforged.api.registry;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOverworldOreObject;
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
import slimeknights.tconstruct.shared.block.SlimesteelBlock;

import java.util.EnumMap;
import java.util.Locale;

public class ReforgedBlockDeferredRegister extends BlockDeferredRegisterExtension {

    public ReforgedBlockDeferredRegister(String modID) {
        super(modID);
    }

    public BlockMetalObject registerMetal(String name) {
        ItemObject<Block> block = register(name + "_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(4.0f, 4.0f)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<PlatformBlock> platform = register(name + "_platform", () -> new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).noOcclusion()), (b) -> new BlockItem(b, new Item.Properties()));
        return new BlockMetalObject(block, platform);
    }

    public BlockMetalObject registerSlimeMetal(String name) {
        ItemObject<Block> block = register(name + "_block", () -> new SlimesteelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).instrument(NoteBlockInstrument.IRON_XYLOPHONE).noOcclusion().requiresCorrectToolForDrops().strength(4.0f, 4.0f)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<PlatformBlock> platform = register(name + "_platform", () -> new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0F, 6.0F).noOcclusion()), (b) -> new BlockItem(b, new Item.Properties()));
        return new BlockMetalObject(block, platform);
    }

    public BlockOverworldOreObject registerOverworldOre(String name) {
        ItemObject<DropExperienceBlock> ore = register(name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<DropExperienceBlock> deepslate_ore = register("deepslate_"+ name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<Block> rawOreBlock = register(name + "_raw_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<Item> raw_ore_item = new ItemObject<>(this.itemRegister.register("raw_" + name, () -> new Item(new Item.Properties())));
        return new BlockOverworldOreObject(ore, deepslate_ore, rawOreBlock, raw_ore_item);
    }

    public BlockOreObject registerOre(String name) {
        ItemObject<DropExperienceBlock> ore = register(name + "_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<Block> rawOreBlock = register(name + "_raw_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)), (b) -> new BlockItem(b, new Item.Properties()));
        ItemObject<Item> raw_ore_item = new ItemObject<>(this.itemRegister.register("raw_" + name, () -> new Item(new Item.Properties())));
        return new BlockOreObject(ore, rawOreBlock, raw_ore_item);
    }

    public EnumMap<Metal, BlockMetalObject> registerEnumMetal(Class<Metal> e) {
        final EnumMap<Metal, BlockMetalObject> map = new EnumMap<>(e);
        Metal[] values = Metal.values;
        for(Metal value: values) {
            if(value.getSerializedName().contains("slime")) {
                map.put(value, registerSlimeMetal(value.name().toLowerCase(Locale.ROOT)));
            }
            else {
                map.put(value, registerMetal(value.name().toLowerCase(Locale.ROOT)));
            }
        }

        return map;
    }
}
