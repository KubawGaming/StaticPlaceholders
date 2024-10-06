package me.kubaw208.staticplaceholders;

import lombok.Getter;
import me.kubaw208.staticplaceholders.api.CustomPlaceholderExpansion;
import me.kubaw208.staticplaceholders.commands.Reload;
import me.kubaw208.staticplaceholders.configs.ConfigLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaticPlaceholders extends JavaPlugin {

    @Getter private static StaticPlaceholders instance;
    @Getter private ConfigLoader configLoader;

    @Override
    public void onEnable() {
        instance = this;
        configLoader = new ConfigLoader();

        configLoader.loadConfigs();

        getCommand("staticplaceholdersreload").setExecutor(new Reload());

        new CustomPlaceholderExpansion().register();
    }

}
