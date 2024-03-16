package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierRemovalHook;
import slimeknights.tconstruct.library.modifiers.hook.build.VolatileDataModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

public class SlotMachineModifier extends Modifier implements ModifierRemovalHook, VolatileDataModifierHook {

    private final ResourceLocation slotMachineLoc = new ResourceLocation(TinkersReforged.MOD_ID, "slot_machine");

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
        persistentData.remove(slotMachineLoc);
        persistentData.addSlots(SlotType.ABILITY, tool.getFreeSlots(SlotType.ABILITY)-level);
        persistentData.addSlots(SlotType.UPGRADE, tool.getFreeSlots(SlotType.UPGRADE)-level);
        return null;
    }

    @Override
    public void addVolatileData(ToolRebuildContext context, ModifierEntry modifier, ModDataNBT volatileData) {
        int level = modifier.getLevel();
        IModDataView persistentData = context.getPersistentData();
        if (!persistentData.contains(slotMachineLoc, Tag.TAG_BYTE) && persistentData instanceof ModDataNBT data) {
            data.putBoolean(slotMachineLoc, true);
            data.addSlots(SlotType.ABILITY, level);
            data.addSlots(SlotType.UPGRADE, level);
        }
    }
}
