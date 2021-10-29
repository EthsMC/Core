package me.eths.player;

import me.eths.CorePlugin;
import me.eths.profile.Profile;
import me.eths.ranks.Rank;
import me.eths.utils.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final CorePlugin instance = CorePlugin.instance;

    public PlayerListener() {
        instance.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        Player player = e.getPlayer();
        Profile profile = new Profile(player);
        instance.getProfileManager().profiles.put(player, profile);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");
        Player player = e.getPlayer();
        instance.getProfileManager().profiles.remove(player);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        Profile profile = instance.getProfileManager().profiles.get(player);
        Rank rank = profile.getRank();

        String format = instance.getConfig().getString("Chat-Format");

        format = format.replaceAll("%player%", rank.getColor() + profile.getDisplayName());
        format = format.replaceAll("%prefix%", rank.getPrefix());
        format = format.replaceAll("%suffix%", rank.getSuffix());
        format = ChatColor.get(format);
        format = format.replaceAll("%message%", e.getMessage());

        e.setFormat(format + "");

    }

}
