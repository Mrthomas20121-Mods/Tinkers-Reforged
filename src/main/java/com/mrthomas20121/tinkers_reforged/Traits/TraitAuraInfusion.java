package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.chunk.*;
import de.ellpeck.naturesaura.chunk.AuraChunk;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.modifiers.ModReinforced;

public class TraitAuraInfusion extends AbstractTrait {
    private int chance = 50;

    public TraitAuraInfusion() {
        super("aura_infusion", 0xFFFFFFF);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (TagUtil.getTagSafe(tool).getBoolean(ModReinforced.TAG_UNBREAKABLE)) {
            return;
        }
        if(!world.isRemote && entity instanceof EntityPlayer && ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool)) {
            if(((EntityPlayer) entity).getHeldItemMainhand() != tool) {
                IAuraChunk chunk = IAuraChunk.getAuraChunk(world, entity.getPosition());
                if(NaturesAuraAPI.instance().getAuraInArea(world, entity.getPosition(), 1) !=0) {
                    chunk.drainAura(entity.getPosition(), 1000);
                    ToolHelper.healTool(tool, 1, (EntityPlayer) entity);
                }
            }
        }
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
        if(!world.isRemote && ToolHelper.getCurrentDurability(tool) < ToolHelper.getMaxDurability(tool)) {
            for(ItemStack item : player.getEquipmentAndArmor()) {
                if(item != tool) {
                    IAuraChunk chunk = IAuraChunk.getAuraChunk(world, player.getPosition());
                    if(NaturesAuraAPI.instance().getAuraInArea(world, player.getPosition(), 1) !=0) {
                        chunk.drainAura(player.getPosition(), 1000);
                        ToolHelper.healTool(tool, 1, (EntityPlayer) player);
                    }
                }
            }
        }
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (TagUtil.getTagSafe(tool).getBoolean(ModReinforced.TAG_UNBREAKABLE)) {
            return 0;
        }
        return newDamage;
    }
}
