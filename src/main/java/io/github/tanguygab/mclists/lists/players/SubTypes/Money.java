package io.github.tanguygab.mclists.lists.players.SubTypes;

import io.github.tanguygab.mclists.Hooks;
import io.github.tanguygab.mclists.lists.players.SubType;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Money extends SubType {

    public Money(boolean countSelf, String subtypevalue) {
        super(countSelf, subtypevalue);
    }

    @Override
    public String getText(Player player, Collection<? extends OfflinePlayer> list) {
        if (!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            return "§4§lError: §cYou need Vault!";
        }        if (!Hooks.econ.isEnabled()) {
            return "§4§lError: §cYou need an Economy plugin supporting Vault!";
        }
        ArrayList<String> players = new ArrayList<>();
            for (OfflinePlayer p : list) {
                if (countSelf || !p.getName().equals(player.getName())) {
                        //get p's balance
                        double pMoney = Hooks.econ.getBalance(p);
                        //check if player already in list
                        if (!players.contains(p.getName())) {
                            //check if subtypeValue contains "-" (in case using range)
                            if (subTypeValue.contains("-")) {
                                String[] verRange = subTypeValue.split("-");
                                //check if p's balance is in range
                                if (pMoney >= Integer.parseInt(verRange[0]) && pMoney <= Integer.parseInt(verRange[1])) {
                                    players.add(p.getName());
                                }

                            } else if (subTypeValue.startsWith(">=")) {
                                if (pMoney >= Integer.parseInt(subTypeValue.replaceFirst(">=",""))) {
                                    players.add(p.getName());
                                }
                            } else if (subTypeValue.startsWith("<=")) {
                                if (pMoney <= Integer.parseInt(subTypeValue.replaceFirst("<=",""))) {
                                    players.add(p.getName());
                                }
                            } else if (subTypeValue.startsWith(">")) {
                                if (pMoney > Integer.parseInt(subTypeValue.replaceFirst(">",""))) {
                                    players.add(p.getName());
                                }
                            } else if (subTypeValue.startsWith("<")) {
                                if (pMoney < Integer.parseInt(subTypeValue.replaceFirst("<",""))) {
                                    players.add(p.getName());
                                }
                            //check if p's balance == subtypevalue (=required money)
                            } else if (pMoney == Integer.parseInt(subTypeValue)) {
                                players.add(p.getName());
                            }
                        }
                }
            }
            return format(players);
    }
}
