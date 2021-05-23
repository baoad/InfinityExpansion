package io.github.mooy1.infinityexpansion.commands;

import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinitylib.commands.AbstractCommand;

public final class PrintItem extends AbstractCommand {

    public PrintItem() {
        super("printitem", "Prints the internal data of an item for debugging purposes(为调试项目的内部数据）", true);
    }

    @Override
    public void onExecute(@Nonnull CommandSender commandSender, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player)) {
            return;
        }

        Player p = (Player) commandSender;

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType() == Material.AIR) {
            p.sendMessage(ChatColor.RED + "你必须拿着物品!");
            return;
        }

        p.sendMessage(item.toString());
    }

    @Override
    public void onTab(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) {

    }

}
