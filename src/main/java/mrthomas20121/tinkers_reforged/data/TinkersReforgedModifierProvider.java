package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.TinkersReforgedModifierIds;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedAttributes;
import mrthomas20121.tinkers_reforged.module.*;
import mrthomas20121.tinkers_reforged.predicate.TinkersReforgedLivingEntityPredicates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.entity.MobTypePredicate;
import slimeknights.mantle.data.predicate.item.ItemPredicate;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.json.variable.tool.StatMultiplierVariable;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.modifiers.modules.armor.MaxArmorAttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.EnchantmentModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalPowerModule;
import slimeknights.tconstruct.library.tools.capability.fluid.ToolTankHelper;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST;
import static slimeknights.tconstruct.library.json.math.ModifierFormula.LEVEL;
import static slimeknights.tconstruct.library.json.math.ModifierFormula.VALUE;

public class TinkersReforgedModifierProvider extends AbstractModifierProvider {

    public TinkersReforgedModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(TinkersReforgedModifierIds.OVERFRACTURE)
                .addModule(new OverfractureModule(LevelingInt.eachLevel(2)));
        buildModifier(TinkersReforgedModifierIds.ATTACK_FRENZY)
                .addModule(new AttackFrenzyModule(LevelingInt.eachLevel(3)));
        buildModifier(TinkersReforgedModifierIds.MINING_FRENZY)
                .addModule(new MiningFrenzyModule(LevelingInt.eachLevel(3)));

        buildModifier(TinkersReforgedModifierIds.TRIAD).addModule(new TriadModule(LevelingInt.eachLevel(2)));

        buildModifier(TinkersReforgedModifierIds.ENDER_THROW)
                .addModule(StatBoostModule.add(ToolTankHelper.CAPACITY_STAT).eachLevel(FluidType.BUCKET_VOLUME))
                .addModule(ToolTankHelper.TANK_HANDLER)
                // 50 is how much less it will consume for each modifier level
                .addModule(new EnderThrowModule(LevelingInt.eachLevel(50)));

        buildModifier(TinkersReforgedModifierIds.TINY_BUT_POWERFUL)
                .addModules(StatBoostModule.add(ToolStats.ATTACK_DAMAGE).eachLevel(4),
                        AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.MULTIPLY_TOTAL).flat(0.5f));

        MobTypePredicate undefined = new MobTypePredicate(MobType.UNDEFINED);
        buildModifier(TinkersReforgedModifierIds.IONIZE)
                .addModules(ConditionalMeleeDamageModule.builder().target(undefined).eachLevel(2), ConditionalPowerModule.builder().target(undefined).eachLevel(2));

        IJsonPredicate<Item> harvest = ItemPredicate.tag(HARVEST);

        buildModifier(TinkersReforgedModifierIds.FORTUNATE_HEIGHT)
                .addModule(
                        EnchantmentModule
                        .builder(Enchantments.BLOCK_FORTUNE)
                        .toolItem(harvest)
                        .holder(TinkersReforgedLivingEntityPredicates.LivingEntityAboveSeaLevelPredicate)
                        .mainHandHarvest(TinkersReforged.getResource("fortune_mod"))
                );

        buildModifier(TinkersReforgedModifierIds.FIERY_FAVOR)
                .addModule(new FieryFavorModule(LevelingInt.eachLevel(1)));

        buildModifier(TinkersReforgedModifierIds.SUBAQUATIC)
                .addModule(new SubAquaticModule(LevelingInt.eachLevel(3)));

        // armor

        buildModifier(TinkersReforgedModifierIds.LANDING_PAD)
                .addModule(AttributeModule.builder(TinkersReforgedAttributes.ENDER_PEARL_REDUCTION, AttributeModifier.Operation.ADDITION).eachLevel(0.1f));

        buildModifier(TinkersReforgedModifierIds.SAFEGUARD)
                .addModule(AttributeModule.builder(Attributes.ARMOR, AttributeModifier.Operation.ADDITION)
                        .tooltipStyle(AttributeModule.TooltipStyle.PERCENT)
                        .formula()
                        // square root of the lost durability, though stat multiplier reduces the effectiveness
                        .customVariable("lost", ToolVariable.CURRENT_DAMAGE)
                        .customVariable("max", new StatMultiplierVariable(ToolStats.DURABILITY))
                        .divide().sqrt()
                        // multiply effect by level of trait
                        .variable(LEVEL).multiply()
                        // we get a percent per value remaining
                        .constant(0.01f).multiply()
                        .constant(1).add()
                        // multiply into the final value
                        .variable(VALUE).multiply().build()
                );

        buildModifier(TinkersReforgedModifierIds.PATHFINDING)
                .addModule(AttributeModule.builder(ForgeMod.SWIM_SPEED.get(), AttributeModifier.Operation.ADDITION)
                        .tooltipStyle(AttributeModule.TooltipStyle.PERCENT)
                        .formula()
                        // square root of the lost durability, though stat multiplier reduces the effectiveness
                        .customVariable("lost", ToolVariable.CURRENT_DAMAGE)
                        .customVariable("max", new StatMultiplierVariable(ToolStats.DURABILITY))
                        .divide().sqrt()
                        // multiply effect by level of trait
                        .variable(LEVEL).multiply()
                        // we get a percent per value remaining
                        .constant(0.01f).multiply()
                        .constant(1).add()
                        // multiply into the final value
                        .variable(VALUE).multiply().build()
                );
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Modifier Provider";
    }
}
