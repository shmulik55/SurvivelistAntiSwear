package itzshmulik.survivelist.survivelistantiswear.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdminCommands implements CommandExecutor {

    private final JavaPlugin plugin = JavaPlugin.getProvidingPlugin(getClass());

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        List SwearList = plugin.getConfig().getList("SwearList");
        String reloadMsg = plugin.getConfig().getString("reloadMsg");
        String NoPermMsg = plugin.getConfig().getString("NoPermMsg");
        String Prefix = plugin.getConfig().getString("Prefix");

        if (args.length >= 1) {
            if (args[0].toLowerCase().equals("reload")) {
                if (player.hasPermission("sw.reload") || player.hasPermission("sw.admin")) {

                    plugin.reloadConfig();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadMsg));

                }
            }
        }if(args.length == 1){
            if(args[0].toLowerCase().equals("add")){
                if(player.hasPermission("sw.add") || player.hasPermission("sw.admin")){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&6Command usage: /sw add {swear}"));
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', NoPermMsg));
                }
            }
        }if(args.length > 1){
            if(args[0].toLowerCase().equals("add")){
                if(player.hasPermission("sw.add") || player.hasPermission("sw.admin")){
                    SwearList.add(args[1]);
                    plugin.getConfig().set("SwearList", SwearList);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&6Added swear: " + args[1] + " to the list!"));
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', NoPermMsg));
                }
            }
        }
        return false;
    }
}
