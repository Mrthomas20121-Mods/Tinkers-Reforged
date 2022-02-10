package mrthomas20121.tinkers_reforged.api;

import net.minecraftforge.eventbus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;

public class DeferredRegistrerFluid {

    private static List<ReforgedFluid> fluids = new ArrayList<>();

    public void register(IEventBus bus) {
        fluids.forEach(reforgedFluid -> {
            reforgedFluid.getFLUIDS().register(bus);
            reforgedFluid.getBLOCKS().register(bus);
            reforgedFluid.getITEMS().register(bus);
        });
    }

    public ReforgedFluid register(String key, int temp, int light) {
        ReforgedFluid fluid = ReforgedFluid.register(key, temp, light);
        fluids.add(fluid);
        return fluid;
    }
}
