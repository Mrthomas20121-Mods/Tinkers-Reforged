package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.api.TinkersReforgedModifierIds;
import mrthomas20121.tinkers_reforged.module.OverfractureModule;
import mrthomas20121.tinkers_reforged.module.AttackFrenzyModule;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.MobType;
import slimeknights.mantle.data.predicate.entity.MobTypePredicate;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalPowerModule;

public class TinkersReforgedModifierProvider extends AbstractModifierProvider {

    public TinkersReforgedModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        buildModifier(TinkersReforgedModifierIds.OVERFRACTURE).addModule(new OverfractureModule(LevelingInt.eachLevel(2)));
        buildModifier(TinkersReforgedModifierIds.ATTACK_FRENZY).addModule(new AttackFrenzyModule(LevelingInt.eachLevel(3)));
        MobTypePredicate undefined = new MobTypePredicate(MobType.UNDEFINED);
        buildModifier(TinkersReforgedModifierIds.IONIZE)
                .addModules(ConditionalMeleeDamageModule.builder().target(undefined).eachLevel(2), ConditionalPowerModule.builder().target(undefined).eachLevel(2));
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Modifier Provider";
    }
}
