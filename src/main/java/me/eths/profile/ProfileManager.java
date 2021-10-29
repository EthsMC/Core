package me.eths.profile;

import lombok.Getter;
import me.eths.CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

@Getter
public class ProfileManager implements Listener {

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
