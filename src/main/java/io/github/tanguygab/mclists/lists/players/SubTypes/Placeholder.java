package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Placeholder extends SubType {

    public Placeholder(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {

        ArrayList<String> players = new ArrayList<>();
        for (OfflinePlayer p : list) {
            String[] placeholder = subTypeValue.split("\\|\\|");
            if (countSelf || !p.getName().equals(player.getName())) {
                if (PlaceholderAPI.setPlaceholders(p, "%"+placeholder[0]+"%").equals(PlaceholderAPI.setBracketPlaceholders(player, placeholder[1]))) {
                    players.add(p.getName());
                }
            }
        }
        return format(players);
    }
}
