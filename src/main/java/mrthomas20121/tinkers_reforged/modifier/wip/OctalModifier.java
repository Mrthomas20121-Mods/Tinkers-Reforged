package mrthomas20121.tinkers_reforged.modifier.wip;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class OctalModifier extends Modifier {

    private final ResourceLocation KEY = new ResourceLocation(TinkersReforged.MOD_ID, "ref_octal");
    private final ResourceLocation MOD = new ResourceLocation(TinkersReforged.MOD_ID, "ref_mod");

    @Override
    public void onRemoved(IToolStackView tool) {
        ModDataNBT pers = tool.getPersistentData();
        int mod = pers.getInt(MOD);
        int level = tool.getModifierLevel(this);
        int finalLevel = mod-level;
        pers.remove(KEY);
        int slotsUpgrade = pers.getSlots(SlotType.UPGRADE);
        int slotsAbility = pers.getSlots(SlotType.ABILITY);

        if(finalLevel > 0) {
            pers.addSlots(SlotType.UPGRADE, slotsUpgrade-finalLevel);
            pers.addSlots(SlotType.ABILITY, slotsAbility-finalLevel);
        }
    }

    @Override
    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        IModDataView persistentData = context.getPersistentData();
        if (persistentData.contains(KEY, Tag.TAG_COMPOUND)) {
            int slotsUpgrade = volatileData.getSlots(SlotType.UPGRADE);
            int slotsAbility = volatileData.getSlots(SlotType.ABILITY);
            volatileData.addSlots(SlotType.UPGRADE, slotsUpgrade+level);
            volatileData.addSlots(SlotType.ABILITY, slotsAbility+level);
            volatileData.putInt(MOD, level);
        }
        else {
            volatileData.put(KEY, new CompoundTag());
        }
    }

    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.add(builder, level*-1);
        ToolStats.MINING_SPEED.add(builder, level*-1);
    }
}
