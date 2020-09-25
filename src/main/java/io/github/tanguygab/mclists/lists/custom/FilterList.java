package io.github.tanguygab.mclists.lists.custom;

import org.bukkit.entity.Player;

import java.util.List;

public class FilterList extends custom {

    private final List<String> custom;

    public FilterList(SubType subtype, List<String> filter) {
        super(subtype);
        custom = filter;
    }

    public String getText(Player p) {
        return subtype.getText(p, custom);
    }
}
