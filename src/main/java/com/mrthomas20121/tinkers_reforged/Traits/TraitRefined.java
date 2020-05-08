package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRefined extends AbstractTrait {

    private static int speed = 5;
    public TraitRefined() {
        super("reforged_refined", 0x463763);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if(this.isToolWithTrait(tool)) {
            if(event.getState().getBlock().getLocalizedName().toLowerCase().contains("obsidian")) {
                event.setNewSpeed(event.getOriginalSpeed()+speed);
            }
        }
    }
}
