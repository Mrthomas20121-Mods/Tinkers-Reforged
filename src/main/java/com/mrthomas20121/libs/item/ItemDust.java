package com.mrthomas20121.libs.item;

import net.minecraft.item.Item;

public class ItemDust extends Item {
    public ItemDust(String modid, String name) {
        this.setRegistryName(modid, name+"_dust");
        this.setTranslationKey(modid+ "." + name+"_dust");
    }
}
