package mrthomas20121.tinkers_reforged.trait;

import hellfirepvp.astralsorcery.common.constellation.IMajorConstellation;
import hellfirepvp.astralsorcery.common.constellation.effect.ConstellationEffect;
import hellfirepvp.astralsorcery.common.data.research.PlayerProgress;
import hellfirepvp.astralsorcery.common.data.research.ResearchManager;
import hellfirepvp.astralsorcery.common.util.ILocatable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TraitAstralInfusion extends AbstractTrait {
    public TraitAstralInfusion() {
        super("ref_astral_infusion", 0xFFFFFF);
    }

    private NBTTagCompound getNBTFromFile(File file){
        NBTTagCompound tag = null;

        try {
            tag = CompressedStreamTools.read(file);
        }
        catch (IOException e2) {
            // do nothing
        }
        return tag;
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive() && isSelected && !world.isRemote) {
            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)entity;
                if(this.isToolWithTrait(((EntityPlayer) entity).getHeldItemMainhand())) {

                    PlayerProgress playerProgress = new PlayerProgress();
                    UUID user = player.getUniqueID();
                    File file = ResearchManager.getPlayerFile(user);
                    NBTTagCompound tagCompound = getNBTFromFile(file);
                    playerProgress.load(tagCompound);

                    if(playerProgress.wasOnceAttuned() && world.getWorldTime() > 13000) {
                        IMajorConstellation constellation = playerProgress.getAttunedConstellation();
                        if(constellation != null) {
                            if(random.nextFloat() > 0.5f) {
                                ConstellationEffect effect = constellation.getRitualEffect(ILocatable.fromPos(player.getPosition()));
                                effect.playEffect(world, player.getPosition(), 1f, effect.provideProperties(0), null);
                            }
                        }
                    }
                }
            }
        }
    }
}
