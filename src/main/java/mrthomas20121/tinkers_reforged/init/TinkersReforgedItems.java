package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.cast.TinkerCastType;
import mrthomas20121.tinkers_reforged.item.CastObject;
import mrthomas20121.tinkers_reforged.item.book.TinkersReforgedBookItem;
import mrthomas20121.tinkers_reforged.util.Helpers;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.util.SupplierCreativeTab;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinkersReforgedItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersReforged.MOD_ID);

    public static final CreativeModeTab resourceTab = new SupplierCreativeTab(TinkersReforged.MOD_ID, "resources",
            () -> new ItemStack(TinkersReforgedItems.METALS.get(EnumMetal.ALUMINUM).get(EnumMetal.ItemType.INGOT).get()));

    public static final CreativeModeTab castTab = new SupplierCreativeTab(TinkersReforged.MOD_ID, "casts",
            () -> new ItemStack(TinkersReforgedItems.ALU_CASTS.get(CastType.GEAR).get()));

    public static final CreativeModeTab TAB_TOOL_PARTS = new SupplierCreativeTab(TinkersReforged.MOD_ID, "tool_parts", () -> {
        List<IMaterial> materials = new ArrayList<>(MaterialRegistry.getInstance().getVisibleMaterials());
        if (materials.isEmpty()) {
            return new ItemStack(TinkersReforgedItems.LONG_BLADE.get());
        }
        return TinkersReforgedItems.LONG_BLADE.get().withMaterial(materials.get(TConstruct.RANDOM.nextInt(materials.size())).getIdentifier());
    });

    public static final CreativeModeTab TAB_TOOLS = new SupplierCreativeTab(TinkersReforged.MOD_ID, "tools", () -> TinkersReforgedItems.LONGSWORD.get().getRenderTool());

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(TAB_TOOLS);
    private static final Item.Properties PARTS_PROPS = new Item.Properties().tab(TAB_TOOL_PARTS);

    public static RegistryObject<Item> book = ITEMS.register("reforging_guide", () -> new TinkersReforgedBookItem(new Item.Properties().stacksTo(1).tab(resourceTab)));

    public static RegistryObject<Item> ender_bone = ITEMS.register("ender_bone", TinkersReforgedItems::register);

    public static Map<EnumMetal, RegistryObject<Item>> RAW_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal ->
            ITEMS.register("raw_%s".formatted(metal.getName()), () -> new Item(new Item.Properties().tab(resourceTab))));

    public static Map<EnumMetal, Map<EnumMetal.ItemType, RegistryObject<Item>>> METALS = Helpers.mapOfKeys(EnumMetal.class, metal ->
            Helpers.mapOfKeys(EnumMetal.ItemType.class, itemType -> ITEMS.register("%s_%s".formatted(metal.getName(), itemType.getName()), () -> new Item(new Item.Properties().tab(resourceTab)))));

    public static Map<EnumGem, Map<EnumGem.ItemType, RegistryObject<Item>>> GEMS = Helpers.mapOfKeys(EnumGem.class, gem ->
            Helpers.mapOfKeys(EnumGem.ItemType.class, itemType -> ITEMS.register("%s_%s".formatted(gem.getName(), itemType.getName()), () -> new Item(new Item.Properties().tab(resourceTab)))));

    public static Map<TinkerCastType, Map<TinkerCastType.Type, RegistryObject<Item>>> CASTS = Helpers.mapOfKeys(TinkerCastType.class, cast ->
            Helpers.mapOfKeys(TinkerCastType.Type.class, type -> ITEMS.register("%s_%s_cast".formatted(type.getName(), cast.getName()), () -> new Item(new Item.Properties().tab(castTab)))));

    public static Map<CastType, RegistryObject<Item>> ALU_CASTS = Helpers.mapOfKeys(CastType.class, cast -> ITEMS.register("aluminum_%s_cast".formatted(cast.getName()), () -> new Item(new Item.Properties().tab(castTab))));

    public static final RegistryObject<ToolPartItem> GREAT_BLADE = ITEMS.register("great_blade", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));

    public static final RegistryObject<ToolPartItem> LONG_BLADE = ITEMS.register("long_blade", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));

    public static final RegistryObject<ModifiableItem> LONGSWORD = ITEMS.register("longsword", () -> new ModifiableItem(TOOL, TinkersReforgedToolDefinitions.LONGSWORD));

    public static final RegistryObject<ModifiableItem> GREATSWORD = ITEMS.register("greatsword", () -> new ModifiableItem(TOOL, TinkersReforgedToolDefinitions.GREATSWORD));

    public static CastObject great_blade_cast = new CastObject("great_blade");

    public static CastObject long_blade_cast = new CastObject("long_blade");

    public static Item register() {
        return new Item(new Item.Properties().tab(resourceTab));
    }

}
