package me.kubaw208.staticplaceholders.api;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.kubaw208.staticplaceholders.ConfigLoader;
import me.kubaw208.staticplaceholders.StaticPlaceholders;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomPlaceholderExpansion extends PlaceholderExpansion {

    private final ConfigLoader configs = StaticPlaceholders.getInstance().getConfigLoader();

    @Override
    public @NotNull String getIdentifier() {
        return "static";
    }

    @Override
    public @NotNull String getAuthor() {
        return "kubaw208";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    @SuppressWarnings("unchecked")
    public String onPlaceholderRequest(Player player, String identifier) {
        for(String key : configs.getConfig().getConfigurationSection("staticPlaceholders").getKeys(false)) {
            if(!key.equals(identifier)) continue;

            String value = configs.getConfig().getString("staticPlaceholders." + key);

            if(configs.getConfig().getBoolean("parseNestedPlaceholders")) {
                return PlaceholderAPI.setPlaceholders(player, value);
            } else {
                return value;
            }
        }
        return null;
    }

}