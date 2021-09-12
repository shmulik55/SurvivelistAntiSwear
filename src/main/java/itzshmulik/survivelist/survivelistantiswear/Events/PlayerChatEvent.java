package itzshmulik.survivelist.survivelistantiswear.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.regex.Pattern;

public class PlayerChatEvent implements Listener {

    private final JavaPlugin plugin = JavaPlugin.getProvidingPlugin(getClass());
    List SwearList = plugin.getConfig().getList("SwearList");

    @EventHandler
    public void playerChatEvent(AsyncPlayerChatEvent event){


    }
}
