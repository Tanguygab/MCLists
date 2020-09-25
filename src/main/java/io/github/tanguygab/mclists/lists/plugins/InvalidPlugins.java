package io.github.tanguygab.mclists.lists.plugins;

import org.bukkit.entity.Player;

public class InvalidPlugins extends plugins {

    public String text;

    public InvalidPlugins(String text) {
        this.text = text;
    }

    @Override
    public String getText(Player p) {
        return "§a[MCLists] §7"+text;
    }
}