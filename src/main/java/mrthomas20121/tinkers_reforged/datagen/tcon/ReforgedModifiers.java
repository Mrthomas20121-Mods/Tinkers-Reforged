package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.util.ReforgedTiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.modules.behavior.RepairModule;
import slimeknights.tconstruct.library.modifiers.modules.build.RarityModule;
import slimeknights.tconstruct.library.modifiers.modules.build.SetStatModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.data.ModifierIds;

import java.util.Arrays;
import java.util.Locale;

public class ReforgedModifiers extends AbstractModifierProvider implements IConditionBuilder {

    public static Rarity rarity = Rarity.create("myRarity", style -> style.withColor(0xf1e8b8));

    public static ModifierId id = new ModifierId("tinkers_reforged:test");

    public ReforgedModifiers(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addModifiers() {

        buildModifier(id)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(new RarityModule(rarity))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).flat(0.5f))
                .addModule(RepairModule.builder().flat(0.5f))
                // armor
                .addModule(StatBoostModule.add(ToolStats.KNOCKBACK_RESISTANCE).flat(0.05f))
                // melee harvest
                .addModule(StatBoostModule.multiplyConditional(ToolStats.ATTACK_DAMAGE).flat(0.25f))
                .addModule(StatBoostModule.multiplyConditional(ToolStats.MINING_SPEED).flat(0.25f))
                .addModule(SetStatModule.set(ToolStats.HARVEST_TIER).value(ReforgedTiers.KEPU))
                // ranged
                .addModule(StatBoostModule.add(ToolStats.ACCURACY).flat(0.1f));
    }

    @Override
    public String getName() {
        return null;
    }
}
