package mrthomas20121.tinkers_reforged;

import net.minecraftforge.common.ForgeConfigSpec;

public class ReforgedConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final CommonConfig COMMON = new CommonConfig(BUILDER);
    public static final ForgeConfigSpec config = BUILDER.build();

    public static class CommonConfig {

        public ForgeConfigSpec.BooleanValue enableAluminumOre;
        public ForgeConfigSpec.IntValue aluminumCount;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            enableAluminumOre = builder.define("Enable/Disable Aluminum Ore Generation", true);
            aluminumCount = builder.defineInRange("Aluminum Ore Count", 10, 0, 10);
        }
    }
}
