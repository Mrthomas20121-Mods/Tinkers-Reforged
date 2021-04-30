package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.objects.capability.BioCapabilityProvider;
import mrthomas20121.tinkers_reforged.library.block.ReforgedItemBlock;
import mrthomas20121.tinkers_reforged.modules.MaterialsTinkersReforged;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
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

    public static void addBlock(Block block) {
        blocks.add(block);
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
        MaterialsTinkersReforged.registerItems(r);
        for(Block block : blocks) {
            registerItemBlock(r, block);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        MaterialsTinkersReforged.registerBlocks(r);
    }

    private static void registerItemBlock(IForgeRegistry<Item> r, Block block) {
        Item itemBlock = new ReforgedItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        itemBlock.setTranslationKey(block.getTranslationKey());
        r.register(itemBlock);
    }

    private static void addOredict(Item item, String name) {
        String[] ores = name.split("_");
        String ore = ores[1]+ StringUtils.capitalize(ores[0]);
        OreDictionary.registerOre(ore, item);
    }
}
