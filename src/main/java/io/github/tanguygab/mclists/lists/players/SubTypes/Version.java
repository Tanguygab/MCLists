package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import us.myles.ViaVersion.api.Via;

import java.util.ArrayList;
import java.util.Collection;

public class Version extends SubType {

    public Version(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {
        if (!Bukkit.getPluginManager().isPluginEnabled("ViaVersion")) {
            return "§4§lError: §cYou need ViaVersion!";
        }
        ArrayList<String> players = new ArrayList<>();
            for (OfflinePlayer p : list) {
                if (countSelf || !p.getName().equals(player.getName())) {
                    //split subtypevalue in case checking multiples versions
                    for (String version : subTypeValue.split("\\+")) {
                        int pVer = Via.getAPI().getPlayerVersion(p.getUniqueId());
                        //check if player already in list
                        if (!players.contains(p.getName())) {
                            //check if subtypeValue contains "-" (in case using range)
                            if (version.contains("-")) {
                                String[] verRange = version.split("-");
                                //check if p's version is in range
                                if (pVer >= Integer.parseInt(verRange[0]) && pVer <= Integer.parseInt(verRange[1])) {
                                    players.add(p.getName());
                                }
                              //check if p's version == subtypevalue (=required version)
                            } else if (pVer == Integer.parseInt(version)) {
                                players.add(p.getName());
                            }
                        }
                    }
                }
            }
            return format(players);
    }
}
