package io.github.mooy1.infinityexpansion.commands;

import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.mooy1.infinityexpansion.items.storage.StorageUnit;
import io.github.mooy1.infinitylib.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

public final class SetData extends SubCommand {

    public SetData() {
        super("setdata", "正在设置并查看Slimefun方块数据", true);
    }

    @Override
    protected void execute(@Nonnull CommandSender commandSender, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("只有玩家才能使用这个!");
            return;
        }

        if (strings.length != 3) {
            commandSender.sendMessage(ChatColor.RED + "你必须设置值!");
            return;
        }

        Player p = (Player) commandSender;

        Block target = p.getTargetBlockExact(8, FluidCollisionMode.NEVER);

        if (target == null || target.getType() == Material.AIR) {
            p.sendMessage(ChatColor.RED + "You need to target a block to use this command!");
            return;
        }

        String id = BlockStorage.getLocationInfo(target.getLocation(), "id");

        if (id == null) {
            p.sendMessage(ChatColor.RED + "你不能更改这个SF方块ID 他可能会导致出现问题!");
            return;
        }

        if (strings[1].equals("id")) {
            p.sendMessage(ChatColor.RED + "你需要瞄准物品来使用此命令!");
            return;
        }

        if (strings[2].equals("\\remove")) {
            p.sendMessage(ChatColor.GREEN + "成功删除 '" + strings[1] + "' in " + id);
            BlockStorage.addBlockInfo(target, strings[1], null);
        }
        else {
            p.sendMessage(ChatColor.GREEN + "Successfully set key '" + strings[1] + "' to value '" + strings[2] + "' in " + id);
            BlockStorage.addBlockInfo(target, strings[1], strings[2]);
        }

        SlimefunItem unit = SlimefunItem.getByID(id);
        if (unit instanceof StorageUnit) {
            ((StorageUnit) unit).reloadCache(target);
        }
    }

    @Override
    public void onTab(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) {
        if (!(commandSender instanceof Player)) {
            return;
        }

        Player p = (Player) commandSender;

        Block target = p.getTargetBlockExact(8, FluidCollisionMode.NEVER);

        if (target == null || target.getType() == Material.AIR) {
            return;
        }

        if (strings.length == 2) {
            if (BlockStorage.hasBlockInfo(target)) {
                list.addAll(BlockStorage.getLocationInfo(target.getLocation()).getKeys());
                list.remove("id");
            }
        } else if (strings.length == 3 && !strings[1].equals("id")) {
            String current = BlockStorage.getLocationInfo(target.getLocation(), strings[1]);
            if (current != null) {
                list.add(current);
                list.add("\\remove");
            }
        }
    }

}
