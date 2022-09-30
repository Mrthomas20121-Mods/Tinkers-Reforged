package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nonnull;

public class ProtectiveMantleModifier extends Modifier {

    private static final ResourceLocation key = new ResourceLocation(TinkersReforged.MOD_ID, "reset");

    @Override
    public void addVolatileData(@Nonnull ToolRebuildContext context, int level, @Nonnull ModDataNBT volatileData) {
        volatileData.putInt(key, 0);
    }

    @Override
    public int onDamageTool(@Nonnull IToolStackView tool, int level, int amount, @Nullable LivingEntity holder) {
        if(tool.getVolatileData().contains(key, Tag.TAG_INT)) {
            int value = tool.getPersistentData().getInt(key);
            ModDataNBT modDataNBT = tool.getPersistentData();
            if(value == 4) {
                modDataNBT.putInt(key, 0);
                return 0;
            }
            else {
                modDataNBT.putInt(key, modDataNBT.getInt(key)+1);
            }
        }
        return super.onDamageTool(tool, level, amount, holder);
    }
}
