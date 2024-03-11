package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

public class NocturnalModifier extends Modifier {

    private static final ResourceLocation KEY = new ResourceLocation(TinkersReforged.MOD_ID, "nocturnal");
    private static final ResourceLocation BUFF = new ResourceLocation(TinkersReforged.MOD_ID, "nocturnal_buff");

    @Override
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if(holder.getMainHandItem().equals(stack, false) && world.isNight()) {
            ModDataNBT nbt = tool.getPersistentData();
            if(nbt.contains(KEY, Tag.TAG_INT)) {
                int value = nbt.getInt(KEY);

                if(value == 100) {
                    tool.getPersistentData().putInt(BUFF, 1+level);
                    tool.getPersistentData().putInt(KEY, 0);
                }
                else {
                    tool.getPersistentData().putInt(KEY, value+1);
                }
            }
            else {
                tool.getPersistentData().putInt(KEY, 1);
            }
        }
    }

    @Override
    public void onRemoved(IToolStackView tool) {

        // remove data when the modifier is removed
        tool.getPersistentData().remove(KEY);
        tool.getPersistentData().remove(BUFF);
    }

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {

        int bonusDamage = 0;

        if(tool.getPersistentData().contains(BUFF, Tag.TAG_INT)) {
            bonusDamage = tool.getPersistentData().getInt(BUFF);
            tool.getPersistentData().putInt(BUFF, 0);
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage)+bonusDamage;
    }
}
