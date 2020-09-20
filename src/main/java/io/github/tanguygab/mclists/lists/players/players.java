package io.github.tanguygab.mclists.lists.players;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.github.tanguygab.mclists.lists.players.Filters.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import io.github.tanguygab.mclists.lists.Lists;

public class players extends Lists {

    protected static SubType subtype;
    protected static String name;
    protected players() {}

    protected players(SubType subtype) {
        players.subtype = subtype;
    }

    @Override
    public String getText(Player p) {
        return "null";
    }

    public static players compile(String name) {
        players.name = name;
        ConfigurationSection config = Bukkit.getServer().getPluginManager().getPlugin("MCLists").getConfig();
        String filter = config.getString("lists." + name + ".filter");
        String subtype = config.getString("lists." + name + ".subtype");
        boolean countself = config.getBoolean("lists." + name + ".countSelf");
        String output = "list";
        String subtypeValue = config.getString("lists." + name + ".subtypeValue");

        assert filter != null;
        assert subtype != null;
        assert subtypeValue != null;
        SubType subType = SubType.compile(subtype, countself, output, subtypeValue);
        if (filter.equals("all")) return new All(subType);
        if (filter.equals("online")) return new Online(subType);
        if (filter.equals("offline")) return new Offline(subType);

        return new InvalidPlayers("This list doesn't have a valid filter!");
    }
}
