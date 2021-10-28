package me.eths.profile;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ProfileManager {

    public HashMap<Player, Profile> profiles;

    public ProfileManager() {
        profiles = new HashMap<>();
    }


    public Profile fetch(String uuid) {
        if (profiles.containsKey(Bukkit.getPlayer(uuid))) return fetchOnline(uuid);
        return fetchOffline(uuid);
    }

    private Profile fetchOnline(String uuid) {
        return profiles.get(Bukkit.getPlayer(uuid));
    }

    private Profile fetchOffline(String uuid) {
        return new Profile(Bukkit.getPlayer(uuid).getPlayer());
    }


}
