package me.xilidev.exoticinteract;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import me.xilidev.exoticinteract.utils.WorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



import java.util.HashSet;


public class CommandCore implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {


            WorldUtils wg = new WorldUtils();
            Player target = Bukkit.getPlayer(args[3]);
            Player player = (Player) sender;
            Location loca = player.getLocation();
            WorldGuardPlatform platform = WorldGuard.getInstance().getPlatform();
            RegionContainer container = platform.getRegionContainer();
            RegionManager regionManager = container.get(BukkitAdapter.adapt(WorldUtils.getAllowRegion(loca).getWorld()));
            ProtectedRegion region = regionManager.getRegion(args[4]);
            HashSet<Material> transparent = new HashSet<Material>();
            transparent.add(Material.AIR);
            Block block = player.getTargetBlock(transparent, 5);


            if (cmd.getName().equalsIgnoreCase("int")) {
                if (args.length == 0) {

                    player.sendMessage("§4Command: §2 <set> <everyone/JOUEUR> <true/false> <nom de la région>");

                } else if (args.length == 1) {

                    player.sendMessage("§4Command: §2 <set> <everyone/JOUEUR> <true/false> <nom de la région>");
                } else if (args.length == 2) {

                    player.sendMessage("§4Command: §2 <set> <everyone/JOUEUR> <true/false> <nom de la région>");

                } else if (args.length == 3) {

                    player.sendMessage("§4Command: §2 <set> <everyone/JOUEUR> <true/false> <nom de la région>");

                } else if (args.length == 4) {

                    if (cmd.getName().equalsIgnoreCase("set")) {

                        if (cmd.getName().equalsIgnoreCase("everyone")) {

                            //Command for Everyone

                            if (cmd.getName().equalsIgnoreCase("true")) {

                                if (cmd.getName().equals(regionManager)) {


                                    for (Player p : Bukkit.getOnlinePlayers()) {

                                        if (!p.getDisplayName().equalsIgnoreCase(sender.getName())) {

                                            if (wg.getAutorisation() == true) {

                                                player.sendMessage("§4Ce block est accessible par tous !");

                                                wg.setIdBlock(block.getType());


                                            } else if (wg.getAutorisation() == false) {

                                                wg.setAutorisation(true);

                                                player.sendMessage("§4Ce block n'est accessible par tous !");

                                            }
                                        }
                                    }
                                } else {

                                    return true;
                                }


                            } else if (cmd.getName().equalsIgnoreCase("false")) {

                                if (cmd.getName().equals(regionManager)) {


                                    for (Player p : Bukkit.getOnlinePlayers()) {

                                        if (!p.getDisplayName().equalsIgnoreCase(sender.getName())) {

                                            if (wg.getAutorisation() == false) {

                                                player.sendMessage("§4Ce block n'est accessible par tous !");

                                                wg.setIdBlock(block.getType());


                                            } else if (wg.getAutorisation() == true) {

                                                wg.setAutorisation(false);

                                                player.sendMessage("§4Ce block n'est accessible par tous !");

                                            }
                                        }
                                    }
                                } else {

                                    return true;
                                }


                            }

                        } else if (cmd.getName().equals(target)) {

                            //Command for player
                            if (cmd.getName().equalsIgnoreCase("true")) {

                                if (cmd.getName().equals(regionManager)) {


                                    for (Player p : Bukkit.getOnlinePlayers()) {

                                        if(target != p){

                                            player.sendMessage("Joueur inconnue ou pseudo incorrect");

                                        }else if (wg.getAutorisation() == true) {

                                            player.sendMessage("§1Ce block n'est accessible par : " + "§l§6" + target + "§1!");

                                            wg.setIdBlock(block.getType());


                                        } else if (wg.getAutorisation() == false) {

                                            player.sendMessage("§1Ce block n'est accessible par : " + "§l§6" + target + "§1!");

                                            wg.setAutorisation(true);

                                        }

                                    }
                                    } else{

                                        return true;
                                    }


                                } else if (cmd.getName().equalsIgnoreCase("false")) {

                                    if (cmd.getName().equals(regionManager)) {


                                        for (Player p : Bukkit.getOnlinePlayers()) {

                                            if (!p.getDisplayName().equalsIgnoreCase(sender.getName())) {

                                                if (wg.getAutorisation() == false) {

                                                    player.sendMessage("§1Ce block n'est accessible par : " + "§l§6" + target + "§1!");

                                                    wg.setIdBlock(block.getType());


                                                } else if (wg.getAutorisation() == true) {

                                                    wg.setAutorisation(false);

                                                }
                                            }
                                        }
                                    } else {

                                        return true;
                                    }


                                }
                            }

                        }


                    }
                }

            }
            return true;
        }
    }


        





