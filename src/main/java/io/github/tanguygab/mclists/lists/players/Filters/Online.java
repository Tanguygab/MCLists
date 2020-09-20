package io.github.tanguygab.mclists.lists.players.Filters;

import io.github.tanguygab.mclists.lists.players.SubType;
import io.github.tanguygab.mclists.lists.players.players;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Online extends players {

    private Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();

    public Online(SubType subtype) {
        super(subtype);
    }

    @Override
    public String getText(Player p) {
        return subtype.getText(p, players);
    }
}
