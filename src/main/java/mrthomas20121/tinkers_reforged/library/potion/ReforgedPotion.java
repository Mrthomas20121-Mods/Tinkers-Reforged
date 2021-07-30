package mrthomas20121.tinkers_reforged.library.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class ReforgedPotion extends Potion {

    public ReforgedPotion(ResourceLocation registryName, boolean isBadEffect, int color) {
        super(isBadEffect, color);
        this.setPotionName(String.format("potion.%s", registryName.getPath()));
        this.setRegistryName(registryName);
    }

    @Override
    public boolean shouldRenderInvText(@Nonnull PotionEffect effect) {
        return false;
    }
}
