package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitVoid extends AbstractTrait {
    public TraitVoid() {
        super("ref_void", 0xffffff);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        event.setDropChance(0);
    }
}