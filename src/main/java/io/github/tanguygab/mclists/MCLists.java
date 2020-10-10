package io.github.tanguygab.mclists;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.tanguygab.mclists.lists.Invalid;
import io.github.tanguygab.mclists.lists.Lists;

public class MCLists extends JavaPlugin implements CommandExecutor, TabCompleter {


    FileConfiguration config;
    ConfigurationSection section;
    List<String> lists = new ArrayList<>();

    public void reload() {
        reloadConfig();
        config = getConfig();
        section = config.getConfigurationSection("lists");
        lists.clear();
        lists.addAll(section.getKeys(false));
    }

    @Override
    public void onEnable() {
        getLogger().info("Hey you!");
        saveDefaultConfig();
        reload();
        if (getServer().getPluginManager().getPlugin("Vault") != null)
            new PAPIHook(this).register();
        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            new Hooks().setupEco();
            new Hooks().setupPerms();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Bye bye 🖐");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0)
            sender.sendMessage("§m                                       \n" +
                    "§a[MCLists] §71.0\n" +
                    "§f - §3/mclists\n" +
                    "§8    | §aDefault help page\n" +
                    "§f - §3/mclists list\n" +
                    "§8    | §aDisplay all lists\n" +
                    "§f - §3/mclists get <list> <output>\n" +
                    "§8    | §aGet a list with a specified output\n" +
                    "§f - §3/mclists reload\n" +
                    "§8    | §aReload the configuration file\n" +
                    "§f§m                                       ");
        else if (args[0].matches("list(s)?")) {
            sender.sendMessage("§7Your current lists §8(" + lists.size() + ")§7:");
            for (String list : lists) sender.sendMessage("§f- §3" + list);
        } else if (args[0].matches("(rl|reload)")) {
            reload();
            sender.sendMessage("§7Reloading config... Reloaded " + lists.size() + " lists.");
        } else if (args[0].equals("get")) {
            if (sender instanceof Player) {
                if (args.length < 2) sender.sendMessage("§cYou have to provide a list!");
                if (args.length < 3) sender.sendMessage("§cYou have to provide a type of output!");
                else {
                    if (args[2].equals("list")) args[2] = "list-, ";
                    Lists compile = Lists.compile(args[1], args[2]);
                    sender.sendMessage(compile.getText(((Player) sender)));
                }
            }
            else sender.sendMessage(String.valueOf(new Invalid("§cYou can't use this from console!")));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1 && !args[0].matches("(list|lists|get|rl|reload)"))
            return new ArrayList<>(Arrays.asList("list","lists","get","rl","reload"));
        else if (args[0].equals("get") && args.length == 2) return lists;
        else if (args[0].equals("get") && args.length == 3)
            return new ArrayList<>(Arrays.asList("list","amount","<number>"));
        return null;
    }
}
