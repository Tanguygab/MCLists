package io.github.tanguygab.mclists.lists.plugins;

import io.github.tanguygab.mclists.lists.Lists;
import io.github.tanguygab.mclists.lists.plugins.Filters.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class plugins extends Lists {

    protected static SubType subtype;
    protected static String name;
    protected plugins() {}

    protected plugins(SubType subtype) {
        plugins.subtype = subtype;
    }

    @Override
    public String getText(Player p) {
        return "null";
    }

    public static plugins compile(String name) {
        plugins.name = name;
        ConfigurationSection config = Bukkit.getServer().getPluginManager().getPlugin("MCLists").getConfig();
        String filter = config.getString("lists." + name + ".filter");
        String subtype = config.getString("lists." + name + ".subtype");
        boolean countself = config.getBoolean("lists." + name + ".countSelf");

        assert filter != null;
        assert subtype != null;

        filter = filter.toLowerCase();
        SubType subType = SubType.compile(subtype.toLowerCase(), countself);
        if (filter.equals("all")) return new All(subType);
        if (filter.equals("enabled")) return new Enabled(subType);
        if (filter.equals("disabled")) return new Disabled(subType);

        return new InvalidPlugins("This list doesn't have a valid filter!");
    }
}
