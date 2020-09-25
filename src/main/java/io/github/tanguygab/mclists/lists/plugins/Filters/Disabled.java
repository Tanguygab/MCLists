package io.github.tanguygab.mclists.lists.plugins.Filters;

import io.github.tanguygab.mclists.lists.plugins.SubType;
import io.github.tanguygab.mclists.lists.plugins.plugins;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Disabled extends plugins {

    private List<Plugin> allPlugins = Arrays.asList(Bukkit.getServer().getPluginManager().getPlugins());

    public Disabled(SubType subtype) {
        super(subtype);
    }

    public String getText(Player p) {
        Collection<Plugin> plugins = new ArrayList<>(allPlugins);
        plugins.removeIf(Plugin::isEnabled);
        return subtype.getText(p, plugins);
    }
}
