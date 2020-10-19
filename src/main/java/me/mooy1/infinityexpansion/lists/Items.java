package me.mooy1.infinityexpansion.lists;

import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mooy1.infinityexpansion.InfinityExpansion;
import me.mooy1.infinityexpansion.implementation.items.StrainerBase;
import me.mooy1.infinityexpansion.implementation.storage.StorageUnit;
import me.mooy1.infinityexpansion.implementation.machines.*;
import me.mooy1.infinityexpansion.setup.ItemSetup;
import me.mooy1.infinityexpansion.utils.LoreUtils;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {

    //Machines

    public static final SlimefunItemStack ITEM_UPDATER = new SlimefunItemStack(
            "ITEM_UPDATER",
            Material.QUARTZ_PILLAR,
            "&6Item Updater",
            "&7Will &creset &7and update the name and lore of",
            "&7slimefun items if they are outdated or broken",
            "&cAll enchants will be removed, disenchant first!",
            "&cChargeable and upgradeable items will be reset!",
            "",
            LoreUtils.energyPer(ItemUpdater.ENERGY) + "per item",
            ""
    );
    public static final SlimefunItemStack POWERED_BEDROCK = new SlimefunItemStack(
            "POWERED_BEDROCK",
            Material.NETHERITE_BLOCK,
            "&4Powered &8Bedrock",
            "&7When powered, transforms into a bedrock",
            "&7Will revert once unpowered or broken",
            "",
            LoreUtils.energyPerSecond(PoweredBedrock.ENERGY),
            ""
    );

    public static final SlimefunItemStack VOID_HARVESTER = new SlimefunItemStack(
            "VOID_HARVESTER",
            Material.OBSIDIAN,
            "&8Void &7Harvester",
            "&7Slowly harvests &8Void &7Bits from nothing...",
            "",
            LoreUtils.speed(VoidHarvester.BASIC_SPEED),
            LoreUtils.energyPerSecond(VoidHarvester.BASIC_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITE_VOID_HARVESTER = new SlimefunItemStack(
            "INFINITE_VOID_HARVESTER",
            Material.CRYING_OBSIDIAN,
            "&bInfinite &8Void &7Harvester",
            "&7Harvests &8Void &7Bits from nothing...",
            "",
            LoreUtils.speed(VoidHarvester.INFINITY_SPEED),
            LoreUtils.energyPerSecond(VoidHarvester.INFINITY_ENERGY),
            ""
    );

    public static final SlimefunItemStack SINGULARITY_CONSTRUCTOR = new SlimefunItemStack(
            "SINGULARITY_CONSTRUCTOR",
            Material.QUARTZ_BRICKS,
            "&fSingularity &7Constructor",
            "&7Condenses large amounts of resources",
            "",
            LoreUtils.speed(SingularityConstructor.BASIC_SPEED),
            LoreUtils.energyPerSecond(SingularityConstructor.BASIC_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITY_CONSTRUCTOR = new SlimefunItemStack(
            "INFINITY_CONSTRUCTOR",
            Material.CHISELED_QUARTZ_BLOCK,
            "&bInfinity &7Constructor",
            "&7Quickly condenses large amounts of resources",
            "",
            LoreUtils.speed(SingularityConstructor.INFINITY_SPEED),
            LoreUtils.energyPerSecond(SingularityConstructor.INFINITY_ENERGY),
            ""
    );

    public static final SlimefunItemStack RESOURCE_SYNTHESIZER = new SlimefunItemStack(
            "RESOURCE_SYNTHESIZER",
            Material.BLAST_FURNACE,
            "&6Resource &7Synthesizer",
            "&7Creates resources out of singularities",
            "",
            LoreUtils.energyPer(ResourceSynthesizer.ENERGY) + "per use",
            ""
    );

    public static final SlimefunItemStack INFINITY_REACTOR = new SlimefunItemStack(
            "INFINITY_REACTOR",
            Material.BEACON,
            "&bInfinity Reactor",
            "&7Generates power through the compression",
            "&7of &8Void &7and &bInfinity &7Ingots",
            "",
            LoreBuilder.powerBuffer(InfinityReactor.STORAGE),
            LoreUtils.energyPerSecond(InfinityReactor.ENERGY),
            ""
    );

    public static final SlimefunItemStack ADVANCED_CHARGER = new SlimefunItemStack(
            "ADVANCED_CHARGER",
            Material.HONEYCOMB_BLOCK,
            "&cAdvanced &7Charger",
            "&7Quickly charges items",
            "",
            LoreUtils.speed(ItemSetup.ADVANCED_CHARGER_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.ADVANCED_CHARGER_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITY_CHARGER = new SlimefunItemStack(
            "INFINITY_CHARGER",
            Material.SEA_LANTERN,
            "&bInfinity &7Charger",
            "&7Instantly charges items",
            "",
            LoreUtils.speed(ItemSetup.INFINITY_CHARGER_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.INFINITY_CHARGER_ENERGY),
            ""
    );

    public static final SlimefunItemStack BASIC_QUARRY = new SlimefunItemStack(
            "BASIC_QUARRY",
            Material.CHISELED_SANDSTONE,
            "&9Basic &7Quarry",
            "&7Automatically mines vanilla overworld ores",
            "",
            LoreUtils.speed(Quarry.BASIC_SPEED),
            LoreUtils.energyPerSecond(Quarry.BASIC_ENERGY),
            ""
    );
    public static final SlimefunItemStack ADVANCED_QUARRY = new SlimefunItemStack(
            "ADVANCED_QUARRY",
            Material.CHISELED_RED_SANDSTONE,
            "&cAdvanced &7Quarry",
            "&7Smelts vanilla ores and can mine nether ores",
            "",
            LoreUtils.speed(Quarry.ADVANCED_SPEED),
            LoreUtils.energyPerSecond(Quarry.ADVANCED_ENERGY),
            ""
    );
    public static final SlimefunItemStack VOID_QUARRY = new SlimefunItemStack(
            "VOID_QUARRY",
            Material.CHISELED_NETHER_BRICKS,
            "&8Void &7Quarry",
            "&7Can mine sifted ores or 24 karat gold occasionally",
            "",
            LoreUtils.speed(Quarry.VOID_SPEED),
            LoreUtils.energyPerSecond(Quarry.VOID_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITY_QUARRY = new SlimefunItemStack(
            "INFINITY_QUARRY",
            Material.CHISELED_POLISHED_BLACKSTONE,
            "&bInfinity &7Quarry",
            "&7Can mine and smelt Slimefun ingots",
            "",
            LoreUtils.speed(Quarry.INFINITY_SPEED),
            LoreUtils.energyPerSecond(Quarry.INFINITY_ENERGY),
            ""
    );
    public static final SlimefunItemStack ADVANCED_ENCHANTER = new SlimefunItemStack(
            "ADVANCED_ENCHANTER",
            Material.ENCHANTING_TABLE,
            "&cAdvanced &7Enchanter",
            "",
            LoreUtils.speed(ItemSetup.ADVANCED_EN_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.ADVANCED_EN_ENERGY),
            ""
    );
    public static final SlimefunItemStack ADVANCED_DISENCHANTER = new SlimefunItemStack(
            "ADVANCED_DISENCHANTER",
            Material.ENCHANTING_TABLE,
            "&cAdvanced &7Disenchanter",
            "",
            LoreUtils.speed(ItemSetup.ADVANCED_DIS_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.ADVANCED_DIS_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITY_ENCHANTER = new SlimefunItemStack(
            "INFINITY_ENCHANTER",
            Material.ENCHANTING_TABLE,
            "&bInfinity &7Enchanter",
            "",
            LoreUtils.speed(ItemSetup.INFINITY_EN_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.INFINITY_EN_ENERGY),
            ""

    );
    public static final SlimefunItemStack INFINITY_DISENCHANTER = new SlimefunItemStack(
            "INFINITY_DISENCHANTER",
            Material.ENCHANTING_TABLE,
            "&bInfinity &7Disenchanter",
            "",
            LoreUtils.speed(ItemSetup.INFINITY_DIS_SPEED),
            LoreUtils.energyPerSecond(ItemSetup.INFINITY_DIS_ENERGY),
            ""
    );
    public static final SlimefunItemStack INFINITY_WORKBENCH = new SlimefunItemStack(
            "INFINITY_FORGE",
            Material.RESPAWN_ANCHOR,
            "&bInfinity &6Workbench",
            "&7Used to craft infinity items",
            "",
            LoreUtils.energyPer(InfinityWorkbench.ENERGY) + "per item",
            ""
    );

    public static final SlimefunItemStack ADVANCED_ANVIL = new SlimefunItemStack(
            "ADVANCED_ANVIL",
            Material.SMITHING_TABLE,
            "&cAdvanced &7Anvil",
            "",
            LoreUtils.energyPer(AdvancedAnvil.ENERGY) + "per use",
            "",
            "&cNot yet functional"
    );

    public static final SlimefunItemStack INFINITY_CAPACITOR = new SlimefunItemStack(
            "INFINITY_CAPACITOR",
            HeadTexture.CAPACITOR_25,
            "&bInfinite &7Capacitor",
            "&c&oDo not use more than ",
            "&c&o1 per energy network",
            "",
            "&8\u21E8 &e\u26A1 &bInfinite &7J Capacity",
            ""

    );
    public static final SlimefunItemStack HYDRO_GENERATOR = new SlimefunItemStack(
            "HYDRO_GENERATOR",
            Material.PRISMARINE_WALL,
            "&9Hydro Generator",
            "&3Generates energy from the movement of water",
            "",
            LoreBuilder.powerBuffer(Generators.WATER_STORAGE),
            LoreUtils.energyPerSecond(Generators.WATER_RATE),
            ""
    );
    public static final SlimefunItemStack REINFORCED_HYDRO_GENERATOR = new SlimefunItemStack(
            "REINFORCED_HYDRO_GENERATOR",
            Material.END_STONE_BRICK_WALL,
            "&fReinforced &9Hydro Gen",
            "&3Generates large amounts of energy",
            "&7from the movement of water",
            "",
            LoreBuilder.powerBuffer(Generators.WATER_STORAGE2),
            LoreUtils.energyPerSecond(Generators.WATER_RATE2),
            ""
    );
    public static final SlimefunItemStack GEOTHERMAL_GENERATOR = new SlimefunItemStack(
            "GEOTHERMAL_GENERATOR",
            Material.MAGMA_BLOCK,
            "&cGeothermal Generator",
            "&7Generates energy from the heat of the world",
            "",
            LoreBuilder.powerBuffer(Generators.GEO_STORAGE),
            LoreUtils.energyPerSecond(Generators.GEO_RATE),
            ""
    );
    public static final SlimefunItemStack REINFORCED_GEOTHERMAL_GENERATOR = new SlimefunItemStack(
            "REINFORCED_GEOTHERMAL_GENERATOR",
            Material.SHROOMLIGHT,
            "&fReinforced &cGeothermal Gen",
            "&7Generates large amounts of energy",
            "&7from the heat of the world",
            "",
            LoreBuilder.powerBuffer(Generators.GEO_STORAGE2),
            LoreUtils.energyPerSecond(Generators.GEO_RATE2),
            ""
    );
    public static final SlimefunItemStack CELESTIAL_PANEL = new SlimefunItemStack(
            "CELESTIAL_PANEL",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&eCelestial Panel",
            "&7Generates energy from the sun",
            "",
            LoreBuilder.powerBuffer(Generators.CELE_STORAGE),
            LoreUtils.energyPerSecond(Generators.CELE_RATE),
            ""
    );
    public static final SlimefunItemStack VOID_PANEL = new SlimefunItemStack(
            "VOID_PANEL",
            Material.LIGHT_GRAY_GLAZED_TERRACOTTA,
            "&8Void Panel",
            "&7Generates energy from darkness",
            "",
            LoreBuilder.powerBuffer(Generators.VOID_STORAGE),
            LoreUtils.energyPerSecond(Generators.VOID_RATE),
            ""
    );
    public static final SlimefunItemStack INFINITE_PANEL = new SlimefunItemStack(
            "INFINITE_PANEL",
            Material.LIGHT_BLUE_GLAZED_TERRACOTTA,
            "&bInfinity Panel",
            "&7Generates energy from the cosmos",
            "",
            LoreBuilder.powerBuffer(Generators.INFINITY_STORAGE),
            LoreUtils.energyPerSecond(Generators.INFINITY_RATE),
            ""
    );

    //strainers

    public static final SlimefunItemStack STRAINER_BASE = new SlimefunItemStack(
            "STRAINER_BASE",
            Material.SANDSTONE_WALL,
            "&7Strainer Base",
            ""
    );
    public static final SlimefunItemStack BASIC_STRAINER = new SlimefunItemStack(
            "BASIC_STRAINER",
            Material.FISHING_ROD,
            "&9Basic &7Strainer",
            "&7Collects materials from flowing water",
            "",
            LoreBuilder.speed(StrainerBase.BASIC_SPEED),
            ""
    );
    public static final SlimefunItemStack ADVANCED_STRAINER = new SlimefunItemStack(
            "ADVANCED_STRAINER",
            Material.FISHING_ROD,
            "&cAdvanced &7Strainer",
            "&7Collects materials from flowing water",
            "",
            LoreBuilder.speed(StrainerBase.ADVANCED_SPEED),
            ""
    );
    public static final SlimefunItemStack REINFORCED_STRAINER = new SlimefunItemStack(
            "REINFORCED_STRAINER",
            Material.FISHING_ROD,
            "&fReinforced &7Strainer",
            "&7Collects materials from flowing water",
            "",
            LoreBuilder.speed(StrainerBase.REINFORCED_SPEED),
            ""
    );

    //tree grower

    public static final SlimefunItemStack BASIC_TREE_GROWER = new SlimefunItemStack(
            "BASIC_TREE_GROWER",
            Material.STRIPPED_OAK_WOOD,
            "&9Basic &2Tree Grower",
            "&7Automatically grows, harvests, and replants trees",
            "",
            LoreUtils.speed(TreeGrower.SPEED1),
            LoreUtils.energyPerSecond(TreeGrower.ENERGY1),
            ""
    );
    public static final SlimefunItemStack ADVANCED_TREE_GROWER = new SlimefunItemStack(
            "ADVANCED_TREE_GROWER",
            Material.STRIPPED_ACACIA_WOOD,
            "&cAdvanced &2Tree Grower",
            "&7Automatically grows, harvests, and replants trees",
            "",
            LoreUtils.speed(TreeGrower.SPEED2),
            LoreUtils.energyPerSecond(TreeGrower.ENERGY2),
            ""
    );
    public static final SlimefunItemStack INFINITY_TREE_GROWER = new SlimefunItemStack(
            "INFINITY_TREE_GROWER",
            Material.STRIPPED_WARPED_HYPHAE,
            "&bInfinity &2Tree Grower",
            "&7Automatically grows, harvests, and replants trees",
            "",
            LoreUtils.speed(TreeGrower.SPEED3),
            LoreUtils.energyPerSecond(TreeGrower.ENERGY3),
            ""
    );

    //virtual farm

    public static final SlimefunItemStack BASIC_VIRTUAL_FARM = new SlimefunItemStack(
            "BASIC_VIRTUAL_FARM",
            Material.GRASS_BLOCK,
            "&9Basic &aVirtual Farm",
            "&7Automatically grows, harvests, and replants crops",
            "",
            LoreUtils.speed(VirtualFarm.SPEED1),
            LoreUtils.energyPerSecond(VirtualFarm.ENERGY1),
            ""
    );
    public static final SlimefunItemStack ADVANCED_VIRTUAL_FARM = new SlimefunItemStack(
            "ADVANCED_VIRTUAL_FARM",
            Material.CRIMSON_NYLIUM,
            "&cAdvanced &aVirtual Farm",
            "&7Automatically grows, harvests, and replants crops",
            "",
            LoreUtils.speed(VirtualFarm.SPEED2),
            LoreUtils.energyPerSecond(VirtualFarm.ENERGY2),
            ""
    );
    public static final SlimefunItemStack INFINITY_VIRTUAL_FARM = new SlimefunItemStack(
            "INFINITY_VIRTUAL_FARM",
            Material.WARPED_NYLIUM,
            "&bInfinity &aVirtual Farm",
            "&7Automatically grows, harvests, and replants crops",
            "",
            LoreUtils.speed(VirtualFarm.SPEED3),
            LoreUtils.energyPerSecond(VirtualFarm.ENERGY3),
            ""
    );

    //custom gear

    public static final SlimefunItemStack GEAR_FORGE = new SlimefunItemStack(
            "GEAR_FORGE",
            Material.LODESTONE,
            "&7Gear Forge",
            "&7Forges customizable gear",
            "",
            "&cNot yet functional"
    );

    public static final SlimefunItemStack GEAR_TRANSFORMER = new SlimefunItemStack(
            "GEAR_TRANSFORMER",
            Material.EMERALD_BLOCK,
            "&7Gear Transformer",
            "&7Changes the material of tools and gear",
            "",
            LoreUtils.energyPer(GearTransformer.ENERGY) + "Per Use",
            ""
    );

    //Deep storage units

    public static final SlimefunItemStack BASIC_STORAGE = new SlimefunItemStack(
            "BASIC_STORAGE",
            Material.OAK_WOOD,
            "&9Basic &7Storage Unit",
            LoreUtils.stores(StorageUnit.BASIC),
            "&aWorks with cargo",
            ""
    );
    public static final SlimefunItemStack ADVANCED_STORAGE = new SlimefunItemStack(
            "ADVANCED_STORAGE",
            Material.DARK_OAK_WOOD,
            "&cAdvanced &7Storage Unit",
            LoreUtils.stores(StorageUnit.ADVANCED),
            "&aWorks with cargo",
            ""
    );
    public static final SlimefunItemStack REINFORCED_STORAGE = new SlimefunItemStack(
            "REINFORCED_STORAGE",
            Material.ACACIA_WOOD,
            "&fReinforced &7Storage Unit",
            LoreUtils.stores(StorageUnit.REINFORCED),
            "&aWorks with cargo",
            ""
    );
    public static final SlimefunItemStack VOID_STORAGE = new SlimefunItemStack(
            "VOID_STORAGE",
            Material.CRIMSON_HYPHAE,
            "&8Void &7Storage Unit",
            LoreUtils.stores(StorageUnit.VOID),
            "&aWorks with cargo",
            ""
    );
    public static final SlimefunItemStack INFINITY_STORAGE = new SlimefunItemStack(
            "INFINITY_STORAGE",
            Material.WARPED_HYPHAE,
            "&bInfinity &7Storage Unit",
            "&6Stores: &bInfinite &7items",
            "&aWorks with cargo",
            ""
    );

    //drives

    public static final SlimefunItemStack STORAGE_NETWORK_CORE = new SlimefunItemStack(
            "STORAGE_NETWORK_CORE",
            Material.CHISELED_STONE_BRICKS,
            "&7Storage Network Core",
            "&7Gives access to many storage units at once",
            "",
            "&cNot yet functional"
    );

    public static final SlimefunItemStack BASIC_STORAGE_DRIVE = new SlimefunItemStack(
            "BASIC_STORAGE_DRIVE",
            Material.LEATHER_CHESTPLATE,
            "&9Basic &7Storage Drive",
            "&6Put in a storage output to store items",
            "&3Put in a storage input to withdraw items",
            "",
            LoreUtils.storedItem(""),
            LoreUtils.stored(0, StorageUnit.BASIC),
            "",
            "&cNot yet functional"
    );
    public static final SlimefunItemStack ADVANCED_STORAGE_DRIVE = new SlimefunItemStack(
            "ADVANCED_STORAGE_DRIVE",
            Material.LEATHER_CHESTPLATE,
            Color.fromRGB(82, 57, 42), //52392A
            "&cAdvanced &7Storage Drive",
            "&6Put in a storage output to store items",
            "&3Put in a storage input to withdraw items",
            "",
            LoreUtils.storedItem(""),
            LoreUtils.stored(0, StorageUnit.ADVANCED),
            "",
            "&cNot yet functional"
    );
    public static final SlimefunItemStack REINFORCED_STORAGE_DRIVE = new SlimefunItemStack(
            "REINFORCED_STORAGE_DRIVE",
            Material.LEATHER_CHESTPLATE,
            Color.fromRGB(115, 119, 117), //737775
            "&fReinforced &7Storage Drive",
            "&6Put in a storage output to store items",
            "&3Put in a storage input to withdraw items",
            "",
            LoreUtils.storedItem(""),
            LoreUtils.stored(0, StorageUnit.REINFORCED),
            "",
            "&cNot yet functional"
    );
    public static final SlimefunItemStack VOID_STORAGE_DRIVE = new SlimefunItemStack(
            "VOID_STORAGE_DRIVE",
            Material.LEATHER_CHESTPLATE,
            Color.fromRGB(176, 46, 38), //B02E26
            "&8Void &7Storage Drive",
            "&6Put in a storage output to store items",
            "&3Put in a storage input to withdraw items",
            "",
            LoreUtils.storedItem(""),
            LoreUtils.stored(0, StorageUnit.VOID),
            "",
            "&cNot yet functional"
    );
    public static final SlimefunItemStack INFINITY_STORAGE_DRIVE = new SlimefunItemStack(
            "INFINITY_STORAGE_DRIVE",
            Material.LEATHER_CHESTPLATE,
            Color.fromRGB(88, 213, 195), //58D5C3
            "&bInfinity &7Storage Drive",
            "&6Put in a storage output to store items",
            "&3Put in a storage input to withdraw items",
            "",
            LoreUtils.storedItem(""),
            LoreUtils.stored(0, StorageUnit.INFINITY),
            "",
            "&cNot yet functional"
    );

    //Compressed Cobblestones

    public static final SlimefunItemStack COMPRESSED_COBBLESTONE_1 = new SlimefunItemStack(
            "COMPRESSED_COBBLESTONE_1",
            Material.ANDESITE,
            "&71x Compressed Cobblestone",
            "&89 cobblestone combined",
            ""
    );
    public static final SlimefunItemStack COMPRESSED_COBBLESTONE_2 = new SlimefunItemStack(
            "COMPRESSED_COBBLESTONE_2",
            Material.ANDESITE,
            "&72x Compressed Cobblestone",
            "&881 cobblestone combined",
            ""
    );
    public static final SlimefunItemStack COMPRESSED_COBBLESTONE_3 = new SlimefunItemStack(
            "COMPRESSED_COBBLESTONE_3",
            Material.STONE,
            "&73x Compressed Cobblestone",
            "&8243 cobblestone combined",
            ""
    );
    public static final SlimefunItemStack COMPRESSED_COBBLESTONE_4 = new SlimefunItemStack(
            "COMPRESSED_COBBLESTONE_4",
            Material.STONE,
            "&74x Compressed Cobblestone",
            "&86,561 cobblestone combined",
            ""
    );
    public static final SlimefunItemStack COMPRESSED_COBBLESTONE_5 = new SlimefunItemStack(
            "COMPRESSED_COBBLESTONE_5",
            Material.POLISHED_ANDESITE,
            "&75x Compressed Cobblestone",
            "&859,049 cobblestone combined",
            ""
    );

    //singularities

    public static final SlimefunItemStack COPPER_SINGULARITY = new SlimefunItemStack(
            "COPPER_SINGULARITY",
            Material.BRICKS,
            "&6Copper Singularity",
            ""
    );

    public static final SlimefunItemStack ZINC_SINGULARITY = new SlimefunItemStack(
            "ZINC_SINGULARITY",
            Material.IRON_BLOCK,
            "&7Zinc Singularity",
            ""
    );

    public static final SlimefunItemStack TIN_SINGULARITY = new SlimefunItemStack(
            "TIN_SINGULARITY",
            Material.IRON_BLOCK,
            "&7Tin Singularity",
            ""
    );

    public static final SlimefunItemStack ALUMINUM_SINGULARITY = new SlimefunItemStack(
            "ALUMINUM_SINGULARITY",
            Material.IRON_BLOCK,
            "&7Aluminum Singularity",
            ""
    );

    public static final SlimefunItemStack SILVER_SINGULARITY = new SlimefunItemStack(
            "SILVER_SINGULARITY",
            Material.IRON_BLOCK,
            "&7Silver Singularity",
            ""
    );

    public static final SlimefunItemStack MAGNESIUM_SINGULARITY = new SlimefunItemStack(
            "MAGNESIUM_SINGULARITY",
            Material.NETHER_BRICKS,
            "&5Magnesium Singularity",
            ""
    );

    public static final SlimefunItemStack LEAD_SINGULARITY = new SlimefunItemStack(
            "LEAD_SINGULARITY",
            Material.IRON_BLOCK,
            "&8Lead Singularity",
            ""
    );


    public static final SlimefunItemStack GOLD_SINGULARITY = new SlimefunItemStack(
            "GOLD_SINGULARITY",
            Material.GOLD_BLOCK,
            "&6Gold Singularity",
            ""
    );

    public static final SlimefunItemStack IRON_SINGULARITY = new SlimefunItemStack(
            "IRON_SINGULARITY",
            Material.IRON_BLOCK,
            "&7Iron Singularity",
            ""
    );

    public static final SlimefunItemStack DIAMOND_SINGULARITY = new SlimefunItemStack(
            "DIAMOND_SINGULARITY",
            Material.DIAMOND_BLOCK,
            "&bDiamond Singularity",
            ""
    );

    public static final SlimefunItemStack EMERALD_SINGULARITY = new SlimefunItemStack(
            "EMERALD_SINGULARITY",
            Material.EMERALD_BLOCK,
            "&aEmerald Singularity",
            ""
    );

    public static final SlimefunItemStack NETHERITE_SINGULARITY = new SlimefunItemStack(
            "NETHERITE_SINGULARITY",
            Material.NETHERITE_BLOCK,
            "&4Netherite Singularity",
            ""
    );

    public static final SlimefunItemStack COAL_SINGULARITY = new SlimefunItemStack(
            "COAL_SINGULARITY",
            Material.COAL_BLOCK,
            "&8Coal Singularity",
            ""
    );

    public static final SlimefunItemStack REDSTONE_SINGULARITY = new SlimefunItemStack(
            "REDSTONE_SINGULARITY",
            Material.REDSTONE_BLOCK,
            "&cRedstone Singularity",
            ""
    );

    public static final SlimefunItemStack LAPIS_SINGULARITY = new SlimefunItemStack(
            "LAPIS_SINGULARITY",
            Material.LAPIS_BLOCK,
            "&9Lapis Singularity",
            ""
    );

    public static final SlimefunItemStack QUARTZ_SINGULARITY = new SlimefunItemStack(
            "QUARTZ_SINGULARITY",
            Material.QUARTZ_BLOCK,
            "&fQuartz Singularity",
            ""
    );

    public static final SlimefunItemStack INFINITY_SINGULARITY = new SlimefunItemStack(
            "INFINITY_SINGULARITY",
            Material.NETHER_STAR,
            "&bInfinity Singularity",
            ""
    );

    //Infinity Singularities

    public static final SlimefunItemStack FORTUNE_SINGULARITY = new SlimefunItemStack(
            "FORTUNE_SINGULARITY",
            Material.NETHER_STAR,
            "&6Fortune Singularity"
    );
    public static final SlimefunItemStack EARTH_SINGULARITY = new SlimefunItemStack(
            "EARTH_SINGULARITY",
            Material.NETHER_STAR,
            "&aEarth Singularity"
    );
    public static final SlimefunItemStack METAL_SINGULARITY = new SlimefunItemStack(
            "METAL_SINGULARITY",
            Material.NETHER_STAR,
            "&8Metal Singularity"
    );
    public static final SlimefunItemStack MAGIC_SINGULARITY = new SlimefunItemStack(
            "MAGIC_SINGULARITY",
            Material.NETHER_STAR,
            "&dMagic Singularity"
    );

    //Info thingies

    /**
     * Thanks to NCBPFluffyBear for the idea
     */

    public static final SlimefunItemStack ADDON_INFO = new SlimefunItemStack(
            "ADDON_INFO",
            Material.NETHER_STAR,
            "&bAddon Info",
            "&fVersion: &7" + InfinityExpansion.getInstance().getPluginVersion(),
            "",
            "&fDiscord: &b@&7Riley&8#5911",
            "&7discord.gg/slimefun",
            "",
            "&fGithub: &b@&8&7Mooy1",
            "&7" + InfinityExpansion.getInstance().getBugTrackerURL(),
            ""
    );

    public static final SlimefunItemStack POTATO_FISH = new SlimefunItemStack(
            "POTATO_FISH",
            Material.POTATO,
            "&7:&6Potatofish&7:",
            "&cDon't cheat in potatofish :(",
            ""
    );

    //Ingots

    public static final SlimefunItemStack MAGSTEEL = new SlimefunItemStack(
            "MAGSTEEL",
            Material.BRICK,
            "&4MagSteel",
            ""
    );
    public static final SlimefunItemStack MAGNONIUM = new SlimefunItemStack(
            "MAGNONIUM",
            Material.NETHER_BRICK,
            "&5Magnonium",
            ""
    );
    public static final SlimefunItemStack TITANIUM = new SlimefunItemStack(
            "TITANIUM",
            Material.IRON_INGOT,
            "&7Titanium",
            ""
    );
    public static final SlimefunItemStack MYTHRIL = new SlimefunItemStack(
            "MYTHRIL",
            Material.IRON_INGOT,
            "&bMythril",
            ""
    );
    public static final SlimefunItemStack ADAMANTITE = new SlimefunItemStack(
            "ADAMANTITE",
            Material.BRICK,
            "&dAdamantite",
            ""
    );
    public static final SlimefunItemStack INFINITE_INGOT = new SlimefunItemStack(
            "INFINITE_INGOT",
            Material.IRON_INGOT,
            "&dI&cn&6f&ei&an&bi&3t&9y &fIngot",
            "&7&oThe fury of the cosmos in the palm of your hand",
            ""
    );

    //Void ingots

    public static final SlimefunItemStack VOID_BIT = new SlimefunItemStack(
            "VOID_BIT",
            Material.IRON_NUGGET,
            "&8Void &7Bit",
            "&8&oIt feels... empty",
            ""
    );
    public static final SlimefunItemStack VOID_DUST = new SlimefunItemStack(
            "VOID_DUST",
            Material.GUNPOWDER,
            "&8Void &7Dust",
            "&8&oIts starting to take form...",
            ""
    );
    public static final SlimefunItemStack VOID_INGOT = new SlimefunItemStack(
            "VOID_INGOT",
            Material.NETHERITE_INGOT,
            "&8Void &7Ingot",
            "&8&oThe emptiness of the cosmos in the palm of your hand",
            ""
    );

    //Materials

    public static final SlimefunItemStack END_ESSENCE = new SlimefunItemStack(
            "END_ESSENCE",
            Material.BLAZE_POWDER,
            "&5Ender Essence",
            "&8&oFrom the depths of the end...",
            ""
    );

    public static final SlimefunItemStack MAGSTEEL_PLATE = new SlimefunItemStack(
            "MAGSTEEL_PLATE",
            Material.NETHERITE_SCRAP,
            "&4MagSteel &7Plate",
            "&7Machine Component",
            ""
    );
    public static final SlimefunItemStack MACHINE_PLATE = new SlimefunItemStack(
            "MACHINE_PLATE",
            Material.PAPER,
            "&7Machine Plate",
            "&7Machine Component",
            ""
    );
    public static final SlimefunItemStack MACHINE_CIRCUIT = new SlimefunItemStack(
            "MACHINE_CIRCUIT",
            Material.GOLD_INGOT,
            "&6Machine Circuit",
            "&7Machine Component",
            ""
    );
    public static final SlimefunItemStack INFINITE_MACHINE_CIRCUIT = new SlimefunItemStack(
            "INFINITE_MACHINE_CIRCUIT",
            Material.DIAMOND,
            "&bInfinite &6Machine Circuit",
            "&7Machine Component",
            ""
    );
    public static final SlimefunItemStack MACHINE_CORE = new SlimefunItemStack(
            "MACHINE_CORE",
            Material.IRON_BLOCK,
            "&7Machine Core",
            "&7Machine Component",
            ""
    );
    public static final SlimefunItemStack INFINITE_MACHINE_CORE = new SlimefunItemStack(
            "INFINITE_MACHINE_CORE",
            Material.DIAMOND_BLOCK,
            "&bInfinite &7Machine Core",
            "&7Machine Component",
            ""
    );

    //Gear

    public static final SlimefunItemStack ENDER_FLAME = new SlimefunItemStack(
            "ENDER_FLAME",
            Material.BUBBLE_CORAL_FAN,
            "&dEnder &cFlame",
            ""
    );

    public static final SlimefunItemStack INFINITY_CROWN = new SlimefunItemStack(
            "INFINITY_CROWN",
            Material.NETHERITE_HELMET,
            "&bInfinity Crown",
            "&6Saturation",
            "&8Night Vision",
            "&9Water Breathing",
            "&7&oBreath of the cosmos",
            ""
    );
    public static final SlimefunItemStack INFINITY_CHESTPLATE = new SlimefunItemStack(
            "INFINITY_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&bInfinity Chestplate",
            "&aHealth Boost III",
            "&8Resistance II",
            "&2Fire Resistance",
            "&cRegeneration",
            "&7&oStrength of the cosmos",
            ""
    );
    public static final SlimefunItemStack INFINITY_LEGGINGS = new SlimefunItemStack(
            "INFINITY_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&bInfinity Leggings",
            "&cStrength II",
            "&6Haste III",
            "&9Conduit Power",
            "&7&o",
            ""

    );
    public static final SlimefunItemStack INFINITY_BOOTS = new SlimefunItemStack(
            "INFINITY_BOOTS",
            Material.NETHERITE_BOOTS,
            "&bInfinity Boots",
            "&bSpeed III",
            "&3Dolphins Grace",
            "&7&oAgility of the cosmos",
            ""

    );
    public static final SlimefunItemStack INFINITY_BLADE = new SlimefunItemStack(
            "INFINITY_BLADE",
            Material.NETHERITE_SWORD,
            "&bBlade of the Cosmos",
            "&b&oEdge of infinity",
            ""
    );
    public static final SlimefunItemStack INFINITY_PICKAXE = new SlimefunItemStack(
            "INFINITY_PICKAXE",
            Material.NETHERITE_PICKAXE,
            "&9World Breaker",
            "&3&oThe end of the world",
            ""
    );
    public static final SlimefunItemStack INFINITY_AXE = new SlimefunItemStack(
            "INFINITY_AXE",
            Material.NETHERITE_AXE,
            "&4Nature's Ruin",
            "&c&oThe embodiment of fury",
            ""
    );
    public static final SlimefunItemStack INFINITY_SHOVEL = new SlimefunItemStack(
            "INFINITY_SHOVEL",
            Material.NETHERITE_SHOVEL,
            "&aMountain Eater",
            "&2&o",
            ""
    );
    public static final SlimefunItemStack INFINITY_BOW = new SlimefunItemStack(
            "INFINITY_BOW",
            Material.BOW,
            "&6Sky Piercer",
            "&e&oThe longbow of the Heavens",
            ""
    );
    public static final SlimefunItemStack INFINITY_WINGS = new SlimefunItemStack(
            "INFINITY_WINGS",
            Material.ELYTRA,
            "&dVoid Wings",
            "&8&oInto the void",
            ""
    );
    public static final SlimefunItemStack INFINITY_SHIELD = new SlimefunItemStack(
            "INFINITY_SHIELD",
            Material.SHIELD,
            "&bCosmic Aegis",
            "&7&o",
            ""
    );

    //enchant list

    private static final Enchantment prot = Enchantment.PROTECTION_ENVIRONMENTAL;
    private static final Enchantment sharp = Enchantment.DAMAGE_ALL;
    private static final Enchantment eff = Enchantment.DIG_SPEED;
    private static final Enchantment fire = Enchantment.FIRE_ASPECT;
    private static final Enchantment fort = Enchantment.LOOT_BONUS_BLOCKS;
    private static final Enchantment loot = Enchantment.LOOT_BONUS_MOBS;
    private static final Enchantment silk = Enchantment.SILK_TOUCH;
    private static final Enchantment thorns = Enchantment.THORNS;
    private static final Enchantment aqua = Enchantment.WATER_WORKER;
    private static final Enchantment power = Enchantment.ARROW_DAMAGE;
    private static final Enchantment flame = Enchantment.ARROW_FIRE;
    private static final Enchantment infinity = Enchantment.ARROW_INFINITE;

    static {

        //add enchants

        ENDER_FLAME.addUnsafeEnchantment(fire, 10);

        INFINITY_CROWN.addUnsafeEnchantment(prot, 40);
        INFINITY_CROWN.addUnsafeEnchantment(aqua, 10);

        INFINITY_CHESTPLATE.addUnsafeEnchantment(prot, 40);
        INFINITY_CHESTPLATE.addUnsafeEnchantment(thorns, 20);

        INFINITY_SHIELD.addUnsafeEnchantment(prot, 40);
        INFINITY_SHIELD.addUnsafeEnchantment(thorns, 20);

        INFINITY_LEGGINGS.addUnsafeEnchantment(prot, 40);

        INFINITY_BOOTS.addUnsafeEnchantment(prot, 40);

        INFINITY_PICKAXE.addUnsafeEnchantment(eff, 40);
        INFINITY_PICKAXE.addUnsafeEnchantment(fort, 20);

        INFINITY_SHOVEL.addUnsafeEnchantment(eff, 40);
        INFINITY_SHOVEL.addUnsafeEnchantment(fort, 20);
        INFINITY_SHOVEL.addUnsafeEnchantment(silk, 1);

        INFINITY_AXE.addUnsafeEnchantment(eff, 40);
        INFINITY_AXE.addUnsafeEnchantment(sharp, 20);
        INFINITY_AXE.addUnsafeEnchantment(fire, 20);

        INFINITY_BLADE.addUnsafeEnchantment(sharp, 20);
        INFINITY_BLADE.addUnsafeEnchantment(loot, 20);

        INFINITY_BOW.addUnsafeEnchantment(power, 20);
        INFINITY_BOW.addUnsafeEnchantment(flame, 20);
        INFINITY_BOW.addUnsafeEnchantment(infinity, 10);

        INFINITY_WINGS.addUnsafeEnchantment(prot, 20);

        //add unbreakable items

        ItemMeta hat = INFINITY_CROWN.getItemMeta();
        assert hat != null;
        hat.setUnbreakable(true);
        //hat.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_CROWN.setItemMeta(hat);

        ItemMeta shirt = INFINITY_CHESTPLATE.getItemMeta();
        assert shirt != null;
        shirt.setUnbreakable(true);
        //shirt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_CHESTPLATE.setItemMeta(shirt);

        ItemMeta pants = INFINITY_LEGGINGS.getItemMeta();
        assert pants != null;
        pants.setUnbreakable(true);
        //pants.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_LEGGINGS.setItemMeta(pants);

        ItemMeta shoes = INFINITY_BOOTS.getItemMeta();
        assert shoes != null;
        shoes.setUnbreakable(true);
        //shoes.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_BOOTS.setItemMeta(shoes);

        ItemMeta pick = INFINITY_PICKAXE.getItemMeta();
        assert pick != null;
        pick.setUnbreakable(true);
        //pick.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_PICKAXE.setItemMeta(pick);

        ItemMeta blade = INFINITY_BLADE.getItemMeta();
        assert blade != null;
        blade.setUnbreakable(true);
        //blade.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_BLADE.setItemMeta(blade);

        ItemMeta axe = INFINITY_AXE.getItemMeta();
        assert axe != null;
        axe.setUnbreakable(true);
        //axe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_AXE.setItemMeta(axe);

        ItemMeta shovel = INFINITY_SHOVEL.getItemMeta();
        assert shovel != null;
        shovel.setUnbreakable(true);
        //shovel.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_SHOVEL.setItemMeta(shovel);

        ItemMeta shield = INFINITY_SHIELD.getItemMeta();
        assert shield != null;
        shield.setUnbreakable(true);
        //shield.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_SHIELD.setItemMeta(shield);

        ItemMeta bow = INFINITY_BOW.getItemMeta();
        assert bow != null;
        bow.setUnbreakable(true);
        //bow.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_BOW.setItemMeta(bow);

        ItemMeta wings = INFINITY_WINGS.getItemMeta();
        assert wings != null;
        wings.setUnbreakable(true);
        //wings.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        INFINITY_WINGS.setItemMeta(wings);
    }

    private Items() {
    }
}