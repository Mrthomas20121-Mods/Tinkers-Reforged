package com.mrthomas20121.tinkers_reforged.proxy;

import c4.conarm.common.items.armor.Helmet;
import c4.conarm.lib.armor.ArmorCore;
import com.mrthomas20121.tinkers_reforged.Modifiers.Modifiers;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.teammetallurgy.atum.init.AtumItems;
import com.teammetallurgy.atum.items.artifacts.atum.ItemEyesOfAtum;
import com.teammetallurgy.atum.utils.AtumConfig;
import com.teammetallurgy.atum.utils.Constants;
import com.teammetallurgy.atum.world.WorldProviderAtum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientEvent {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void renderFog(EntityViewRenderEvent.RenderFogEvent event) {
        float sandstormFog = AtumConfig.SANDSTORM_FOG;
        WorldProvider provider = Minecraft.getMinecraft().player.world.provider;

        if (provider instanceof WorldProviderAtum && event.getEntity().dimension == AtumConfig.DIMENSION_ID && AtumConfig.FOG_ENABLED) {
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            float fogDensity = 0.08F;

            if (event.getEntity() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getEntity();
                ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                if (player.getPosition().getY() <= 60) {
                    fogDensity += (float) (62 - player.getPosition().getY()) * 0.005F;
                }
                if (helmet.getItem() instanceof ItemEyesOfAtum) {
                    fogDensity = fogDensity / 3;
                }
                if (helmet.getItem() == AtumItems.WANDERER_HELMET || helmet.getItem() == AtumItems.DESERT_HELMET_IRON || helmet.getItem() == AtumItems.DESERT_HELMET_GOLD || helmet.getItem() == AtumItems.DESERT_HELMET_DIAMOND) {
                    fogDensity = fogDensity / 1.5F;
                }
                if(helmet.getItem() instanceof Helmet) {
                    if(Modifiers.cloth.isArmorWithTrait(helmet.getItem())) {
                        fogDensity = fogDensity / 1.5F;
                    }
                }
                if (player.posY >= player.world.getSeaLevel() - 8) {
                    WorldProviderAtum providerAtum = (WorldProviderAtum) provider;
                    fogDensity *= 1 + sandstormFog - (sandstormFog - sandstormFog * providerAtum.stormStrength);
                }
                GlStateManager.setFogDensity(fogDensity);
            }
        }
    }
}
