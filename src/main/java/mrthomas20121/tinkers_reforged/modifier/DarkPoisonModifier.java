package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

public class DarkPoisonModifier extends Modifier implements ProjectileHitModifierHook {

    public DarkPoisonModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.PROJECTILE_HIT));
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if(target != null) {
            if(RANDOM.nextBoolean()) {
                if(!target.hasEffect(MobEffects.WITHER)) {
                    target.addEffect(new MobEffectInstance(MobEffects.WITHER, 10));
                }
            }
        }
        return false;
    }
}
