package mrthomas20121.tinkers_reforged.tools;

import com.teammetallurgy.atum.entity.stone.EntityStoneBase;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.map.hash.TObjectFloatHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;

public class ToolClub extends SwordCore {

    private static final TObjectFloatMap<EntityLivingBase> cooldown = new TObjectFloatHashMap<>();

    public ToolClub() {
        super(PartMaterialType.handle(TinkerTools.toughToolRod),
                PartMaterialType.head(Tools.clubHead));
        this.addCategory(Category.WEAPON);
    }

    @Override
    public ToolNBT buildTagData(List<Material> materials) {
        ToolNBT data = buildDefaultTag(materials);

        data.attack += 1f;
        data.durability *= 0.7f;
        data.attackSpeedMultiplier = 1f;

        return data;
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        EntityLivingBase target = event.getEntityLiving();
        Entity source = event.getSource().getTrueSource();
        if (!(target instanceof EntityStoneBase) && source instanceof EntityLivingBase) {
            EntityLivingBase attacker = (EntityLivingBase) source;
            if (attacker.getHeldItemMainhand().getItem() instanceof ToolClub) {
                float knockback = 0.0F;
                if (cooldown.get(attacker) == 1.0F) {
                    knockback = 1.8F;
                }
                target.addVelocity((double) (-MathHelper.sin(attacker.rotationYaw * 3.1415927F / 180.0F) * knockback * 0.5F), 0.1D, (double) (MathHelper.cos(attacker.rotationYaw * 3.1415927F / 180.0F) * knockback * 0.5F));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onAttack(AttackEntityEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        if (player.world.isRemote) return;
        if (event.getTarget() instanceof EntityLivingBase && !(event.getTarget() instanceof EntityStoneBase)) {
            if (player.getHeldItemMainhand().getItem() instanceof ToolClub) {
                cooldown.put(player, player.getCooledAttackStrength(0.5F));
            }
        }
    }

    @Override
    public float damagePotential() { return 2.6f; }

    @Override
    public double attackSpeed() {
        return 0.5d;
    }

    @Override
    public boolean dealDamage(ItemStack stack, EntityLivingBase player, Entity entity, float damage) {
        return super.dealDamage(stack, player, entity, damage);
    }
}
