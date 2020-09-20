package io.github.tanguygab.mclists.lists.players;

import org.bukkit.entity.Player;

public class InvalidPlayers extends players {

    public String text;

    public InvalidPlayers(String text) {
        this.text = text;
    }

    @Override
    public String getText(Player p) {
        return "§a[MCLists] §7"+text;
    }
}