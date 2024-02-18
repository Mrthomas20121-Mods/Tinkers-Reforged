package mrthomas20121.tinkers_reforged;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class TinkersReforgedConfig {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec config;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = pair.getLeft();
        config = pair.getRight();
    }

    public static class CommonConfig {
        public final Map<String, OreConfig> ores = new HashMap<>();

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Ore Generation").push("ores");
            ores.put("aluminum", new BauxiteOreConfig(builder));
            ores.put("gallium", new GalliumOreConfig(builder));
            ores.put("titanium", new TitaniumOreConfig(builder));
            ores.put("kepu", new KepuOreConfig(builder));
            ores.put("epidote", new EpidoteOreConfig(builder));
            ores.put("hureaulite", new HureauliteOreConfig(builder));
            ores.put("red_beryl", new RedBerylOreConfig(builder));

            builder.pop();
        }
    }

    public static class OreConfig {
        public ForgeConfigSpec.BooleanValue enabled;
        public ForgeConfigSpec.IntValue minY;
        public ForgeConfigSpec.IntValue maxY;
        public ForgeConfigSpec.IntValue count;
        public ForgeConfigSpec.IntValue size;

        public OreConfig(ForgeConfigSpec.Builder builder, String name) {
            builder.push(name);
        }

        public boolean isEnabled() {
            return enabled.get();
        }

        public int getCount() {
            return count.get();
        }

        public int getSize() {
            return size.get();
        }

        public int getMaxY() {
            return maxY.get();
        }

        public int getMinY() {
            return minY.get();
        }
    }

    public static class BauxiteOreConfig extends OreConfig {

        public BauxiteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "bauxite");
            this.enabled = builder.worldRestart().comment("Enable/Disable Bauxite ore").define("bauxiteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 120, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 50, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 10);
        }
    }

    public static class GalliumOreConfig extends OreConfig {

        public GalliumOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "gallium");
            this.enabled = builder.worldRestart().comment("Enable/Disable Gallium ore").define("galliumOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 120, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 40, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 6, 1, 10);
        }
    }

    public static class KepuOreConfig extends OreConfig {

        public KepuOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "kepu");
            this.enabled = builder.worldRestart().comment("Enable/Disable Kepu ore").define("kepuOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -20, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 100, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 3, 1, 40);
        }
    }

    public static class TitaniumOreConfig extends OreConfig {

        public TitaniumOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "titanium");
            this.enabled = builder.worldRestart().comment("Enable/Disable Titanium ore").define("titaniumOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -20, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 100, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 18, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 40);
        }
    }

    public static class EpidoteOreConfig extends OreConfig {

        public EpidoteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "epidote");
            this.enabled = builder.worldRestart().comment("Enable/Disable Epidote ore").define("epidoteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 5, -60, 5);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 40);
        }
    }

    public static class HureauliteOreConfig extends OreConfig {

        public HureauliteOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "hureaulite");
            this.enabled = builder.worldRestart().comment("Enable/Disable Hureaulite ore").define("hureauliteOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -60, -80, 0);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 5, -60, 5);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 20, 1, 40);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 4, 1, 40);
        }
    }

    public static class RedBerylOreConfig extends OreConfig {

        public RedBerylOreConfig(ForgeConfigSpec.Builder builder) {
            super(builder, "red_beryl");
            this.enabled = builder.comment("Enable/Disable Red Beryl ore").define("redBerylOreEnabled", true);
            this.minY = builder.comment("Min Y level").defineInRange("minY", -40, -60, 256);
            this.maxY = builder.comment("Max Y Level").defineInRange("maxY", 60, -60, 256);
            this.count = builder.comment("Ore vein count").defineInRange("veinCount", 40, 1, 100);
            this.size = builder.comment("Ore vein size").defineInRange("veinSize", 5, 1, 10);
        }
    }
}
