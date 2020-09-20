package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Nearby extends SubType {

    public Nearby(boolean countSelf, String output, String subtypevalue) {
        super(countSelf, output, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        int zone = (int) Math.pow(Integer.parseInt(subTypeValue), 2);
        ArrayList<String> players = new ArrayList<>();
        for (OfflinePlayer off : list) {
            if (!(off instanceof Player)) continue;
            Player p = (Player) off;
            if (countSelf || !p.getName().equals(player.getName())) {
                if (p.getWorld().equals(player.getPlayer().getWorld()) && player.getPlayer().getLocation().distanceSquared(p.getLocation()) < zone) {
                    players.add(p.getName());
                }
            }
        }
        return format(players);
    }
}
