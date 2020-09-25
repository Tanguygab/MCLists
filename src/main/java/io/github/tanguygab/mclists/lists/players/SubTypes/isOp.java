package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class isOp extends SubType {

    public isOp(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        ArrayList<String> players = new ArrayList<>();
            for (OfflinePlayer p : list) {
                if (countSelf || !p.getName().equals(player.getName())) {
                    if (p.isOp()) {
                        players.add(p.getName());
                    }
                }
            }
            return format(players);
    }
}
