package io.github.tanguygab.mclists.lists;

import io.github.tanguygab.mclists.lists.players.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.configuration.ConfigurationSection;

public abstract class Lists {

    public static String output;

    public abstract String getText(Player p);

    public static Lists compile(String text, String output) {
        Lists.output = output;
        ConfigurationSection config = Bukkit.getServer().getPluginManager().getPlugin("MCLists").getConfig();
        String type = config.getString("lists."+text+".type");
        ConfigurationSection keys = config.getConfigurationSection("lists."+text);
        if (!config.isConfigurationSection("lists."+text)) return new Invalid("The specified section doesn't exist");
        players compile = players.compile(text);
        if (type.equals("players")) return compile;
        /*else if (type.equals("entities")) return entities().compile(type);
        else if (type.equals("worlds")) return worlds().compile(type);
        else if (type.equals("plugins")) return plugins().compile(type);
        else if (type.equals("mods")) return mods().compile(type);
        else if (type.equals("servers")) return servers().compile(type);
        else if (type.equals("bplayers")) return bplayers().compile(type);*/
        return new Invalid("This list doesn't have a valid type");
    }
}
