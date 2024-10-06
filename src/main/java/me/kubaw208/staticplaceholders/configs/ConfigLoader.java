package me.kubaw208.staticplaceholders.configs;

import de.exlll.configlib.ConfigLib;
import de.exlll.configlib.YamlConfigurationProperties;
import de.exlll.configlib.YamlConfigurationStore;
import lombok.Getter;
import me.kubaw208.staticplaceholders.StaticPlaceholders;

import java.io.File;

public class ConfigLoader {

    private final StaticPlaceholders plugin = StaticPlaceholders.getInstance();

    YamlConfigurationStore<ConfigFile> configFileStore;
    @Getter private ConfigFile configFile;

    public void loadConfigs() {
        YamlConfigurationProperties properties = ConfigLib.BUKKIT_DEFAULT_PROPERTIES
                .toBuilder()
                .build();

        configFileStore = new YamlConfigurationStore<>(ConfigFile.class, properties);
        this.configFile = configFileStore.update(new File(plugin.getDataFolder(), "config.yml").toPath());
    }

}