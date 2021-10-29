package me.eths.ranks;

import me.eths.CorePlugin;
import me.eths.profile.Profile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RankManager {

    private final CorePlugin instance = CorePlugin.instance;

    private ArrayList<Rank> ranks;

    public RankManager() {
        ranks = new ArrayList<>();

        int rankId = 0;

        for (String rankName : instance.getConfig().getConfigurationSection("Ranks").getKeys(false)) {
            String prefix = instance.getConfig().getString("Ranks." + rankName + ".prefix");
            String suffix = instance.getConfig().getString("Ranks." + rankName + ".suffix");
            String color = instance.getConfig().getString("Ranks." + rankName + ".color");
            List<String> permissions = instance.getConfig().getStringList("Ranks." + rankName + ".prefix");

            Rank rank = new Rank(rankName);
            rank.setPrefix(prefix);
            rank.setSuffix(suffix);
            rank.setColor(color);
            rank.getPermissions().addAll(permissions);

            ranks.add(rank, rankId);

            rankId++;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Profile profile : instance.getProfileManager().profiles.values()) {
                    profile.getPlayer().setDisplayName(profile.getDisplayName());
                }
            }
        }.runTaskTimer(instance, 1, 1);

    }

    public Rank getRank(String name) {
        for (Rank rank : ranks) {
            if (rank.getName().equalsIgnoreCase(name)) return rank;
        }
        return null;
    }

}
