package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TinkersReforgedPotions {

    public static DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TinkersReforged.MOD_ID);

    public static RegistryObject<MobEffect> FUNGAL = MOB_EFFECTS.register("fungal", EffectFungal::new);
    public static RegistryObject<MobEffect> REQUIEM = MOB_EFFECTS.register("requiem", RequiemEffect::new);


}
