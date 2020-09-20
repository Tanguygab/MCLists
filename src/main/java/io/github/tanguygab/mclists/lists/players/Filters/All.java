package io.github.tanguygab.mclists.lists.players.Filters;

import io.github.tanguygab.mclists.lists.players.SubType;
import io.github.tanguygab.mclists.lists.players.players;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class All extends players {

    private final List<OfflinePlayer> players = Arrays.asList(Bukkit.getOfflinePlayers());

    public All(SubType subtype) {
        super(subtype);
    }

    public String getText(Player p) {
        return subtype.getText(p, players);
    }
}
