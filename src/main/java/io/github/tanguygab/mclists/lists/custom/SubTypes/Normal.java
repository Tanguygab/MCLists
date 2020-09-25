package io.github.tanguygab.mclists.lists.custom.SubTypes;

import io.github.tanguygab.mclists.lists.custom.SubType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Normal extends SubType {

    @Override
    public String getText(Player p, Collection<? extends String> list) {

        ArrayList<String> custom = new ArrayList<>();
            for (String str : list) {
                custom.add(str);
                }

            return format(custom);
    }
}
