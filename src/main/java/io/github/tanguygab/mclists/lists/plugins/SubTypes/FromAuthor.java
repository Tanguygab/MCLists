package io.github.tanguygab.mclists.lists.plugins.SubTypes;

import io.github.tanguygab.mclists.lists.plugins.SubType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;

public class FromAuthor extends SubType {

    public FromAuthor(String subtypeValue) {
        super(subtypeValue);
    }

    @Override
    public String getText(Player p, Collection<? extends Plugin> list) {

        ArrayList<String> plugins = new ArrayList<>();
            for (Plugin pl : list)
                if (pl.getDescription().getAuthors().contains(subtypeValue))
                    plugins.add(pl.getName());

            return format(plugins);
    }
}
