package dev.ojvzinn.projectteste.listeners;

import dev.ojvzinn.projectteste.Main;
import dev.ojvzinn.projectteste.listeners.player.PlayerBreakListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Listeners {

    public static void setupListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerBreakListeners(), Main.getInstance());
    }

}
