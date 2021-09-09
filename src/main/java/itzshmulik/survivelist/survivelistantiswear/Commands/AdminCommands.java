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
        List Swears = plugin.getConfig().getList("swearList");
        String reloadMsg = plugin.getConfig().getString("reloadMsg");

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("sw.reload") || player.hasPermission("sw.admin")) {

                    plugin.reloadConfig();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', reloadMsg));

                }
            }
            if(args[0].equalsIgnoreCase("add")){
                if(player.hasPermission("sw.add") || player.hasPermission("sw.admin")){
                    Swears.add(args[1]);
                }
            }
        }
        return false;
    }
}
