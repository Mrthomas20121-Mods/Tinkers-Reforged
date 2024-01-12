package mrthomas20121.tinkers_reforged.util;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public enum ReforgedTiers implements Tier {

    KEPU(5, 2031, 10.0F, 5.0F, 15, () -> Ingredient.of(TinkersReforgedItems.aluminum_dust.get()), null);

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;
    private final TagKey<Block> tag;

    private ReforgedTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> supplier, TagKey<Block> tag) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Lazy.of(supplier);
        this.tag = tag;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Nullable
    @Override
    public TagKey<Block> getTag() {
        return tag;
    }
}
