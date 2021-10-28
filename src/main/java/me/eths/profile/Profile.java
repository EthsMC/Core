package me.eths.profile;

import lombok.Getter;
import lombok.Setter;
import me.eths.ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@Getter @Setter
public class Profile {

    private final Player player;
    private final String uuid;

    private Rank rank;

    public Profile(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId().toString();
    }

    public String getDisplayName() {
        return rank.getColor() + player.getName();
    }


}
