package dev.ojvzinn.projectteste;

import dev.ojvzinn.projectteste.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Listeners.setupListeners();

        sendMessage("O plugin iniciou com sucesso!");
    }

    public void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage("§a[" + getDescription().getName() + "] " + message);
    }

    public void sendMessage(String message, String color) {
        Bukkit.getConsoleSender().sendMessage("§" + color + "[" + getDescription().getName() + "] " + message);
    }

    public static Main getInstance() {
        return instance;
    }
}
