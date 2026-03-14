package mrthomas20121.tinkers_reforged.module;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.ArmorLootingModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.LootingContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record RoastModule(LevelingInt consumed, IJsonPredicate<LivingEntity> predicate) implements ModifierModule, ArmorLootingModifierHook {

    public static final RecordLoadable<RoastModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", RoastModule::consumed),
            LivingEntityPredicate.LOADER.requiredField("predicate", RoastModule::predicate),
            RoastModule::new);

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.ARMOR_LOOTING);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public int updateArmorLooting(IToolStackView tool, ModifierEntry modifier, LootingContext context, EquipmentContext equipment, EquipmentSlot slot, int looting) {
        LivingEntity holder = context.getHolder();
        if(predicate.matches(holder)) {
            if(looting > 0 && looting < 4) {
                return looting+consumed.compute(modifier.getEffectiveLevel());
            }
            else {
                return consumed.compute(modifier.getEffectiveLevel());
            }
        }
        return looting;
    }
}
