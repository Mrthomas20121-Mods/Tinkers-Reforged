package mrthomas20121.tinkers_reforged.library.trait;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class TraitManager {

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {

        ItemStack tool = event.getEntityPlayer().inventory.getCurrentItem();
        if(isTool(tool) && !ToolHelper.isBroken(tool)) {
            TinkerUtil.getTraitsOrdered(tool).forEach(trait -> {
                if(trait instanceof RightClickTrait) {
                    ((RightClickTrait) trait).onRightClick(event);
                }
            });
        }
    }

    private boolean isTool(ItemStack stack) {
        return stack != null && stack.getItem() instanceof ToolCore;
    }
}
