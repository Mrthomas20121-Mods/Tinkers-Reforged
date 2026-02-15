package mrthomas20121.tinkers_reforged.api.holder;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.Objects;

public class BlockOreObject extends ItemObject<DropExperienceBlock> {

    private final ItemObject<Block> rawOreBlock;
    private final ItemObject<Item> rawOreItem;

    public BlockOreObject(ItemObject<DropExperienceBlock> ore, ItemObject<Block> RAW_ORE_BLOCK, ItemObject<Item> RAW_ORE_ITEM) {
        super(ore);
        rawOreBlock = RAW_ORE_BLOCK;
        rawOreItem = RAW_ORE_ITEM;
    }

    public Block getRawOreBlock() {
        return Objects.requireNonNull(rawOreBlock.get(), "BlockOreObject is missing a raw ore block");
    }

    public Item getRawItem() {
        return Objects.requireNonNull(rawOreItem.get(), "BlockOreObject is missing a raw ore item");
    }
}
