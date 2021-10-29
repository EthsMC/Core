package me.eths.profile;

import lombok.Getter;
import lombok.Setter;
import me.eths.CorePlugin;
import me.eths.ranks.Rank;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

@Getter @Setter
public class Profile {

    private final CorePlugin instance = CorePlugin.instance;

    private final Player player;
    private final String uuid;
    private final PermissionAttachment permissionAttachment;

    private Rank rank;

    public Profile(Player player) {
        this.player = player;
        this.uuid = player.getUniqueId().toString();
        this.permissionAttachment = player.addAttachment(instance);

        setRank(instance.getRankManager().getRank("Owner"));
    }

    public String getDisplayName() {
        return rank.getColor() + player.getName();
    }

    public void setRank(Rank rank) {
        this.rank = rank;
        permissionAttachment.getPermissions().clear();
        for (String permission : rank.getPermissions()) {
            permissionAttachment.getPermissions().put(permission, true);
        }

    }

}
