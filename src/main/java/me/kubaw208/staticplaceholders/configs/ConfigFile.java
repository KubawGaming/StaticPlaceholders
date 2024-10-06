package me.kubaw208.staticplaceholders.configs;

import de.exlll.configlib.Comment;
import de.exlll.configlib.Configuration;

import java.util.HashMap;

@Configuration
public class ConfigFile {

    @Comment({"Static placeholders. You can enter what placeholder you want on the left, and on the right the value it should convert to.",
            "You can also add other placeholders on the right side (where you convert to the new value) if 'applyOtherPlaceholders' is true."})
    public HashMap<String, String> staticPlaceholders = new HashMap<>() {{
        put("website", "https://www.google.com");
        put("player_name", "%player_name% is your name!");
    }};

    @Comment({"", "If 'true', other placeholders (if any) will be applied to the list of static placeholders."})
    public boolean applyOtherPlaceholders = true;

    @Comment({"", "Message sent to player who does not have permission to reload staticplaceholders configs."})
    public String noPermissionMessage = "&cYou don't have permissions to do that!";

    @Comment({"", "Message sent to a player who has successfully reloaded staticplaceholders configs."})
    public String successfullyReloadedMessage = "&aConfigs have been successfully reloaded!";

}