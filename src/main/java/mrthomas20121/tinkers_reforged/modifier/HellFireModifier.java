package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HellFireModifier extends Modifier implements MeleeDamageModifierHook {

    public HellFireModifier() {
        this.registerHooks(ModifierHookMap.builder().addHook(this, TinkerHooks.MELEE_DAMAGE));
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        float bonusDamage = 0;

        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            ITagManager<EntityType<?>> tags = ForgeRegistries.ENTITY_TYPES.tags();
            if(tags != null && tags.getTag(TinkersReforgedTags.Entities.NETHER_MOBS).contains(target.getType())) {
                bonusDamage+=1.1f*modifier.getLevel();
            }
        }
        return damage+bonusDamage;
    }
}
