package mrthomas20121.tinkers_reforged.library.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ReforgedItemBlock extends ItemBlock {

    public ReforgedItemBlock(Block block) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setTranslationKey(block.getTranslationKey());
        this.setCreativeTab(block.getCreativeTab());
    }
}
