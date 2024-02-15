package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TinkersReforgedPotions {

    public static DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TinkersReforged.MOD_ID);
    public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, TinkersReforged.MOD_ID);

    public static RegistryObject<MobEffect> FROZEN = MOB_EFFECTS.register("freeze", EffectFreeze::new);

    public static RegistryObject<Potion> FREEZE_POTION = POTIONS.register("freeze_potion", () -> new Potion("freeze", new MobEffectInstance(FROZEN.get())));


}
