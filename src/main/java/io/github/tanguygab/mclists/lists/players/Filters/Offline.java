package io.github.tanguygab.mclists.lists.players.Filters;

import io.github.tanguygab.mclists.lists.players.SubType;
import io.github.tanguygab.mclists.lists.players.players;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Offline extends players {

    private final List<OfflinePlayer> allPlayers = Arrays.asList(Bukkit.getOfflinePlayers());
    private final Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();

    public Offline(SubType subtype) {
        super(subtype);
    }

    public String getText(Player p) {
        Collection<OfflinePlayer> players = new ArrayList<>(allPlayers);
        players.removeAll(onlinePlayers);
        return subtype.getText(p, players);
    }
}
