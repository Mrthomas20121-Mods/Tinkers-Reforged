package mrthomas20121.tinkers_reforged.datagen;


import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReforgedLootTables extends LootTableProvider {

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> lootTables = ImmutableList.of(Pair.of(ReforgedBlocksLoot::new, LootContextParamSet.builder().build()));

    public ReforgedLootTables(DataGenerator gen) {
        super(gen);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return lootTables;
    }


    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationtracker) {
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
