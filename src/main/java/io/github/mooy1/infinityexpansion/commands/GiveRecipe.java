package io.github.mooy1.infinityexpansion.commands;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

public final class GiveRecipe extends SubCommand {

    public GiveRecipe() {
        super("giverecipe", "给出了一个Slimefun的配方", true);
    }

    @Override
    protected void execute(@Nonnull CommandSender sender, @Nonnull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("只有玩家才能使用这个!");
            return;
        }

        if (args.length != 2) {
            sender.sendMessage("用法: /ie giverecipe <ID>");
            return;
        }

        SlimefunItem sfItem = SlimefunItem.getById(args[1].toUpperCase());

        if (sfItem == null || sfItem instanceof MultiBlockMachine || sfItem.getRecipeType() == RecipeType.GEO_MINER) {
            sender.sendMessage(ChatColor.RED + "已经给予!");
            return;
        }

        sender.sendMessage(ChatColor.GREEN + "给予配方" + sfItem.getItemName());

        Player p = (Player) sender;

        List<ItemStack> recipe = new ArrayList<>();

        for (ItemStack e : sfItem.getRecipe()) {
            if (e != null) {
                recipe.add(e);
            }
        }

        p.getInventory().addItem(recipe.toArray(new ItemStack[0]));
    }

    @Override
    protected void complete(@Nonnull CommandSender sender, @Nonnull String[] args, @Nonnull List<String> tabs) {
        if (args.length == 2) {
            for (SlimefunItem item : Slimefun.getRegistry().getEnabledSlimefunItems()) {
                tabs.add(item.getId());
                if (tabs.size() > 64) {
                    break;
                }
            }
        }
    }

}