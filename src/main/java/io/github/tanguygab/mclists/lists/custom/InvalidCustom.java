package io.github.tanguygab.mclists.lists.custom;

import org.bukkit.entity.Player;

public class InvalidCustom extends custom {

    public String text;

    public InvalidCustom(String text) {
        this.text = text;
    }

    @Override
    public String getText(Player p) {
        return "§a[MCLists] §7"+text;
    }
}