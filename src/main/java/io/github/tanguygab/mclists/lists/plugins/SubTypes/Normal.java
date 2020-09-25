package io.github.tanguygab.mclists.lists.plugins.SubTypes;

import io.github.tanguygab.mclists.lists.plugins.SubType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;

public class Normal extends SubType {

    public Normal(boolean countSelf) {
        super(countSelf);
    }

    @Override
    public String getText(Player p, Collection<? extends Plugin> list) {

        ArrayList<String> plugins = new ArrayList<>();
            for (Plugin pl : list) {
                if (countSelf || !pl.getName().equals("MCLists")) {
                    plugins.add(pl.getName());
                }
            }
            return format(plugins);
    }
}
