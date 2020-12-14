package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.objects.capability.BioCapabilityProvider;
import mrthomas20121.tinkers_reforged.modules.ModuleTinkersReforged;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.tools.TinkerToolCore;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ReforgedRegistry {

    private static ArrayList<Block> blocks = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    private static final ResourceLocation capability = new ResourceLocation(TinkersReforged.MODID, "energyCapability");

    @SubscribeEvent
    public static void CapabilitiesEvent(AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = event.getObject();
        if (stack.getItem() instanceof TinkerToolCore) {
            event.addCapability(capability, new BioCapabilityProvider(stack));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        ModuleTinkersReforged.registerItems(r);
    }
}
