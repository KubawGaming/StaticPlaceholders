package me.kubaw208.staticplaceholders;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigLoader {

    private final StaticPlaceholders plugin = StaticPlaceholders.getInstance();
    @Getter YamlConfiguration config;

    public void loadConfig() {
        plugin.saveResource("config.yml", false);

        try {
            config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + File.separator + "/config.yml"));
        } catch(Exception ignored) {}
    }

}