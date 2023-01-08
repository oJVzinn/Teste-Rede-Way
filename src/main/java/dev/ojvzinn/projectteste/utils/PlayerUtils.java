package dev.ojvzinn.projectteste.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class PlayerUtils {

    private final Player player;

    public PlayerUtils(Player player) {
        this.player = player;
    }

    public void sendActionBar(String message) {
        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public void sendTitle(String helder, String footer) {
        this.player.sendTitle(helder, footer, 10,20, 10);
    }
}
