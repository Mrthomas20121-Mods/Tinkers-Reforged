package mrthomas20121.tinkers_reforged.trait;

import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.constellation.distribution.ConstellationSkyHandler;
import hellfirepvp.astralsorcery.common.constellation.distribution.WorldSkyHandler;
import hellfirepvp.astralsorcery.common.lib.Constellations;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.List;

public class TraitAstralInfusion extends AbstractTrait {
    public TraitAstralInfusion() {
        super("ref_astral_infusion", 0xFFFFFF);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive() && isSelected && !world.isRemote) {
            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)entity;
                if((world.getWorldTime() >= 13000 && this.isToolWithTrait(((EntityPlayer) entity).getHeldItemMainhand()))) {

                    WorldSkyHandler worldSkyHandler = ConstellationSkyHandler.getInstance().getWorldHandler(world);
                    if (worldSkyHandler != null) {
                        List<IConstellation> constellations = worldSkyHandler.getActiveConstellations();

                        for(IConstellation constellation : constellations)
                        {
                            switch (constellation.getSimpleName()) {
                                case "aevitas":
                                    if(random.nextInt(100) < 60)
                                        ToolHelper.healTool(tool, 10, player);
                                    break;
                                case "armara":
                                    if(random.nextInt(100) < 60)
                                        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 100, 0, false, true));
                                    break;
                                case "discidia":

                                case "evorsio":

                                case "vicio":
                                    if(random.nextInt(100) < 60)
                                        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 100, 0, false, true));
                                    break;

                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        World world = event.getEntityPlayer().getEntityWorld();
        WorldSkyHandler worldSkyHandler = ConstellationSkyHandler.getInstance().getWorldHandler(world);
        if(world.getWorldTime()>=13000 && worldSkyHandler != null) {
            List<IConstellation> constellations = worldSkyHandler.getActiveConstellations();
            if(constellations.contains(Constellations.evorsio)) {
                float speed = event.getNewSpeed()*1.5f;
                if(event.getEntityPlayer().getHealth()<5) {
                    event.setNewSpeed(speed*1.2f);
                }
            }
        }
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        World world = player.getEntityWorld();
        WorldSkyHandler worldSkyHandler = ConstellationSkyHandler.getInstance().getWorldHandler(world);
        if(world.getWorldTime()>=13000 && worldSkyHandler != null) {
            List<IConstellation> constellations = worldSkyHandler.getActiveConstellations();
            if(constellations.contains(Constellations.discidia)) {
                return (float)(newDamage*TinkersReforgedConfig.SettingGeneral.dmgMultiplier);
            }
        }
        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }
}
