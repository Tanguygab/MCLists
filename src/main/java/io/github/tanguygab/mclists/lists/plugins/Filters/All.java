package io.github.tanguygab.mclists.lists.plugins.Filters;

import io.github.tanguygab.mclists.lists.plugins.SubType;
import io.github.tanguygab.mclists.lists.plugins.plugins;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class All extends plugins {

    private final List<Plugin> plugins = Arrays.asList(Bukkit.getServer().getPluginManager().getPlugins());

    public All(SubType subtype) {
        super(subtype);
    }

    public String getText(Player p) {
        return subtype.getText(p, plugins);
    }
}
