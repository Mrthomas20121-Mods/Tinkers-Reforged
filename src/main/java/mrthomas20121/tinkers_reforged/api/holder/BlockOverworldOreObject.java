package mrthomas20121.tinkers_reforged.api.holder;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.Objects;
import java.util.function.Supplier;

public class BlockOverworldOreObject extends BlockOreObject {

    private final Supplier<? extends DropExperienceBlock> deepslate;

    public BlockOverworldOreObject(ItemObject<DropExperienceBlock> ore, ItemObject<DropExperienceBlock> deepslate, ItemObject<Block> raw_ore_block, ItemObject<Item> raw_ore_item) {
        super(ore, raw_ore_block, raw_ore_item);
        this.deepslate = deepslate;
    }

    public DropExperienceBlock getDeepslateOre() {
        return Objects.requireNonNull(deepslate.get(), "BlockOreObject is missing a deepslate ore block");
    }
}
