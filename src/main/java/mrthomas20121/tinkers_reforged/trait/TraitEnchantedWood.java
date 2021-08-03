package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.oredict.OreDictionary;

public class TraitEnchantedWood extends ReforgedTrait {

    public TraitEnchantedWood() {
        super("ref_enchanted_wood", 0x0);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        Block block = event.getState().getBlock();
        if(OreDictionary.containsMatch(false, OreDictionary.getOres("logWood"), new ItemStack(block))) {
            event.setNewSpeed(event.getOriginalSpeed()+(3+random.nextInt(7)));
        }
    }
}
