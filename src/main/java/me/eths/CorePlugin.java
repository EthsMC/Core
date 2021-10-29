package me.eths;

import lombok.Getter;
import me.eths.player.PlayerListener;
import me.eths.profile.ProfileManager;
import me.eths.ranks.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class CorePlugin extends JavaPlugin {

    public static CorePlugin instance;

    private ProfileManager profileManager;
    private RankManager rankManager;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        profileManager = new ProfileManager();
        rankManager = new RankManager();

        new PlayerListener();

    }

    public void onDisable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getScheduler().cancelTasks(this);
    }
}
