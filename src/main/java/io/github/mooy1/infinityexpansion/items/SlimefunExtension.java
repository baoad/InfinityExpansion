package io.github.mooy1.infinityexpansion.items;

import javax.annotation.Nonnull;

import io.github.mooy1.infinityexpansion.items.machines.ConcreteMoldingMachine;
import lombok.experimental.UtilityClass;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.categories.Categories;
import io.github.mooy1.infinityexpansion.items.blocks.InfinityWorkbench;
import io.github.mooy1.infinitylib.presets.LorePreset;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.Capacitor;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ChargingBench;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricSmeltery;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.enchanting.AutoDisenchanter;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.enchanting.AutoEnchanter;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.reactors.NetherStarReactor;
import io.github.thebusybiscuit.slimefun4.implementation.items.geo.GEOMiner;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

@UtilityClass
public final class SlimefunExtension {
    
    private static final int INFINITY_CAPACITY = 2000000000;
    private static final int VOID_CAPACITY = 16000000;

    private static final int ADVANCED_GEO_SPEED = 4;
    private static final int ADVANCED_GEO_ENERGY = 120;

    private static final int ADVANCED_EN_SPEED = 5;
    private static final int ADVANCED_EN_ENERGY = 180;

    private static final int ADVANCED_DIS_SPEED = 5;
    private static final int ADVANCED_DIS_ENERGY = 180;

    private static final int INFINITY_EN_SPEED = 75;
    private static final int INFINITY_EN_ENERGY = 12000;

    private static final int INFINITY_DIS_SPEED = 90;
    private static final int INFINITY_DIS_ENERGY = 12000;

    private static final int ADVANCED_CHARGER_SPEED = 30;
    private static final int ADVANCED_CHARGER_ENERGY = 180;

    private static final int INFINITY_CHARGER_SPEED = 6000;
    private static final int INFINITY_CHARGER_ENERGY = 60000;

    private static final int ADVANCED_SMELTERY_ENERGY = 240;
    private static final int ADVANCED_SMELTERY_SPEED = 24;

    private static final int STAR_ENERGY = 1800;
    private static final int STAR_BUFFER = 90000;

    private static final int CMM_ENERGY = 80;
    private static final int CMM_SPEED = 8;
    
    public static final SlimefunItemStack ADVANCED_GEO_MINER = new SlimefunItemStack(
            "ADVANCED_GEO_MINER",
            HeadTexture.GEO_MINER,
            "&c高级 &fGeo矿机",
            "&7高级的 geo-矿机",
            "",
            LorePreset.speed(SlimefunExtension.ADVANCED_GEO_SPEED),
            LorePreset.energyPerSecond(SlimefunExtension.ADVANCED_GEO_ENERGY)
    );
    public static final SlimefunItemStack ADVANCED_SMELTERY = new SlimefunItemStack(
            "ADVANCED_SMELTERY",
            Material.FURNACE,
            "&c高级&7冶炼厂",
            "&7冶炼厂",
            "",
            LorePreset.speed(ADVANCED_SMELTERY_SPEED),
            LorePreset.energyPerSecond(ADVANCED_SMELTERY_ENERGY)
    );
    public static final SlimefunItemStack ADVANCED_CHARGER = new SlimefunItemStack(
            "ADVANCED_CHARGER",
            Material.HONEYCOMB_BLOCK,
            "&c高级充电器",
            "&7快速给你的物品充电",
            "",
            LorePreset.speed(SlimefunExtension.ADVANCED_CHARGER_SPEED),
            LorePreset.energyPerSecond(SlimefunExtension.ADVANCED_CHARGER_ENERGY)
    );
    public static final SlimefunItemStack INFINITY_CHARGER = new SlimefunItemStack(
            "INFINITY_CHARGER",
            Material.SEA_LANTERN,
            "&b无尽充电器",
            "&7快速给你物品充电",
            "",
            LorePreset.speed(SlimefunExtension.INFINITY_CHARGER_SPEED),
            LorePreset.energy(SlimefunExtension.INFINITY_CHARGER_ENERGY) + "每次使用"
    );
    public static final SlimefunItemStack ADVANCED_NETHER_STAR_REACTOR = new SlimefunItemStack(
            "ADVANCED_NETHER_STAR_REACTOR",
            HeadTexture.NETHER_STAR_REACTOR,
            "&c高级的下届之星反应堆",
            "&f利用最大化",
            "&b要被水包围",
            "&b必须放入冷却剂",
            "&4会导致附近的生命体凋零",
            "",
            LorePreset.energyBuffer(SlimefunExtension.STAR_BUFFER),
            LorePreset.energyPerSecond(SlimefunExtension.STAR_ENERGY)
    );
    public static final SlimefunItemStack ADVANCED_ENCHANTER = new SlimefunItemStack(
            "ADVANCED_ENCHANTER",
            Material.ENCHANTING_TABLE,
            "&c高级附魔机",
            "",
            LorePreset.speed(SlimefunExtension.ADVANCED_EN_SPEED),
            LorePreset.energyPerSecond(SlimefunExtension.ADVANCED_EN_ENERGY)
    );
    public static final SlimefunItemStack ADVANCED_DISENCHANTER = new SlimefunItemStack(
            "ADVANCED_DISENCHANTER",
            Material.ENCHANTING_TABLE,
            "&c高级驱魔机",
            "",
            LorePreset.speed(SlimefunExtension.ADVANCED_DIS_SPEED),
            LorePreset.energyPerSecond(SlimefunExtension.ADVANCED_DIS_ENERGY)
    );
    public static final SlimefunItemStack INFINITY_ENCHANTER = new SlimefunItemStack(
            "INFINITY_ENCHANTER",
            Material.ENCHANTING_TABLE,
            "&b无尽附魔机",
            "",
            LorePreset.speed(SlimefunExtension.INFINITY_EN_SPEED),
            LorePreset.energy(SlimefunExtension.INFINITY_EN_ENERGY) + "每次使用"
    );
    public static final SlimefunItemStack INFINITY_DISENCHANTER = new SlimefunItemStack(
            "INFINITY_DISENCHANTER",
            Material.ENCHANTING_TABLE,
            "&b无尽驱魔机",
            "",
            LorePreset.speed(SlimefunExtension.INFINITY_DIS_SPEED),
            LorePreset.energy(SlimefunExtension.INFINITY_DIS_ENERGY) + "每次使用"
    );
    public static final SlimefunItemStack INFINITY_CAPACITOR = new SlimefunItemStack(
            "INFINITY_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&b无尽电容器",
            "&c&o储存无尽的电量",
            "&c&o需要连接能源网络",
            "",
            "&8\u21E8 &e\u26A1 " + LorePreset.format(INFINITY_CAPACITY) + " &7J 能量"
    );
    public static final SlimefunItemStack VOID_CAPACITOR = new SlimefunItemStack(
            "VOID_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&8虚空电容器",
            "",
            "&8\u21E8 &e\u26A1 " + LorePreset.format(VOID_CAPACITY) + " &7J 能量"
    );
    public static final SlimefunItemStack CONCRETE_MOLDING_MACHINE = new SlimefunItemStack(
            "CONCRETE_MOLDING_MACHINE",
            Material.FURNACE,
            "&8混凝土成型机",
            "&7全自动给混凝土成型",
            LorePreset.speed(SlimefunExtension.CMM_SPEED),
            LorePreset.energyPerSecond(SlimefunExtension.CMM_ENERGY)
    );


    public static void setup(InfinityExpansion plugin) {

        AContainer AMachine = new ConcreteMoldingMachine(Categories.ADVANCED_MACHINES, CONCRETE_MOLDING_MACHINE,
               RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
               Materials.VOID_INGOT, Materials.VOID_DUST, Materials.VOID_INGOT,
               Materials.VOID_INGOT, SlimefunItems.FLUID_PUMP, Materials.VOID_INGOT,
               SlimefunItems.AUTO_DRIER, SlimefunItems.BIG_CAPACITOR, SlimefunItems.AUTO_DRIER
        })
       .setCapacity(1024).setEnergyConsumption(80).setProcessingSpeed(8);
        AMachine.registerRecipe(16, new ItemStack(Material.WHITE_CONCRETE_POWDER, 8),  new ItemStack(Material.WHITE_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.ORANGE_CONCRETE_POWDER, 8),  new ItemStack(Material.ORANGE_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.MAGENTA_CONCRETE_POWDER, 8),  new ItemStack(Material.MAGENTA_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER, 8),  new ItemStack(Material.LIGHT_BLUE_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.YELLOW_CONCRETE_POWDER, 8),  new ItemStack(Material.YELLOW_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.LIME_CONCRETE_POWDER, 8),  new ItemStack(Material.LIME_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.PINK_CONCRETE_POWDER, 8),  new ItemStack(Material.PINK_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.GRAY_CONCRETE_POWDER, 8),  new ItemStack(Material.GRAY_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER, 8),  new ItemStack(Material.LIGHT_GRAY_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.CYAN_CONCRETE_POWDER, 8),  new ItemStack(Material.CYAN_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.PURPLE_CONCRETE_POWDER, 8),  new ItemStack(Material.PURPLE_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.BLUE_CONCRETE_POWDER, 8),  new ItemStack(Material.BLUE_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.BROWN_CONCRETE_POWDER, 8),  new ItemStack(Material.BROWN_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.GREEN_CONCRETE_POWDER, 8),  new ItemStack(Material.GREEN_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.RED_CONCRETE_POWDER, 8),  new ItemStack(Material.RED_CONCRETE, 8));
        AMachine.registerRecipe(16, new ItemStack(Material.BLACK_CONCRETE_POWDER, 8),  new ItemStack(Material.BLACK_CONCRETE, 8));
        AMachine.register(plugin);

        new Capacitor(Categories.INFINITY_CHEAT, INFINITY_CAPACITY, INFINITY_CAPACITOR,
                InfinityWorkbench.TYPE, new ItemStack[] {
                null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ENERGIZED_CAPACITOR, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.ENERGIZED_CAPACITOR, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null
        }).register(plugin);

        new Capacitor(Categories.ADVANCED_MACHINES, VOID_CAPACITY, VOID_CAPACITOR,
                RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Materials.VOID_INGOT, Materials.REDSTONE_SINGULARITY, Materials.VOID_INGOT,
                Materials.VOID_INGOT, SlimefunItems.ENERGIZED_CAPACITOR, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.REDSTONE_SINGULARITY, Materials.VOID_INGOT
        }).register(plugin);

        new AutoEnchanter(Categories.ADVANCED_MACHINES, ADVANCED_ENCHANTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Materials.MAGSTEEL, Materials.MAGSTEEL, Materials.MAGSTEEL,
                Materials.MAGSTEEL_PLATE, SlimefunItems.AUTO_ENCHANTER, Materials.MAGSTEEL_PLATE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }) {
            @Override
            public ItemStack getProgressBar() {
                return new ItemStack(Material.NETHERITE_CHESTPLATE);
            }
        }.setCapacity(ADVANCED_EN_ENERGY).setEnergyConsumption(ADVANCED_EN_ENERGY).setProcessingSpeed(ADVANCED_EN_SPEED).register(plugin);

        new AutoDisenchanter(Categories.ADVANCED_MACHINES, ADVANCED_DISENCHANTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Materials.MAGSTEEL, Materials.MAGSTEEL, Materials.MAGSTEEL,
                Materials.MAGSTEEL_PLATE, SlimefunItems.AUTO_DISENCHANTER, Materials.MAGSTEEL_PLATE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }) {
            @Override
            public ItemStack getProgressBar() {
                return new ItemStack(Material.ENCHANTED_BOOK);
            }
        }.setCapacity(ADVANCED_DIS_ENERGY).setEnergyConsumption(ADVANCED_DIS_ENERGY).setProcessingSpeed(ADVANCED_DIS_SPEED).register(plugin);

        new AutoEnchanter(Categories.INFINITY_CHEAT, INFINITY_ENCHANTER, InfinityWorkbench.TYPE, new ItemStack[] {
                null, null, null, null, null, null,
                Materials.VOID_INGOT, null, null, null, null, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, ADVANCED_ENCHANTER, ADVANCED_ENCHANTER, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.MACHINE_PLATE
        }) {
            @Override
            public ItemStack getProgressBar() {
                return new ItemStack(Material.NETHERITE_CHESTPLATE);
            }
        }.setCapacity(INFINITY_EN_ENERGY).setEnergyConsumption(INFINITY_EN_ENERGY).setProcessingSpeed(INFINITY_EN_SPEED).register(plugin);

        new AutoDisenchanter(Categories.INFINITY_CHEAT, INFINITY_DISENCHANTER, InfinityWorkbench.TYPE, new ItemStack[] {
                null, null, null, null, null, null,
                Materials.VOID_INGOT, null, null, null, null, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, ADVANCED_DISENCHANTER, ADVANCED_DISENCHANTER, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.VOID_INGOT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.VOID_INGOT, Materials.MACHINE_PLATE,
                Materials.MACHINE_PLATE, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.MACHINE_PLATE
        }) {
            @Override
            public ItemStack getProgressBar() {
                return new ItemStack(Material.ENCHANTED_BOOK);
            }
        }.setCapacity(INFINITY_DIS_ENERGY).setEnergyConsumption(INFINITY_DIS_ENERGY).setProcessingSpeed(INFINITY_DIS_SPEED).register(plugin);

        new ChargingBench(Categories.ADVANCED_MACHINES, ADVANCED_CHARGER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_CIRCUIT, Materials.MAGSTEEL_PLATE,
                Materials.MACHINE_CIRCUIT, SlimefunItems.CHARGING_BENCH, Materials.MACHINE_CIRCUIT,
                Materials.MAGSTEEL_PLATE, Materials.MACHINE_CORE, Materials.MAGSTEEL_PLATE,
        }).setCapacity(ADVANCED_CHARGER_ENERGY).setEnergyConsumption(ADVANCED_CHARGER_ENERGY).setProcessingSpeed(ADVANCED_CHARGER_SPEED).register(plugin);

        new ChargingBench(Categories.INFINITY_CHEAT, INFINITY_CHARGER, InfinityWorkbench.TYPE, new ItemStack[] {
                null, null, null, null, null, null,
                Materials.VOID_INGOT, Materials.MACHINE_CIRCUIT, Materials.MACHINE_CIRCUIT, Materials.MACHINE_CIRCUIT, Materials.MACHINE_CIRCUIT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.MACHINE_CIRCUIT, ADVANCED_CHARGER, ADVANCED_CHARGER, Materials.MACHINE_CIRCUIT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.MACHINE_CIRCUIT, ADVANCED_CHARGER, ADVANCED_CHARGER, Materials.MACHINE_CIRCUIT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_CIRCUIT, Materials.INFINITE_CORE, Materials.INFINITE_CORE, Materials.INFINITE_CIRCUIT, Materials.VOID_INGOT,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT
        }).setCapacity(INFINITY_CHARGER_ENERGY).setEnergyConsumption(INFINITY_CHARGER_ENERGY).setProcessingSpeed(INFINITY_CHARGER_SPEED).register(plugin);

        new GEOMiner(Categories.ADVANCED_MACHINES, ADVANCED_GEO_MINER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, Materials.MAGSTEEL_PLATE, Materials.MAGSTEEL_PLATE,
                SlimefunItems.COBALT_PICKAXE, SlimefunItems.GEO_MINER, SlimefunItems.COBALT_PICKAXE,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).setCapacity(ADVANCED_GEO_ENERGY).setProcessingSpeed(ADVANCED_GEO_SPEED).setEnergyConsumption(ADVANCED_GEO_ENERGY).register(plugin);

        new NetherStarReactor(Categories.ADVANCED_MACHINES, ADVANCED_NETHER_STAR_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.WITHER_PROOF_GLASS, SlimefunItems.WITHER_PROOF_GLASS, SlimefunItems.WITHER_PROOF_GLASS,
                Materials.MACHINE_CIRCUIT, SlimefunItems.NETHER_STAR_REACTOR, Materials.MACHINE_CIRCUIT,
                SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN,
        }){

            @Override
            public int getCapacity() {
                return STAR_BUFFER;
            }

            @Override
            public int getEnergyProduction() {
                return STAR_ENERGY;
            }

            @Override
            protected void registerDefaultFuelTypes() {
                registerFuel(new MachineFuel(600, new ItemStack(Material.NETHER_STAR)));
            }

            @Override
            public void extraTick(@Nonnull Location l) {
                if ((InfinityExpansion.inst().getGlobalTick()  & 3) != 0) {
                    return;
                }
                InfinityExpansion.inst().runSync(() -> {
                    Location check = l.clone().add(0, 1, 0);
                    World w = check.getWorld();
                    if (w == null) {
                        return;
                    }
                    boolean checkWitherProof = check.getBlock().getType() == Material.AIR;
                    for (Entity entity : w.getNearbyEntities(check, 8, 8, 8)) {
                        if (entity instanceof LivingEntity && entity.isValid()) {
                            if (checkWitherProof) {
                                RayTraceResult result = w.rayTraceBlocks(check, entity.getLocation().subtract(check).toVector(), 16);
                                if (result != null) {
                                    Block hit = result.getHitBlock();
                                    if (hit != null) {
                                        String id = BlockStorage.getLocationInfo(hit.getLocation(), "id");
                                        if (id != null && id.contains("WITHER_PROOF")) {
                                            continue;
                                        }
                                    }
                                }
                            }
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 2));
                        }
                    }
                });
            }
        }.register(plugin);
        
        new ElectricSmeltery(Categories.ADVANCED_MACHINES, ADVANCED_SMELTERY, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ELECTRIC_SMELTERY_2, SlimefunItems.ELECTRIC_SMELTERY_2, SlimefunItems.ELECTRIC_SMELTERY_2,
                SlimefunItems.ELECTRIC_SMELTERY_2, SlimefunItems.ELECTRIC_SMELTERY_2, SlimefunItems.ELECTRIC_SMELTERY_2,
                Materials.MACHINE_CIRCUIT, Materials.MACHINE_CORE, Materials.MACHINE_CIRCUIT
        }).setCapacity(ADVANCED_SMELTERY_ENERGY).setProcessingSpeed(ADVANCED_SMELTERY_SPEED).setEnergyConsumption(ADVANCED_SMELTERY_ENERGY).register(plugin);
    }
}
