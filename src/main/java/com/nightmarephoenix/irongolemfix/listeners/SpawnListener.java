package com.nightmarephoenix.irongolemfix.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnListener implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e){
        this.world = e.getLocation().getWorld();
        if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER){
            if(e.getEntity().getType() == EntityType.PILLAGER) {

                double x = e.getLocation().getX();
                double y = e.getLocation().getY();
                double z = e.getLocation().getZ();

                spawnLocation = new Location(world, x, y, z);

                spawnLocationTop = new Location(world, x, y+1, z);
                spawnLocationRight = new Location(world, x, y, z+1);
                spawnLocationLeft = new Location(world, x+1, y, z);
                spawnLocationBack = new Location(world, x-1, y, z);
                spawnLocationBehind = new Location(world, x, y, z-1);
                spawnLocation11 = new Location(world, x+1, y, z+1);
                spawnLocation22 = new Location(world, x-1, y, z-1);
                spawnLocation12 = new Location(world, x+1, y, z-1);
                spawnLocation21 = new Location(world, x-1, y, z+1);

                if(Math.random() < 0.8  && world.getBlockAt(spawnLocation).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocationTop).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocationRight).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocationLeft).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocationBack).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocationBehind).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocation11).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocation12).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocation21).getType() == Material.AIR
                                        && world.getBlockAt(spawnLocation22).getType() == Material.AIR) {
                    world.spawnEntity(spawnLocation, EntityType.IRON_GOLEM);
                }
                e.getEntity().remove();
            }
        }
    }

    private World world;
    private Location spawnLocation, spawnLocationTop, spawnLocationBack, spawnLocationBehind, spawnLocationRight, spawnLocationLeft, spawnLocation11, spawnLocation12, spawnLocation21, spawnLocation22;
}
