package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.block.EndOreBlock;
import mrthomas20121.tinkers_reforged.block.IOreBlock;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.util.Helpers;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedItems.ITEMS;
import static mrthomas20121.tinkers_reforged.init.TinkersReforgedItems.resourceTab;

public class TinkersReforgedBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersReforged.MOD_ID);

    // block properties
    private static final BlockBehaviour.Properties METAL = Block.Properties.of(Material.METAL).strength(5F, 1200f).sound(SoundType.METAL);
    private static final BlockBehaviour.Properties ORE = Block.Properties.of(Material.STONE).strength(2.5F, 5f).sound(SoundType.STONE);
    private static final BlockBehaviour.Properties END_ORE = Block.Properties.of(Material.STONE).strength(3F, 5.5f).sound(SoundType.STONE);
    private static final BlockBehaviour.Properties DEEPSLATE_ORE = Block.Properties.of(Material.STONE).strength(2.5F, 5f).sound(SoundType.DEEPSLATE);
    private static final BlockBehaviour.Properties RAW_BLOCK = BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK);

    public static Map<EnumMetal, IOreBlock> ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal -> {
            if(metal.isThisOverworldOre()) {
                return new OverworldOreBlock(register("%s_ore".formatted(metal.getName()), () -> new Block(ORE), new Item.Properties().tab(resourceTab)), register("%s_deepslate_ore".formatted(metal.getName()), () -> new Block(DEEPSLATE_ORE), new Item.Properties().tab(resourceTab)));
            }
            else {
                return new EndOreBlock(register("%s_ore".formatted(metal.getName()), () -> new Block(ORE), new Item.Properties().tab(resourceTab)));
            }
    });

    public static Map<EnumGem, OverworldOreBlock> GEM_ORES = Helpers.mapOfKeys(EnumGem.class, metal ->
            new OverworldOreBlock(register("%s_ore".formatted(metal.getName()), () -> new Block(ORE), new Item.Properties().tab(resourceTab)), register("%s_deepslate_ore".formatted(metal.getName()), () -> new Block(DEEPSLATE_ORE), new Item.Properties().tab(resourceTab))));

    public static Map<EnumMetal, RegistryObject<Block>> RAW_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal ->
            register("raw_%s_block".formatted(metal.getName()), () -> new Block(RAW_BLOCK), new Item.Properties().tab(resourceTab)));

    public static Map<EnumMetal, Map<EnumMetal.BlockType, RegistryObject<Block>>> METAL_BLOCKS = Helpers.mapOfKeys(EnumMetal.class, metal ->
            Helpers.mapOfKeys(EnumMetal.BlockType.class, type -> register("%s_%s".formatted(metal.getName(), type.getName()), type.getBlock(), new Item.Properties().tab(resourceTab))));

    public static Map<EnumGem, RegistryObject<Block>> GEMS_BLOCKS = Helpers.mapOfKeys(EnumGem.class, gem ->
            register("%s_block".formatted(gem.getName()), () -> new Block(METAL), new Item.Properties().tab(resourceTab)));

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Item.Properties properties) {
        RegistryObject<Block> b = BLOCKS.register(name, block);

        ITEMS.register(name, () -> new BlockItem(b.get(), properties));

        return b;
    }
}
