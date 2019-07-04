package me.xilidev.exoticinteract;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExoticInteract extends JavaPlugin {

    WorldGuardPlugin worldguard;

    public static ExoticInteract instance;

    public static ExoticInteract getInstance(){

        return instance;
    }

    @Override
    public void onEnable() {
        System.out.println("[ExoticInteract] ON");
        try {
            worldguard = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        }catch (Exception e){
            e.printStackTrace();
        }
        instance = this;

        getServer().getPluginManager().registerEvents(new InteractEvent(), this);
        getCommand("int").setExecutor(new CommandCore());


    }

    public void createCustomRegion(){


    }

    @Override
    public void onDisable() {
        System.out.println("[ExoticInteract] OFF");
    }
}
