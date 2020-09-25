package io.github.tanguygab.mclists.lists.players;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.github.tanguygab.mclists.lists.Lists;
import io.github.tanguygab.mclists.lists.players.SubTypes.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public abstract class SubType {

    protected boolean countSelf;
    protected String subTypeValue;

    public SubType(boolean countSelf, String subTypeValue) {
        this.countSelf = countSelf;
        this.subTypeValue = subTypeValue;
    }

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
            return "Offline";
        }
    }

    public abstract String getText(Player player, Collection<? extends OfflinePlayer> list);

    public static SubType compile(String subtype, boolean countSelf, String subtypevalue) {

        switch (subtype) {
            case "normal":
                return new Normal(countSelf, subtypevalue);
            case "perm":
                return new Permission(countSelf, subtypevalue);
            case "world":
                return new World(countSelf, subtypevalue);
            case "nearby":
                return new Nearby(countSelf, subtypevalue);
            case "whitelisted":
                return new Whitelisted(countSelf, subtypevalue);
            case "banned":
                return new Banned(countSelf, subtypevalue);
            case "cansee":
                return new CanSee(countSelf,  subtypevalue);
            case "placeholder":
                return new Placeholder(countSelf, subtypevalue);
            case "gamemode":
                return new Gamemode(countSelf, subtypevalue);
            case "version":
                return new Version(countSelf, subtypevalue);
            case "isop":
                return new isOp(countSelf, subtypevalue);
            case "money":
                return new Money(countSelf, subtypevalue);
            default:
                return null;
        }
    }
}