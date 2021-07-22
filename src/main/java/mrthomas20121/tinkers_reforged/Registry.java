package mrthomas20121.tinkers_reforged;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class Registry {

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        TinkersReforged.manager.registerBlocks(event);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        TinkersReforged.manager.registerItems(event);
    }

    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        TinkersReforged.manager.registerRecipes(event.getRegistry());
    }
}
