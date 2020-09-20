package io.github.tanguygab.mclists.lists;

import org.bukkit.entity.Player;

public class Invalid extends Lists {

    public String text;

    public Invalid(String text) {
        this.text = text;
    }

    @Override
    public String getText(Player p) {
        return "§a[MCLists] §7"+text;
    }
}
