package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Boolean.parseBoolean;

public class CanSee extends SubType {

    public CanSee(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        ArrayList<String> players = new ArrayList<>();
        for (OfflinePlayer off : list) {
            if (!(off instanceof Player)) continue;
            Player p = (Player) off;
            if (parseBoolean(subTypeValue) && player.getPlayer().canSee(p) && !p.getName().equals(player.getName())) {
                    players.add(p.getName());
            } else if (!player.getPlayer().canSee(p) && !p.getName().equals(player.getName())) {
                    players.add(p.getName());
            }
        }
        return format(players);
    }
}
