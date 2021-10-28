package me.eths;

import lombok.Getter;
import me.eths.profile.ProfileManager;
import me.eths.ranks.RankManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class CorePlugin extends JavaPlugin {

    public static CorePlugin instance;

    private ProfileManager profileManager;
    private RankManager rankManager;

    public void onEnable() {
        instance = this;

        profileManager = new ProfileManager();
        rankManager = new RankManager();

    }

    public void onDisable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
