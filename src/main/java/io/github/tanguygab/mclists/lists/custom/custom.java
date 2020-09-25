package io.github.tanguygab.mclists.lists.custom;

import io.github.tanguygab.mclists.lists.Lists;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;

public class custom extends Lists {

    protected static SubType subtype;
    protected static String name;
    protected custom() {}

    protected custom(SubType subtype) {
        custom.subtype = subtype;
    }

    @Override
    public java.lang.String getText(Player p) {
        return "null";
    }

    public static custom compile(String name) {
        custom.name = name;
        ConfigurationSection config = Bukkit.getServer().getPluginManager().getPlugin("MCLists").getConfig();
        List<String> filter = config.getStringList("lists." + name + ".filter");
        String subtype = config.getString("lists." + name + ".subtype");

        assert subtype != null;
        SubType subType = SubType.compile(subtype.toLowerCase());
        if (!filter.isEmpty()) return new FilterList(subType,filter);

        return new InvalidCustom("This custom list is empty!");
    }
}
