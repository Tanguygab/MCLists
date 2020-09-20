package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Banned extends SubType {

    public Banned(boolean countSelf, String output, String subtypevalue) {
        super(countSelf, output, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        ArrayList<String> players = new ArrayList<>();
            for (OfflinePlayer p : list) {
                if (p.isBanned()) {
                    players.add(p.getName());
                }
            }
            return format(players);
    }
}
