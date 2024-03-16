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

public class SlotMachineModifier extends Modifier implements ModifierRemovalHook, VolatileDataModifierHook {

    private final ResourceLocation KEY = new ResourceLocation(TinkersReforged.MOD_ID, "slot_machine");

    public SlotMachineModifier() {
        this.registerHooks(new ModifierHookMap.Builder()
                .addHook(this, TinkerHooks.REMOVE)
                .addHook(this, TinkerHooks.VOLATILE_DATA)
        );
    }

    @Override
    public Component onRemoved(IToolStackView tool, Modifier modifier) {
        ModDataNBT persistentData = tool.getPersistentData();
        int level = tool.getModifierLevel(this);
        if(persistentData.contains(KEY, Tag.TAG_INT)) {
            persistentData.remove(KEY);
            if(level > 0) {
                persistentData.addSlots(SlotType.ABILITY, tool.getFreeSlots(SlotType.ABILITY)-level);
                persistentData.addSlots(SlotType.UPGRADE, tool.getFreeSlots(SlotType.UPGRADE)-level);
            }
        }
        return null;
    }

    @Override
    public void addVolatileData(ToolRebuildContext context, ModifierEntry modifier, ModDataNBT volatileData) {
        int level = modifier.getLevel();
        IModDataView persistentData = context.getPersistentData();
        if (!persistentData.contains(KEY, Tag.TAG_INT)) {
            volatileData.putInt(KEY, 1);
            if(level > 0) {
                volatileData.addSlots(SlotType.ABILITY, level);
                volatileData.addSlots(SlotType.UPGRADE, level);
            }
        }
    }
}
