package mrthomas20121.tinkers_reforged.modifier.wip;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HellFireModifier extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {

        float bonusDamage = 0;

        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            ITagManager<EntityType<?>> tags = ForgeRegistries.ENTITIES.tags();
            if(tags != null && tags.getTag(TinkersReforgedTags.Entities.NETHER_MOBS).contains(target.getType())) {
                bonusDamage+=1.1f*level;
            }
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage)+bonusDamage;
    }
}
