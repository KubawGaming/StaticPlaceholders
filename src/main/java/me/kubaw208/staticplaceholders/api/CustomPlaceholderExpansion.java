package me.kubaw208.staticplaceholders.api;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.kubaw208.staticplaceholders.StaticPlaceholders;
import me.kubaw208.staticplaceholders.configs.ConfigLoader;
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
    public String onPlaceholderRequest(Player player, String identifier) {
        for(var entry : configs.getConfigFile().staticPlaceholders.entrySet()) {
            if(entry.getKey().equals(identifier))
                if(configs.getConfigFile().applyOtherPlaceholders) {
                    return PlaceholderAPI.setPlaceholders(player, entry.getValue());
                } else {
                    return entry.getValue();
                }
        }
        return null;
    }

}