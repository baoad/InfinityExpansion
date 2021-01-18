package io.github.mooy1.infinityexpansion.implementation.generators;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.implementation.blocks.InfinityWorkbench;
import io.github.mooy1.infinityexpansion.implementation.materials.CompressedItem;
import io.github.mooy1.infinityexpansion.implementation.materials.InfinityItem;
import io.github.mooy1.infinityexpansion.implementation.materials.MachineItem;
import io.github.mooy1.infinityexpansion.implementation.materials.SmelteryItem;
import io.github.mooy1.infinityexpansion.setup.categories.Categories;
import io.github.mooy1.infinitylib.PluginUtils;
import io.github.mooy1.infinitylib.objects.AbstractContainer;
import io.github.mooy1.infinitylib.presets.LorePreset;
import io.github.mooy1.infinitylib.presets.MenuPreset;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNet;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Solar panels and some other basic generators
 *
 * @author Mooy1
 *
 * Thanks to
 * @author J3fftw1
 * for some stuff to work off of
 */
public final class EnergyGenerator extends AbstractContainer implements EnergyNetProvider {

    public static void setup(InfinityExpansion plugin) {
        new EnergyGenerator(Categories.BASIC_MACHINES, HYDRO, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SmelteryItem.MAGSTEEL, MachineItem.MACHINE_CIRCUIT, SmelteryItem.MAGSTEEL,
                new ItemStack(Material.BUCKET), SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.BUCKET),
                SmelteryItem.MAGSTEEL, MachineItem.MACHINE_CIRCUIT, SmelteryItem.MAGSTEEL
        }, 6, Type.WATER).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, REINFORCED_HYDRO, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                HYDRO, MachineItem.MACHINE_CIRCUIT, HYDRO,
                MachineItem.MAGSTEEL_PLATE, MachineItem.MACHINE_CORE, MachineItem.MAGSTEEL_PLATE,
                HYDRO, MachineItem.MACHINE_CIRCUIT, HYDRO
        }, 30, Type.WATER).register(plugin);

        new EnergyGenerator(Categories.ADVANCED_MACHINES, GEOTHERMAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MachineItem.MAGSTEEL_PLATE, MachineItem.MAGSTEEL_PLATE, MachineItem.MAGSTEEL_PLATE,
                SlimefunItems.LAVA_GENERATOR_2, SlimefunItems.LAVA_GENERATOR_2, SlimefunItems.LAVA_GENERATOR_2,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CORE, MachineItem.MACHINE_CIRCUIT
        }, 45, Type.GEOTHERMAL).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, REINFORCED_GEOTHERMAL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                GEOTHERMAL, MachineItem.MACHINE_CIRCUIT, GEOTHERMAL,
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_CORE, MachineItem.MACHINE_PLATE,
                GEOTHERMAL, MachineItem.MACHINE_CIRCUIT, GEOTHERMAL
        }, 225, Type.GEOTHERMAL).register(plugin);

        new EnergyGenerator(Categories.BASIC_MACHINES, BASIC_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SmelteryItem.MAGSTEEL, MachineItem.MAGSTEEL_PLATE, SmelteryItem.MAGSTEEL,
                SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT
        }, 9, Type.SOLAR).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, ADVANCED_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BASIC_PANEL, BASIC_PANEL, BASIC_PANEL,
                SmelteryItem.TITANIUM, SlimefunItems.SOLAR_GENERATOR_4, SmelteryItem.TITANIUM,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CIRCUIT
        }, 180, Type.SOLAR).register(plugin);

        new EnergyGenerator(Categories.ADVANCED_MACHINES, CELESTIAL_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                MachineItem.MACHINE_PLATE, MachineItem.MACHINE_PLATE, MachineItem.MACHINE_PLATE,
                ADVANCED_PANEL, ADVANCED_PANEL, ADVANCED_PANEL,
                MachineItem.MACHINE_CIRCUIT, MachineItem.MACHINE_CORE, MachineItem.MACHINE_CIRCUIT
        }, 750, Type.SOLAR).register(plugin);
        new EnergyGenerator(Categories.ADVANCED_MACHINES, VOID_PANEL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT, CompressedItem.VOID_INGOT,
                CELESTIAL_PANEL, CELESTIAL_PANEL, CELESTIAL_PANEL,
                SmelteryItem.MAGNONIUM, SmelteryItem.MAGNONIUM, SmelteryItem.MAGNONIUM
        }, 3600, Type.LUNAR).register(plugin);

        new EnergyGenerator(Categories.INFINITY_CHEAT, INFINITE_PANEL, InfinityWorkbench.TYPE, new ItemStack[] {
                EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL,
                EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL, EnergyGenerator.CELESTIAL_PANEL,
                SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, InfinityItem.CIRCUIT, InfinityItem.CORE, InfinityItem.CORE, InfinityItem.CIRCUIT, SmelteryItem.INFINITY,
                SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY, SmelteryItem.INFINITY,
                EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL, EnergyGenerator.VOID_PANEL
        }, 75000, Type.INFINITY).register(plugin);
    }
    
    public static final SlimefunItemStack HYDRO = new SlimefunItemStack(
            "HYDRO_GENERATOR",
            Material.PRISMARINE_WALL,
            "&9Hydro Generator",
            "&7Generates energy from the movement of water",
            "",
            LorePreset.energyBuffer(600),
            LorePreset.energyPerSecond(6)
    );
    public static final SlimefunItemStack REINFORCED_HYDRO = new SlimefunItemStack(
            "REINFORCED_HYDRO_GENERATOR",
            Material.END_STONE_BRICK_WALL,
            "&fReinforced &9Hydro Gen",
            "&7Generates large amounts of energy",
            "&7from the movement of water",
            "",
            LorePreset.energyBuffer(3000),
            LorePreset.energyPerSecond(30)
    );
    public static final SlimefunItemStack GEOTHERMAL = new SlimefunItemStack(
            "GEOTHERMAL_GENERATOR",
            Material.MAGMA_BLOCK,
            "&cGeothermal Generator",
            "&7Generates energy from the heat of the world",
            "",
            LorePreset.energyBuffer(4500),
            LorePreset.energyPerSecond(45)
    );
    public static final SlimefunItemStack REINFORCED_GEOTHERMAL = new SlimefunItemStack(
            "REINFORCED_GEOTHERMAL_GENERATOR",
            Material.SHROOMLIGHT,
            "&fReinforced &cGeothermal Gen",
            "&7Generates large amounts of energy",
            "&7from the heat of the world",
            "",
            LorePreset.energyBuffer(22500),
            LorePreset.energyPerSecond(225)
    );
    public static final SlimefunItemStack BASIC_PANEL = new SlimefunItemStack(
            "BASIC_PANEL",
            Material.BLUE_GLAZED_TERRACOTTA,
            "&9Basic Solar Panel",
            "&7Generates energy from the sun",
            "",
            LorePreset.energyBuffer(900),
            LorePreset.energyPerSecond(9)
    );
    public static final SlimefunItemStack ADVANCED_PANEL = new SlimefunItemStack(
            "ADVANCED_PANEL",
            Material.RED_GLAZED_TERRACOTTA,
            "&cAdvanced Solar Panel",
            "&7Generates energy from the sun",
            "",
            LorePreset.energyBuffer(18000),
            LorePreset.energyPerSecond(180)
    );
    public static final SlimefunItemStack CELESTIAL_PANEL = new SlimefunItemStack(
            "CELESTIAL_PANEL",
            Material.YELLOW_GLAZED_TERRACOTTA,
            "&eCelestial Panel",
            "&7Generates energy from the sun",
            "",
            LorePreset.energyBuffer(75000),
            LorePreset.energyPerSecond(750)
    );
    public static final SlimefunItemStack VOID_PANEL = new SlimefunItemStack(
            "VOID_PANEL",
            Material.LIGHT_GRAY_GLAZED_TERRACOTTA,
            "&8Void Panel",
            "&7Generates energy from darkness",
            "",
            LorePreset.energyBuffer(360000),
            LorePreset.energyPerSecond(3600)
    );
    public static final SlimefunItemStack INFINITE_PANEL = new SlimefunItemStack(
            "INFINITE_PANEL",
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
            "&bInfinity Panel",
            "&7Generates energy from the cosmos",
            "",
            LorePreset.energyBuffer(7500000),
            LorePreset.energyPerSecond(75000)
    );

    private final Type type;
    private final int generation;
    private final int storage;

    private EnergyGenerator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int generation, Type type) {
        super(category, item, recipeType, recipe);
        this.type = type;
        this.generation = generation;
        this.storage = generation * 100;
    }

    public void setupInv(@Nonnull BlockMenuPreset blockMenuPreset) {
        for (int i = 0 ; i < 9 ; i++) {
            blockMenuPreset.addItem(i, MenuPreset.borderItemStatus, ChestMenuUtils.getEmptyClickHandler());
        }
        blockMenuPreset.addItem(4, MenuPreset.loadingItemRed, ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    public int[] getTransportSlots(@Nonnull ItemTransportFlow flow) {
        return new int[0];
    }

    @Override
    public void tick(@Nonnull Block b, @Nonnull BlockMenu inv) {
        if (inv.hasViewer()) {
            if (!SlimefunPlugin.getNetworkManager().getNetworkFromLocation(b.getLocation(), EnergyNet.class).isPresent()) {
                inv.replaceExistingItem(4, MenuPreset.connectToEnergyNet);
            }
        }
    }

    @Override
    public void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {

    }

    public int getGeneratedOutput(@Nonnull Location l, @Nonnull Config data) {
        @Nullable final BlockMenu inv = BlockStorage.getInventory(l);
        if (inv == null) return 0;

        Type type = getGeneration(l.getBlock(), Objects.requireNonNull(l.getWorld()));
        
        if (type == null) {
            if (inv.hasViewer()) {
                inv.replaceExistingItem(4, new CustomItem(
                        Material.GREEN_STAINED_GLASS_PANE,
                        "&cNot generating",
                        "&7Stored: &6" + LorePreset.format(getCharge(l)) + " J"
                ));
            }
            return 0;
        } else {
            int gen = type.more ? this.generation + this.generation >> 1 : this.generation;
            if (inv.hasViewer()) {
                inv.replaceExistingItem(4, new CustomItem(
                        Material.GREEN_STAINED_GLASS_PANE,
                        "&aGeneration",
                        "&7Type: &6" + type.status,
                        "&7Generating: &6" + LorePreset.roundHundreds(this.generation * PluginUtils.TICK_RATIO) + " J/s ",
                        "&7Stored: &6" + LorePreset.format(getCharge(l)) + " J"
                ));
            }
            return gen;
        }
    }

    private Type getGeneration(@Nonnull Block block, @Nonnull World world) {
        if (this.type == Type.WATER) {

            // don't check water log every tick
            if (InfinityExpansion.progressEvery(8)) {
                BlockData blockData = block.getBlockData();

                if (blockData instanceof Waterlogged) {
                    Waterlogged waterLogged = (Waterlogged) blockData;
                    if (waterLogged.isWaterlogged()) {
                        BlockStorage.addBlockInfo(block.getLocation(), "water_logged", "true");
                        return Type.WATER;
                    } else {
                        BlockStorage.addBlockInfo(block.getLocation(), "water_logged", "false");
                    }
                }

            } else if (Objects.equals(BlockStorage.getLocationInfo(block.getLocation(), "water_logged"), "true")) {
                return Type.WATER;
            }

        } else if (this.type == Type.INFINITY) {

            return Type.INFINITY;

        } else if (world.getEnvironment() == World.Environment.NETHER) {

            if (this.type == Type.GEOTHERMAL) {
                return Type.NETHER;
            }

            if (this.type == Type.LUNAR) {
                return Type.DARKNESS;
            }

        } else if (world.getEnvironment() == World.Environment.THE_END) {

            if (this.type == Type.LUNAR) {
                return Type.DARKNESS;
            }

        } else if (world.getEnvironment() == World.Environment.NORMAL) {

            if (this.type == Type.GEOTHERMAL) {
                return Type.GEOTHERMAL;
            }

            if (world.getTime() >= 13000 || block.getLocation().add(0, 1, 0).getBlock().getLightFromSky() != 15) {

                if (this.type == Type.LUNAR) {
                    return Type.LUNAR;
                }

            } else if (this.type == Type.SOLAR) {
                return Type.SOLAR;
            }
        }

        return null;
    }

    @Override
    public int getCapacity() {
        return this.storage;
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.GENERATOR;
    }

    private enum Type {
        WATER("Hydroelectric", false),
        GEOTHERMAL("Geothermal", false),
        SOLAR("Day", false),
        DARKNESS("Darkness", false),
        INFINITY("Infinity", false),
        
        LUNAR("Night", false),
        NETHER("Nether (2x)", true);
        
        private final String status;
        private final boolean more;
        
        Type(String status, boolean more) {
            this.status = status;
            this.more = more;
        }
        
    }

}