package com.nightmarephoenix.irongolemfix.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemSpawner implements Listener {

    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        try {
            if((e.getClickedBlock().getType() == Material.BIRCH_SIGN || e.getClickedBlock().getType() == Material.BIRCH_WALL_SIGN) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(p.getInventory().contains(Material.SPAWNER)) {
                    for(int i = 0; i < p.getInventory().getContents().length; i++) {
                        try {
                            if (p.getInventory().getContents()[i].getItemMeta().toString().contains("iron_golem Spawner")) {
                                p.getInventory().removeItem(p.getInventory().getItem(i));

                                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + p.getName() + " pillager_spawner 1");

                                ItemStack is = p.getInventory().getItem(i);
                                ItemMeta im = is.getItemMeta();
                                im.setDisplayName(ChatColor.YELLOW + "Golem spawner");
                                is.setItemMeta(im);
                            }
                        } catch (Exception e1) {
                            continue;
                        }
                    }
                }
            }
            return;
        } catch (Exception e1) {
            return;
        }
    }
}
