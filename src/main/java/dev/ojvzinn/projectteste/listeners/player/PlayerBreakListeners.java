package dev.ojvzinn.projectteste.listeners.player;

import dev.ojvzinn.projectteste.Main;
import dev.ojvzinn.projectteste.utils.PlayerUtils;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.api.holograms.HologramLine;
import eu.decentsoftware.holograms.api.holograms.HologramPage;
import eu.decentsoftware.holograms.api.holograms.enums.HologramLineType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerBreakListeners implements Listener {

    @EventHandler
    public void onPlayerBreakListeners1(BlockBreakEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);

        new PlayerUtils(player).sendActionBar("+100 coins");

        if (ThreadLocalRandom.current().nextInt(100) < 5) {
            new PlayerUtils(player).sendTitle("§6Bônus", "§f+100 coins");
        }

        Block block = event.getBlock();
        block.setType(Material.AIR);
        block.getState().update(true);

        Hologram hologram = new Hologram("temporario", block.getLocation().clone().add(0.5, 1, 0.5));
        HologramPage page = hologram.getPage(0);
        HologramLine line = new HologramLine(page, hologram.getLocation(), "§fBloco de " + block.getType());
        line.setContent("§fBloco de " + block.getType());
        line.setType(HologramLineType.TEXT);
        line.setEnabled(true);
        page.addLine(line);
        page.realignLines();
        hologram.setEnabled(true);
        hologram.setDefaultVisibleState(true);
        hologram.updateAll();
        hologram.save();

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), hologram::destroy, 20 * 3L);
    }
}
