package mrthomas20121.tinkers_reforged.trait.qivium;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;

public class TraitSunfireBlessing extends Modifier {

    public TraitSunfireBlessing() {
        super(0xFF8F84);
    }

    @Override
    public void onInventoryTick(@Nonnull IModifierToolStack tool, int level, @Nonnull World world, @Nonnull LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, @Nonnull ItemStack stack) {
        if(holder.isOnFire()) {
            ToolDamageUtil.repair(tool, 10);
        }
    }
}
