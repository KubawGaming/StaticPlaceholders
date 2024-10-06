package me.kubaw208.staticplaceholders.commands;

import me.kubaw208.staticplaceholders.StaticPlaceholders;
import me.kubaw208.staticplaceholders.configs.ConfigLoader;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    private final ConfigLoader configs = StaticPlaceholders.getInstance().getConfigLoader();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("staticplaceholders.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configs.getConfigFile().noPermissionMessage));
            return false;
        }

        configs.loadConfigs();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configs.getConfigFile().successfullyReloadedMessage));
        return false;
    }

}
