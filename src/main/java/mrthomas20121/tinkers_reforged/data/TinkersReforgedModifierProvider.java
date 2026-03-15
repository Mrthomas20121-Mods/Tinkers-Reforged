package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedAttributes;
import mrthomas20121.tinkers_reforged.module.*;
import mrthomas20121.tinkers_reforged.predicate.TinkersReforgedLivingEntityPredicates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidType;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.mantle.data.predicate.damage.DamageTypePredicate;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.mantle.data.predicate.item.ItemPredicate;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.modifiers.modules.armor.BlockDamageSourceModule;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.EnchantmentModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalPowerModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.capability.fluid.ToolTankHelper;
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
        buildModifier(TinkersReforgedModifierIds.TUNNELING)
                .addModule(new TunnelingModule(LevelingInt.eachLevel(3)));

        buildModifier(TinkersReforgedModifierIds.TRIAD).addModule(new TriadModule(LevelingInt.eachLevel(2)));

        buildModifier(TinkersReforgedModifierIds.PITCHING)
                .addModule(StatBoostModule.add(ToolTankHelper.CAPACITY_STAT).eachLevel(FluidType.BUCKET_VOLUME))
                .addModule(ToolTankHelper.TANK_HANDLER)
                // 50 is how much less it will consume for each modifier level
                .addModule(new PitchingModule(LevelingInt.eachLevel(50)));

        buildModifier(TinkersReforgedModifierIds.CLOSE_COMBAT)
                .addModules(StatBoostModule.add(ToolStats.ATTACK_DAMAGE).eachLevel(4),
                        AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(-0.5f));

        buildModifier(TinkersReforgedModifierIds.IONIZE)
                .addModules(ConditionalMeleeDamageModule.builder().target(LivingEntityPredicate.tag(Tags.EntityTypes.BOSSES)).eachLevel(3), ConditionalPowerModule.builder().target(LivingEntityPredicate.tag(Tags.EntityTypes.BOSSES)).eachLevel(3));

        IJsonPredicate<Item> harvest = ItemPredicate.tag(HARVEST);

        buildModifier(TinkersReforgedModifierIds.SURFACE_RESOURCES)
                .addModule(
                        EnchantmentModule
                                .builder(Enchantments.BLOCK_FORTUNE)
                                .toolItem(harvest)
                                .levelRange(1, 3)
                                .holder(TinkersReforgedLivingEntityPredicates.ABOVE_SEA_LEVEL)
                                .mainHandHarvest(TinkersReforged.getResource("fortune_surface_resources"))
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

        buildModifier(TinkersReforgedModifierIds.SUBAQUATIC)
                .addModule(ConditionalMeleeDamageModule.builder().attacker(LivingEntityPredicate.UNDERWATER).toolTag(TinkerTags.Items.HELD).eachLevel(5f));

        buildModifier(TinkersReforgedModifierIds.FRAIL)
                .addModule(MobEffectModule.builder(MobEffects.WEAKNESS).level(RandomLevelingValue.perLevel(0, 0.5f)).time(RandomLevelingValue.perLevel(20f, 20f)).build());

        // armor
        buildModifier(TinkersReforgedModifierIds.ROAST)
                .addModule(new RoastModule(LevelingInt.eachLevel(1), LivingEntityPredicate.ON_FIRE));

        buildModifier(TinkersReforgedModifierIds.LANDING_PAD)
                .addModule(AttributeModule.builder(TinkersReforgedAttributes.ENDER_PEARL_REDUCTION, AttributeModifier.Operation.ADDITION).eachLevel(0.1f));

        buildModifier(TinkersReforgedModifierIds.LAND_PROTECTION)
                .addModule(ProtectionModule.builder().source(DamageSourcePredicate.CAN_PROTECT).entity(TinkersReforgedLivingEntityPredicates.ABOVE_SEA_LEVEL).eachLevel(2f));

        buildModifier(TinkersReforgedModifierIds.SMALL_PROTECTION)
                .addModule(ProtectionModule.builder().attacker(TinkersReforgedLivingEntityPredicates.BABY).eachLevel(3f));

        buildModifier(TinkersReforgedModifierIds.SAFEGUARD)
                .levelDisplay(ModifierLevelDisplay.SINGLE_LEVEL)
                .addModule(BlockDamageSourceModule.source(new DamageTypePredicate(DamageTypes.CACTUS)).build());

        buildModifier(TinkersReforgedModifierIds.SPEED_ORBIT)
                .addModule(AttributeModule.builder(ForgeMod.SWIM_SPEED.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f))
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_GRAVITY.get(), AttributeModifier.Operation.ADDITION).eachLevel(0.1f));

        buildModifier(TinkersReforgedModifierIds.AIR_RESISTANCE)
                .addModule(ProtectionModule.builder().attacker(LivingEntityPredicate.ON_GROUND.inverted()).eachLevel(2f));

        buildModifier(TinkersReforgedModifierIds.LUNGFUL)
                .addModule(ProtectionModule.builder().source(new DamageTypePredicate(DamageTypes.DRAGON_BREATH)).eachLevel(6f));
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Modifier Provider";
    }
}
