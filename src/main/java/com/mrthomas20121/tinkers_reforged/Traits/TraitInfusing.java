package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk;

public class TraitInfusing extends AbstractTrait {
    public TraitInfusing() {
        super("infusing", 0xFFFFFFF);
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        float tempdmg = 0f;
        if (!(player.world.isRemote)) {
            tempdmg = IAuraChunk.getAuraInArea(player.world, new BlockPos(player.posX, player.posY, player.posZ), 1);
            if(tempdmg > 0) {
                if(tempdmg >= 30f) {
                    tempdmg = 6;
                }
                else {
                    tempdmg = 3;
                }
            }
        }
        return newDamage+tempdmg;
    }
}
