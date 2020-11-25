package io.github.mooy1.infinityexpansion.implementation.gear;

import io.github.mooy1.infinityexpansion.lists.Categories;
import io.github.mooy1.infinityexpansion.lists.InfinityRecipes;
import io.github.mooy1.infinityexpansion.lists.Items;
import io.github.mooy1.infinityexpansion.lists.RecipeTypes;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.Soulbound;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

import javax.annotation.Nonnull;

/**
 * tools
 *
 * @author Mooy1
 */
public class InfinityTool extends SlimefunItem implements Soulbound, NotPlaceable {
    
    @Getter
    private final Type type;
    
    public InfinityTool(@Nonnull Type type) {
        super(Categories.INFINITY_CHEAT, type.getItem(), RecipeTypes.INFINITY_WORKBENCH, InfinityRecipes.getRecipe(type.getItem()));
        this.type = type;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {

        PICKAXE(Items.INFINITY_PICKAXE),
        BOW(Items.INFINITY_BOW),
        SHOVEL(Items.INFINITY_SHOVEL),
        AXE(Items.INFINITY_AXE),
        SHIELD(Items.INFINITY_SHIELD),
        BLADE(Items.INFINITY_BLADE);

        @Nonnull
        private final SlimefunItemStack item;
    }
}