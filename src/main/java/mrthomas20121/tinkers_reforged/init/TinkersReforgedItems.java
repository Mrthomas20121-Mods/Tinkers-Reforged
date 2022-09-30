package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.item.CastObject;
import mrthomas20121.tinkers_reforged.item.book.TinkersReforgedBookItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

import static slimeknights.tconstruct.tools.TinkerToolParts.TAB_TOOL_PARTS;
import static slimeknights.tconstruct.tools.TinkerTools.TAB_TOOLS;

public class TinkersReforgedItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);

    public static Map<CastType, RegistryObject<Item>> casts = new HashMap<>();

    public static final CreativeModeTab group = new CreativeModeTab(TinkersReforged.MOD_ID) {

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(aluminum_ingot.get());
        }
    };

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(TAB_TOOLS);
    private static final Item.Properties PARTS_PROPS = new Item.Properties().tab(TAB_TOOL_PARTS);

    public static RegistryObject<Item> book = ITEMS.register("reforging_guide", () -> new TinkersReforgedBookItem(new Item.Properties().stacksTo(1).tab(group)));

    public static RegistryObject<Item> blazing_copper_ingot = ITEMS.register("blazing_copper_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> blazing_copper_dust = ITEMS.register("blazing_copper_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> blazing_copper_nugget = ITEMS.register("blazing_copper_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> blazing_copper_block = ITEMS.register("blazing_copper_block", () -> registerItemBlock(TinkersReforgedBlocks.blazing_copper_block.get()));

    public static RegistryObject<Item> ender_bone = ITEMS.register("ender_bone", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_ingot = ITEMS.register("aluminum_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_dust = ITEMS.register("aluminum_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_nugget = ITEMS.register("aluminum_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> raw_aluminum = ITEMS.register("raw_aluminum", TinkersReforgedItems::register);
    public static RegistryObject<Item> aluminum_block = ITEMS.register("aluminum_block", () -> registerItemBlock(TinkersReforgedBlocks.aluminum_block.get()));
    public static RegistryObject<Item> raw_aluminum_block = ITEMS.register("raw_aluminum_block", () -> registerItemBlock(TinkersReforgedBlocks.raw_aluminum_block.get()));
    public static RegistryObject<Item> aluminum_ore = ITEMS.register("aluminum_ore", () -> registerItemBlock(TinkersReforgedBlocks.aluminum_ore.get()));
    public static RegistryObject<Item> deepslate_aluminum_ore = ITEMS.register("deepslate_aluminum_ore", () -> registerItemBlock(TinkersReforgedBlocks.deepslate_aluminum_ore.get()));

    public static RegistryObject<Item> duralumin_ingot = ITEMS.register("duralumin_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_dust = ITEMS.register("duralumin_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_nugget = ITEMS.register("duralumin_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> duralumin_block = ITEMS.register("duralumin_block", () -> registerItemBlock(TinkersReforgedBlocks.duralumin_block.get()));

    public static RegistryObject<Item> electrical_copper_ingot = ITEMS.register("electrical_copper_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_dust = ITEMS.register("electrical_copper_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_nugget = ITEMS.register("electrical_copper_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> electrical_copper_block = ITEMS.register("electrical_copper_block", () -> registerItemBlock(TinkersReforgedBlocks.electrical_copper_block.get()));

    public static RegistryObject<Item> felsteel_ingot = ITEMS.register("felsteel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_dust = ITEMS.register("felsteel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_nugget = ITEMS.register("felsteel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> felsteel_block = ITEMS.register("felsteel_block", () -> registerItemBlock(TinkersReforgedBlocks.felsteel_block.get()));

    public static RegistryObject<Item> gausum_ingot = ITEMS.register("gausum_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_dust = ITEMS.register("gausum_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_nugget = ITEMS.register("gausum_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> gausum_block = ITEMS.register("gausum_block", () -> registerItemBlock(TinkersReforgedBlocks.gausum_block.get()));

    public static RegistryObject<Item> kepu_ingot = ITEMS.register("kepu_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> kepu_dust = ITEMS.register("kepu_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> kepu_nugget = ITEMS.register("kepu_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> raw_kepu = ITEMS.register("raw_kepu", TinkersReforgedItems::register);
    public static RegistryObject<Item> raw_kepu_block = ITEMS.register("raw_kepu_block", () -> registerItemBlock(TinkersReforgedBlocks.raw_kepu_block.get()));
    public static RegistryObject<Item> kepu_block = ITEMS.register("kepu_block", () -> registerItemBlock(TinkersReforgedBlocks.kepu_block.get()));
    public static RegistryObject<Item> kepu_ore = ITEMS.register("kepu_ore", () -> registerItemBlock(TinkersReforgedBlocks.kepu_ore.get()));

	public static RegistryObject<Item> lavium_ingot = ITEMS.register("lavium_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_dust = ITEMS.register("lavium_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_nugget = ITEMS.register("lavium_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> lavium_block = ITEMS.register("lavium_block", () -> registerItemBlock(TinkersReforgedBlocks.lavium_block.get()));

	public static RegistryObject<Item> qivium_ingot = ITEMS.register("qivium_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_dust = ITEMS.register("qivium_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_nugget = ITEMS.register("qivium_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> qivium_block = ITEMS.register("qivium_block", () -> registerItemBlock(TinkersReforgedBlocks.qivium_block.get()));

    public static RegistryObject<Item> chorus_metal_ingot = ITEMS.register("chorus_metal_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> chorus_metal_dust = ITEMS.register("chorus_metal_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> chorus_metal_nugget = ITEMS.register("chorus_metal_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> chorus_metal_block = ITEMS.register("chorus_metal_block", () -> registerItemBlock(TinkersReforgedBlocks.chorus_metal_block.get()));

    public static RegistryObject<Item> durasteel_ingot = ITEMS.register("durasteel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> durasteel_dust = ITEMS.register("durasteel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> durasteel_nugget = ITEMS.register("durasteel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> durasteel_block = ITEMS.register("durasteel_block", () -> registerItemBlock(TinkersReforgedBlocks.durasteel_block.get()));

    public static RegistryObject<Item> crusteel_ingot = ITEMS.register("crusteel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> crusteel_dust = ITEMS.register("crusteel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> crusteel_nugget = ITEMS.register("crusteel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> crusteel_block = ITEMS.register("crusteel_block", () -> registerItemBlock(TinkersReforgedBlocks.crusteel_block.get()));

    public static RegistryObject<Item> yokel_ingot = ITEMS.register("yokel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> yokel_dust = ITEMS.register("yokel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> yokel_nugget = ITEMS.register("yokel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> yokel_block = ITEMS.register("yokel_block", () -> registerItemBlock(TinkersReforgedBlocks.yokel_block.get()));

    public static RegistryObject<Item> wavy_ingot = ITEMS.register("wavy_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> wavy_dust = ITEMS.register("wavy_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> wavy_nugget = ITEMS.register("wavy_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> wavy_block = ITEMS.register("wavy_block", () -> registerItemBlock(TinkersReforgedBlocks.wavy_block.get()));

    public static RegistryObject<Item> baolian_ingot = ITEMS.register("baolian_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> baolian_dust = ITEMS.register("baolian_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> baolian_nugget = ITEMS.register("baolian_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> baolian_block = ITEMS.register("baolian_block", () -> registerItemBlock(TinkersReforgedBlocks.baolian_block.get()));

    public static RegistryObject<Item> epidote_gem = ITEMS.register("epidote_gem", TinkersReforgedItems::register);
    public static RegistryObject<Item> epidote_block = ITEMS.register("epidote_block", () -> registerItemBlock(TinkersReforgedBlocks.epidote_block.get()));
    public static RegistryObject<Item> deepslate_epidote_ore = ITEMS.register("deepslate_epidote_ore", () -> registerItemBlock(TinkersReforgedBlocks.deepslate_epidote_ore.get()));

    public static RegistryObject<Item> galu_ingot = ITEMS.register("galu_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> galu_dust = ITEMS.register("galu_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> galu_nugget = ITEMS.register("galu_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> galu_block = ITEMS.register("galu_block", () -> registerItemBlock(TinkersReforgedBlocks.galu_block.get()));

    public static RegistryObject<Item> magma_steel_ingot = ITEMS.register("magma_steel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> magma_steel_dust = ITEMS.register("magma_steel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> magma_steel_nugget = ITEMS.register("magma_steel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> magma_steel_block = ITEMS.register("magma_steel_block", () -> registerItemBlock(TinkersReforgedBlocks.magma_steel_block.get()));

    public static RegistryObject<Item> cyber_steel_ingot = ITEMS.register("cyber_steel_ingot", TinkersReforgedItems::register);
    public static RegistryObject<Item> cyber_steel_dust = ITEMS.register("cyber_steel_dust", TinkersReforgedItems::register);
    public static RegistryObject<Item> cyber_steel_nugget = ITEMS.register("cyber_steel_nugget", TinkersReforgedItems::register);
    public static RegistryObject<Item> cyber_steel_block = ITEMS.register("cyber_steel_block", () -> registerItemBlock(TinkersReforgedBlocks.cyber_steel_block.get()));

    public static RegistryObject<Item> hureaulite_gem = ITEMS.register("hureaulite_gem", TinkersReforgedItems::register);
    public static RegistryObject<Item> hureaulite_block = ITEMS.register("hureaulite_block", () -> registerItemBlock(TinkersReforgedBlocks.hureaulite_block.get()));
    public static RegistryObject<Item> deepslate_hureaulite_ore = ITEMS.register("deepslate_hureaulite_ore", () -> registerItemBlock(TinkersReforgedBlocks.deepslate_hureaulite_ore.get()));

    public static RegistryObject<Item> red_beryl_gem = ITEMS.register("red_beryl_gem", TinkersReforgedItems::register);
    public static RegistryObject<Item> red_beryl_block = ITEMS.register("red_beryl_block", () -> registerItemBlock(TinkersReforgedBlocks.red_beryl_block.get()));
    public static RegistryObject<Item> red_beryl_ore = ITEMS.register("red_beryl_ore", () -> registerItemBlock(TinkersReforgedBlocks.red_beryl_ore.get()));
    public static RegistryObject<Item> deepslate_red_beryl_ore = ITEMS.register("deepslate_red_beryl_ore", () -> registerItemBlock(TinkersReforgedBlocks.deepslate_red_beryl_ore.get()));

    public static final RegistryObject<ToolPartItem> LARGE_ROUND_PLATE = ITEMS.register("large_round_plate", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));
    public static final RegistryObject<ToolPartItem> GREAT_BLADE = ITEMS.register("great_blade", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));

    public static final RegistryObject<ModifiableItem> FRYING_PAN = ITEMS.register("frying_pan", () -> new ModifiableItem(TOOL, TinkersReforgedToolDefinitions.FRYING_PAN));
    public static final RegistryObject<ModifiableItem> GREATSWORD = ITEMS.register("greatsword", () -> new ModifiableItem(TOOL, TinkersReforgedToolDefinitions.GREATSWORD));

    public static CastObject great_blade_cast = registerCast("great_blade");
    public static CastObject large_round_plate_cast = registerCast("large_round_plate");

    public static Item register() {
        return new Item(new Item.Properties().tab(group));
    }

    public static BlockItem registerItemBlock(Block block) {
        return new BlockItem(block, new Item.Properties().tab(group));
    }

    public static CastObject registerCast(String name) {
        RegistryObject<Item> gold_cast = ITEMS.register(name+"_cast_gold", TinkersReforgedItems::register);
        RegistryObject<Item> sand_cast = ITEMS.register(name+"_cast_sand", TinkersReforgedItems::register);
        RegistryObject<Item> red_sand_cast = ITEMS.register(name+"_cast_red_sand", TinkersReforgedItems::register);
        return new CastObject("tconstruct:"+name, gold_cast, sand_cast, red_sand_cast);
    }

    public static void registerCasts() {
        for(CastType type : CastType.values()) {
            RegistryObject<Item> cast = TinkersReforgedItems.ITEMS.register(String.format("cast_%s", type.name().toLowerCase()), TinkersReforgedItems::register);
            casts.put(type, cast);
        }
    }
}
