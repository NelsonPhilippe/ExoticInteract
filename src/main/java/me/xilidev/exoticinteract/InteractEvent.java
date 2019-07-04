package me.xilidev.exoticinteract;


import me.xilidev.exoticinteract.utils.WorldUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class InteractEvent implements Listener{

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent e){

        Player player = e.getPlayer();
        WorldUtils wg = new WorldUtils();

        if(wg.getAutorisation() == false){

            e.setCancelled(true);
            player.sendMessage(ChatColor.BLUE + "Vous n'avez pas la permission d'interagir avec ce block !");


        }else{

            e.setCancelled(false);
        }
    }
}
