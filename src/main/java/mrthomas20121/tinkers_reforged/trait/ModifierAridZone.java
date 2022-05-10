package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

// bring back Aridiculous from 1.12
// Increase mining speed and damage in hot/dry area, decreases a bit in wet area
public class ModifierAridZone extends Modifier {

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Level world = event.getEntityLiving().level;
        float coeff = calcArid(world, event.getPos());
        event.setNewSpeed(event.getNewSpeed()+event.getOriginalSpeed()*coeff);
    }

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        float extraDamage = 2f * calcArid(context.getAttacker().level, context.getAttacker().blockPosition());
        return extraDamage+super.getEntityDamage(tool, level, context, baseDamage, damage);
    }

    private float calcArid(Level level, BlockPos pos) {
        Biome biome = level.getBiome(pos).value();
        float rain = level.isRaining() ? biome.getDownfall() / 2 : 0f;
        return (float)(Math.pow(1.25, 3d*(0.5f+biome.getBaseTemperature() - biome.getDownfall()) - 1.25d)) - rain;
    }
}
