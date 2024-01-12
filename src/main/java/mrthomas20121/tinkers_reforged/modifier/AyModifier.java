package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nonnull;

public class AyModifier extends Modifier {

    private final ResourceLocation ARTHROPOD = new ResourceLocation(TinkersReforged.MOD_ID, "arthropod");
    private final ResourceLocation UNDEAD = new ResourceLocation(TinkersReforged.MOD_ID, "undead");
    private final ResourceLocation ILLAGER = new ResourceLocation(TinkersReforged.MOD_ID, "illager");
    private final ResourceLocation WATER = new ResourceLocation(TinkersReforged.MOD_ID, "water");
    private final ResourceLocation UNDEFINED = new ResourceLocation(TinkersReforged.MOD_ID, "undefined");

    /**
     * return a bonus damage based on how many
     * @param persistantData the tool data
     * @param entityHealth the entity current health(not max health)
     * @param damage the tool's damage
     * @return the new data
     */
    private float getBonusDamage(ModDataNBT persistantData, float entityHealth, float damage) {

        float bonusDamage = 0;

        if (persistantData.contains(ARTHROPOD, Tag.TAG_INT)) {
            bonusDamage += 0.02f;
        }
        if (persistantData.contains(UNDEAD, Tag.TAG_INT)) {
            bonusDamage += 0.02f;
        }
        if (persistantData.contains(ILLAGER, Tag.TAG_INT)) {
            bonusDamage += 0.02f;
        }
        if (persistantData.contains(WATER, Tag.TAG_INT)) {
            bonusDamage += 0.02f;
        }
        if (persistantData.contains(UNDEFINED, Tag.TAG_INT)) {
            bonusDamage += 0.02f;
        }
        return damage+entityHealth * bonusDamage;
    }

    /**
     * get the mob type name from the mob type class
     *
     * @param mobType the mob type(arthropod, undead, illager, water, undefined)
     * @return
     */
    private ResourceLocation getMobTypeName(MobType mobType) {

        if (mobType.equals(MobType.ARTHROPOD)) {
            return ARTHROPOD;
        } else if (mobType.equals(MobType.UNDEAD)) {
            return UNDEAD;
        } else if (mobType.equals(MobType.ILLAGER)) {
            return ILLAGER;
        } else if (mobType.equals(MobType.WATER)) {
            return WATER;
        } else {
            return UNDEFINED;
        }
    }

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        ModDataNBT persistantData = tool.getPersistentData();

        if(context.getLivingTarget() != null) {
            return getBonusDamage(persistantData, context.getLivingTarget().getHealth(), damage);
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }

    @Override
    public void onRemoved(IToolStackView tool) {
        // remove the data we added
        tool.getPersistentData().remove(ARTHROPOD);
        tool.getPersistentData().remove(UNDEAD);
        tool.getPersistentData().remove(ILLAGER);
        tool.getPersistentData().remove(WATER);
        tool.getPersistentData().remove(UNDEFINED);
    }

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        ModDataNBT persistantData = tool.getPersistentData();
        LivingEntity target = context.getLivingTarget();
        if (target != null && target.isDeadOrDying() && damageDealt > 0) {
            MobType mobType = target.getMobType();
            ResourceLocation mobTypeName = getMobTypeName(mobType);

            if (!persistantData.contains(mobTypeName, Tag.TAG_INT)) {
                persistantData.putInt(mobTypeName, 1);
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
