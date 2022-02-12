package mrthomas20121.tinkers_reforged.datagen;


import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReforgedLootTables extends LootTableProvider {

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> lootTables = ImmutableList.of(Pair.of(ReforgedBlocksLoot::new, LootParameterSets.BLOCK));

    public ReforgedLootTables(DataGenerator gen) {
        super(gen);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation,LootTable> map, @Nonnull ValidationTracker validationtracker) {
        map.forEach((loc, table) -> LootTableManager.validate(validationtracker, loc, table));
        // Remove vanilla's tables, which we also loaded so we can redirect stuff to them.
        // This ensures the remaining generator logic doesn't write those to files.
        map.keySet().removeIf((loc) -> !loc.getNamespace().equals(TinkersReforged.MOD_ID));
    }

    /**
     * Gets a name for this provider, to use in logging.
     */
    @Nonnull
    @Override
    public String getName() {
        return TinkersReforged.MOD_ID + " LootTables";
    }
}
