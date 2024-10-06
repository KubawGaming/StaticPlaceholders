package me.kubaw208.staticplaceholders.commands;

import me.kubaw208.staticplaceholders.StaticPlaceholders;
import me.kubaw208.staticplaceholders.ConfigLoader;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private final ConfigLoader configs = StaticPlaceholders.getInstance().getConfigLoader();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("staticplaceholders.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configs.getConfig().getString("noPermissionMessage")));
            return false;
        }

        configs.loadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configs.getConfig().getString("successfullyReloadedMessage")));
        return false;
    }

}
