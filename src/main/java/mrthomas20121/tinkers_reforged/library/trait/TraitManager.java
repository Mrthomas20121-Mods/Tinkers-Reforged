package mrthomas20121.tinkers_reforged.library.trait;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.library.potion.PotionRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class TraitManager {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onTooltips(ItemTooltipEvent event) {
        ItemStack tool = event.getItemStack();
        EntityPlayer player = event.getEntityPlayer();
        if(isTool(tool) && !ToolHelper.isBroken(tool)) {
            TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                if(trait instanceof ReforgedTrait) {
                    ((ReforgedTrait) trait).onTooltip(tool, player, event.getToolTip());
                }
            });
        }
    }

    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {
        ItemStack tool = event.getItemStack();
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        BlockPos pos = event.getPos();
        EnumHand hand = event.getHand();
        if(isTool(tool) && !ToolHelper.isBroken(tool)) {
            TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                if(trait instanceof ReforgedTrait) {
                    ((ReforgedTrait) trait).onBlockRightClick(tool, world, player, pos, hand);
                }
            });
        }
    }

    @SubscribeEvent
    public static void onItemRightClick(PlayerInteractEvent.RightClickItem event) {
        ItemStack tool = event.getItemStack();
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        BlockPos pos = event.getPos();
        EnumHand hand = event.getHand();
        if(isTool(tool) && !ToolHelper.isBroken(tool)) {
            TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                if(trait instanceof ReforgedTrait) {
                    ((ReforgedTrait) trait).onItemRightClick(tool, world, player, pos, hand);
                }
            });
        }
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        ItemStack tool = event.getItemStack();
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        BlockPos pos = event.getPos();
        Entity entity = event.getTarget();
        EnumHand hand = event.getHand();
        if(isTool(tool) && !ToolHelper.isBroken(tool)) {
            TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                if(trait instanceof ReforgedTrait) {
                    ((ReforgedTrait) trait).onEntityRightClick(tool, world, player, pos, entity, hand);
                }
            });
        }
    }

    @SubscribeEvent
    public static void onEntityAttack(LivingAttackEvent event) {
        // attacker, most likely player
        Entity player = event.getSource().getTrueSource();
        EntityLivingBase target = event.getEntityLiving();
        DamageSource source = event.getSource();
        float amount = event.getAmount();

        if(player instanceof EntityPlayer) {
            ItemStack tool = ((EntityPlayer) player).getHeldItemMainhand();
            if(isTool(tool) && !ToolHelper.isBroken(tool)) {
                TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                    if(trait instanceof ReforgedTrait) {
                        ((ReforgedTrait) trait).onEntityAttack(tool, (EntityPlayer) player, target, source, amount, event);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void enderTeleportEvent(EnderTeleportEvent event) {
        if(event.isCanceled()) {
            return;
        }
        EntityLivingBase entity = event.getEntityLiving();
        if(entity.isPotionActive(PotionRegistry.ender)) {
            entity.attackEntityFrom(DamageSource.DRAGON_BREATH, entity.getHealth()/4);
        }

    }

    @SubscribeEvent
    public static void onPlayerHeal(LivingHealEvent event) {
        EntityLivingBase living = event.getEntityLiving();
        ItemStack tool = living.getHeldItemMainhand();
        float healing = event.getAmount();
        if(living instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) living;

            if(isTool(tool) && !ToolHelper.isBroken(tool)) {
                TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                    if(trait instanceof ReforgedTrait) {
                        ((ReforgedTrait) trait).onPlayerHeal(tool, player, healing);
                    }
                });
            }
        }
        else {
            if(isTool(tool) && !ToolHelper.isBroken(tool)) {
                TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                    if(trait instanceof ReforgedTrait) {
                        ((ReforgedTrait) trait).onEntityHeal(tool, living, healing);
                    }
                });
            }
        }
    }

    private static boolean isTool(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ToolCore;
    }
}
