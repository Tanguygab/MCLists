package io.github.tanguygab.mclists;

import io.github.tanguygab.mclists.lists.Lists;
import org.bukkit.OfflinePlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PAPIHook extends PlaceholderExpansion {

    private MCLists plugin;

    public PAPIHook(MCLists plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){return true;}

    @Override
    public boolean canRegister(){return true;}

    @Override
    public String getAuthor(){return plugin.getDescription().getAuthors().toString();}

    @Override
    public String getIdentifier(){return plugin.getName().toLowerCase();}


    @Override
    public String getVersion(){return plugin.getDescription().getVersion();}


    @Override
    public String onRequest(OfflinePlayer player, String identifier){

        String[] args = identifier.split("_");

        //%mclists_get_<list>_<output>%
        if(args[0].equals("get")) {
            if (args.length < 2) return "§cYou have to provide a list!";
            if (args.length < 3) return "§cYou have to provide a type of output!";

            if (args[2].equals("list")) args[2] = "list-, ";
            Lists compile = Lists.compile(args[1], args[2]);
            return compile.getText(((Player) player));
        }

        return null;
    }
}