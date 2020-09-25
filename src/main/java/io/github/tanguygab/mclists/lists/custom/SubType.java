package io.github.tanguygab.mclists.lists.custom;

import io.github.tanguygab.mclists.lists.Lists;
import io.github.tanguygab.mclists.lists.custom.SubTypes.Normal;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class SubType {

    protected String format(List<String> collection) {
        Collections.sort(collection);
        String output = Lists.output;
        if (output.startsWith("list")) {
            return collection.toString().replace("[", "").replace("]", "").replace(", ", output.replaceFirst("list-", "")).replace("\\.", ",");
        } else if (output.equals("amount")) {
            return collection.size() + "";
        } else if (collection.size() != 0 && Integer.parseInt(output) < collection.size()) {
            return collection.get(Integer.parseInt(output)) + "";
        } else {
            return "None";
        }
    }

    public abstract String getText(Player p, Collection<? extends String> list);

    public static SubType compile(String subtype) {
        switch (subtype) {
            case "normal":
                return new Normal();
            default:
                return null;
        }
    }
}