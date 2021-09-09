package itzshmulik.survivelist.survivelistantiswear;

import itzshmulik.survivelist.survivelistantiswear.Commands.AdminCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivelistAntiSwear extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("sw").setExecutor(new AdminCommands());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}
