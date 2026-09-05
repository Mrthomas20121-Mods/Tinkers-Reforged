package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.module.*;
import mrthomas20121.tinkers_reforged.predicate.TinkersReforgedPredicates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.mantle.data.predicate.damage.DamageTypePredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.mantle.data.predicate.item.ItemPredicate;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.modifiers.modules.armor.EffectImmunityModule;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.ConditionalStatModule;
import slimeknights.tconstruct.library.modifiers.modules.build.EnchantmentModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalPowerModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.mining.ConditionalMiningSpeedModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST;

public class TinkersReforgedModifierProvider extends AbstractModifierProvider {

    public TinkersReforgedModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(TinkersReforgedModifierIds.OVERFRACTURE)
                .addModule(new OverfractureModule(LevelingInt.eachLevel(4)));

        buildModifier(TinkersReforgedModifierIds.CHASM)
                .addModule(ConditionalMiningSpeedModule.builder().toolTag(HARVEST).holder(TinkersReforgedPredicates.BELOW_ZERO).eachLevel(3f))
                .addModule(ConditionalStatModule.stat(ToolStats.DRAW_SPEED).toolTag(TinkerTags.Items.RANGED).holder(TinkersReforgedPredicates.BELOW_ZERO).eachLevel(0.2f))
                .addModule(ProtectionModule.builder().toolTag(TinkerTags.Items.ARMOR).entity(TinkersReforgedPredicates.BELOW_ZERO).eachLevel(2f));

        buildModifier(TinkersReforgedModifierIds.TRIAD).addModule(new TriadModule(LevelingInt.eachLevel(2)));

        buildModifier(TinkersReforgedModifierIds.CLOSE_COMBAT)
                .addModules(StatBoostModule.add(ToolStats.ATTACK_DAMAGE).eachLevel(4),
                        AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(-0.5f));

        buildModifier(TinkersReforgedModifierIds.IONIZE)
                .addModules(ConditionalMeleeDamageModule.builder().target(LivingEntityPredicate.tag(Tags.EntityTypes.BOSSES)).eachLevel(3),
                        ConditionalPowerModule.builder().target(LivingEntityPredicate.tag(Tags.EntityTypes.BOSSES)).eachLevel(3));

        IJsonPredicate<Item> harvest = ItemPredicate.tag(HARVEST);

        buildModifier(TinkersReforgedModifierIds.CLEAVAGE)
                .addModules(
                        ConditionalMiningSpeedModule.builder().toolTag(HARVEST).holder(TinkersReforgedPredicates.NOT_MAX_HEALTH).eachLevel(3),
                        ConditionalMeleeDamageModule.builder().attacker(TinkersReforgedPredicates.NOT_MAX_HEALTH).eachLevel(3)
                );

        buildModifier(TinkersReforgedModifierIds.FLAMING)
                .addModule(
                        EnchantmentModule
                                .builder(Enchantments.BLOCK_FORTUNE)
                                .toolItem(harvest)
                                .levelRange(1, 3)
                                .holder(LivingEntityPredicate.ON_FIRE)
                                .armorHarvest(EquipmentSlot.HEAD, EquipmentSlot.FEET)
                );

        buildModifier(TinkersReforgedModifierIds.GEOGRAPHICAL)
                .addModule(ConditionalMiningSpeedModule.builder().toolTag(HARVEST).holder(TinkersReforgedPredicates.IS_NOT_IN_THE_OVERWORLD).amount(2, 4))
                .addModule(ConditionalMeleeDamageModule.builder().attacker(TinkersReforgedPredicates.IS_NOT_IN_THE_OVERWORLD).amount(2, 4))
                .addModule(ConditionalPowerModule.builder().holder(TinkersReforgedPredicates.IS_NOT_IN_THE_OVERWORLD).amount(2, 3));

        buildModifier(TinkersReforgedModifierIds.SUBAQUATIC)
                .addModule(ConditionalMeleeDamageModule.builder().attacker(LivingEntityPredicate.UNDERWATER).toolTag(TinkerTags.Items.HELD).eachLevel(5f));

        buildModifier(TinkersReforgedModifierIds.FRAIL)
                .addModule(MobEffectModule.builder(MobEffects.WEAKNESS).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.perLevel(20f, 20f)).buildCounter());

        // armor
        buildModifier(TinkersReforgedModifierIds.ROAST)
                .addModule(new RoastModule(LevelingInt.eachLevel(1), LivingEntityPredicate.ON_FIRE));

        buildModifier(TinkersReforgedModifierIds.DECAY_IMMUNITY)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(new EffectImmunityModule(MobEffects.WITHER));

        buildModifier(TinkersReforgedModifierIds.HEAT_PROOF)
                .addModule(ProtectionModule.builder().entity(TinkersReforgedPredicates.IS_NETHER_BIOME).eachLevel(1.5f));

        buildModifier(TinkersReforgedModifierIds.HEALTH_UP)
                .addModule(AttributeModule.builder(Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADDITION).eachLevel(-0.2f))
                .addModule(AttributeModule.builder(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADDITION).eachLevel(1f));

        buildModifier(TinkersReforgedModifierIds.AGILITY)
                .addModule(AttributeModule.builder(ForgeMod.SWIM_SPEED.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f))
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_GRAVITY.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f));

        buildModifier(TinkersReforgedModifierIds.FRICTION)
                .addModule(ProtectionModule.builder().attacker(LivingEntityPredicate.ON_GROUND.inverted()).eachLevel(2f));

        buildModifier(TinkersReforgedModifierIds.LUNGFUL)
                .addModule(ProtectionModule.builder().source(new DamageTypePredicate(DamageTypes.DRAGON_BREATH)).eachLevel(6f));

        buildModifier(TinkersReforgedModifierIds.SPACIAL)
                .addModule(ProtectionModule.builder().attacker(TinkersReforgedPredicates.IS_NOT_IN_THE_OVERWORLD).source(DamageSourcePredicate.CAN_PROTECT).eachLevel(3f));
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Modifier Provider";
    }
}
