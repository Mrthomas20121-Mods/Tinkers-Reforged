package mrthomas20121.tinkers_reforged.module;

import mrthomas20121.tinkers_reforged.api.hook.RightClickModifierHook;
import mrthomas20121.tinkers_reforged.api.hook.TinkersReforgedModifierHooks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierTraitHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.TinkerModifiers;

import java.util.List;

import static slimeknights.tconstruct.library.tools.capability.fluid.ToolTankHelper.TANK_HELPER;

public record EnderThrowModule(LevelingInt consumed) implements ModifierModule, RightClickModifierHook {

    public static final RecordLoadable<EnderThrowModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", EnderThrowModule::consumed),
            EnderThrowModule::new);

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(TinkersReforgedModifierHooks.RIGHT_CLICK);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public void onRightClickItem(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, PlayerInteractEvent.RightClickItem event) {
        if(hand.equals(InteractionHand.MAIN_HAND)) {
            FluidStack fluid = TANK_HELPER.getFluid(tool);
            if(!fluid.isEmpty() && fluid.getFluid().is(TinkerFluids.moltenEnder.getCommonTag())) {
                int amountPerLevel = getAmountPerLevel(modifier.intEffectiveLevel());
                if(fluid.getAmount() >= amountPerLevel) {
                    fluid.setAmount(fluid.getAmount()-amountPerLevel);
                    TANK_HELPER.setFluid(tool, fluid);
                    ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(player.level(), player);
                    thrownenderpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                }
            }
        }
    }

    private int getAmountPerLevel(int level) {
        return 250-consumed.eachLevel()*level;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }
}
