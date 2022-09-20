package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nonnull;

public class CrystallizedPunchModifier extends Modifier {

    private static final ResourceLocation key = new ResourceLocation(TinkersReforged.MOD_ID, "crystallized");

    @Override
    public void addVolatileData(@Nonnull ToolRebuildContext context, int level, @Nonnull ModDataNBT volatileData) {
        volatileData.putInt(key, 0);
    }

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {

        if(damageDealt>0) {
            if(tool.getVolatileData().contains(key, Tag.TAG_INT)) {
                int value = tool.getPersistentData().getInt(key);
                ModDataNBT modDataNBT = tool.getPersistentData();
                if(value == 6) {
                    modDataNBT.putInt(key, 0);
                    if(context.getLivingTarget() != null) {
                        context.getLivingTarget().hurt(DamageSource.MAGIC, damageDealt*0.1f);
                    }
                }
                else {
                    modDataNBT.putInt(key, modDataNBT.getInt(key)+1);
                }
            }
        }

        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
