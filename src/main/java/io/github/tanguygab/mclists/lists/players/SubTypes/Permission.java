package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Permission extends SubType {

    public Permission(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        ArrayList<String> players = new ArrayList<>();
            for (OfflinePlayer off : list) {
                if (!(off instanceof Player)) continue;
                Player p = (Player) off;
                if (countSelf || !p.getName().equals(player.getName())) {
                    for (String perm : subTypeValue.split("\\+"))
                        if (!players.contains(p.getName()) && p.hasPermission(perm)) {
                            players.add(p.getName());
                        }
                }
            }
            return format(players);
    }
}
