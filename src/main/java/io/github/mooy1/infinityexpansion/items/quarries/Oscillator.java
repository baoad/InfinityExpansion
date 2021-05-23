package io.github.mooy1.infinityexpansion.items.quarries;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinityexpansion.categories.Categories;
import io.github.mooy1.infinityexpansion.items.Materials;
import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class Oscillator extends SlimefunItem {

    private static final Map<String, Material> OSCILLATORS = new HashMap<>();

    @Nullable
    public static Material getOscillator(@Nullable ItemStack item) {
        if (item == null) {
            return null;
        }
        return OSCILLATORS.get(StackUtils.getID(item));
    }

    public Oscillator(Material material) {
        super(Categories.MAIN_MATERIALS, new SlimefunItemStack(
                "QUARRY_OSCILLATOR_" + material.name(),
                material,
                "&b" + StackUtils.getDisplayName(new ItemStack(material)) + "提取物",
                "&7此物品需要放到矿机内",
                "&750%的几率会挖出这种材料"
        ), RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MACHINE_PLATE, SlimefunItems.BLISTERING_INGOT_3, Materials.MACHINE_PLATE,
                SlimefunItems.BLISTERING_INGOT_3, new ItemStack(material), SlimefunItems.BLISTERING_INGOT_3,
                Materials.MACHINE_PLATE, SlimefunItems.BLISTERING_INGOT_3, Materials.MACHINE_PLATE
        });
        OSCILLATORS.put(getId(), material);
    }

}
