package io.github.tanguygab.mclists.lists.players;

import io.github.tanguygab.mclists.lists.Lists;
import io.github.tanguygab.mclists.lists.players.Filters.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

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
        String subtypeValue = config.getString("lists." + name + ".subtypeValue");

        assert filter != null;
        assert subtype != null;
        assert subtypeValue != null;

        filter = filter.toLowerCase();
        SubType subType = SubType.compile(subtype.toLowerCase(), countself, subtypeValue);
        if (filter.equals("all")) return new All(subType);
        if (filter.equals("online")) return new Online(subType);
        if (filter.equals("offline")) return new Offline(subType);

        return new InvalidPlayers("This list doesn't have a valid filter!");
    }
}
