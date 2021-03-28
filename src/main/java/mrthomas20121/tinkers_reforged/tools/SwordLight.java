package mrthomas20121.tinkers_reforged.tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;

public class SwordLight extends SwordCore {

    public SwordLight()
    {
        super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(Tools.lightblade),
                PartMaterialType.extra(TinkerTools.wideGuard));
        this.addCategory(Category.WEAPON);
    }

    @Override
    public ToolNBT buildTagData(List<Material> materials) {
        ToolNBT data = buildDefaultTag(materials);

        data.durability *= 0.9f;
        data.attackSpeedMultiplier*=1.5f;
        data.attack*=0.6f;

        return data;
    }

    @Override
    public float damagePotential() {
        return 1.1f;
    }

    @Override
    public double attackSpeed() {
        return 1.4;
    }

    @Override
    public boolean dealDamage(ItemStack stack, EntityLivingBase player, Entity entity, float damage) {
        if(entity.isCreatureType(EnumCreatureType.MONSTER, false))
        {
            DamageSource damageSource = DamageSource.causeIndirectMagicDamage(entity, player);
            entity.attackEntityFrom(damageSource, 6);
        }
        return super.dealDamage(stack, player, entity, damage);
    }

    @Override
    public float damageCutoff() {
        return 16.0f;
    }
}
