package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierRemovalHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.VolatileDataModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class SlotMachineModifier extends Modifier implements ModifierRemovalHook, VolatileDataModifierHook, ToolStatsModifierHook {

    private final ResourceLocation KEY = new ResourceLocation(TinkersReforged.MOD_ID, "ref_octal");
    private final ResourceLocation MOD = new ResourceLocation(TinkersReforged.MOD_ID, "ref_mod");

    public SlotMachineModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.TOOL_STATS).addHook(this, TinkerHooks.REMOVE).addHook(this, TinkerHooks.VOLATILE_DATA));
    }

    @Override
    public Component onRemoved(IToolStackView tool, Modifier modifier) {
        ModDataNBT persistentData = tool.getPersistentData();
        int mod = persistentData.getInt(MOD);
        int level = tool.getModifierLevel(this);
        int finalLevel = mod-level;
        persistentData.remove(KEY);
        int slotsUpgrade = persistentData.getSlots(SlotType.UPGRADE);
        int slotsAbility = persistentData.getSlots(SlotType.ABILITY);

        if(finalLevel > 0) {
            persistentData.addSlots(SlotType.UPGRADE, slotsUpgrade-finalLevel);
            persistentData.addSlots(SlotType.ABILITY, slotsAbility-finalLevel);
        }
        return null;
    }

    @Override
    public void addToolStats(ToolRebuildContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.add(builder, -1);
        ToolStats.MINING_SPEED.add(builder, -1);
    }

    @Override
    public void addVolatileData(ToolRebuildContext context, ModifierEntry modifier, ModDataNBT volatileData) {
        int level = modifier.getLevel();
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
}
