package io.github.tanguygab.mclists;

//import me.arasple.mc.trmenu.api;
import org.bukkit.Bukkit;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;

public class Hooks {
    public static Economy econ = null;
    public static Permission perms = null;
    ServicesManager rsp = Bukkit.getServer().getServicesManager();

    boolean setupEco() {
        RegisteredServiceProvider<Economy> rspe = rsp.getRegistration(Economy.class);
        if (rspe == null) {
            return false;
        }
        econ = rspe.getProvider();
        return econ != null;
    }

    boolean setupPerms() {
        RegisteredServiceProvider<Permission> rspp = rsp.getRegistration(Permission.class);
        perms = rspp.getProvider();
        return perms != null;
    }
}
