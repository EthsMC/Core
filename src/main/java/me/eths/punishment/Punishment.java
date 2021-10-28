package me.eths.punishment;

import lombok.Getter;
import me.eths.CorePlugin;
import me.eths.profile.Profile;
import me.eths.utils.ChatColor;
import me.eths.utils.PunishmentUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@Getter
public class Punishment {

    private final PunishmentType type;
    private final String punisher;
    private final String player;
    private final long expires;

    public Punishment(PunishmentType type, String punisherUUID, String playerUUID) {

        this.type = type;
        this.punisher = punisherUUID;
        this.player = playerUUID;
        this.expires = -1;
        execute();
    }

    public Punishment(PunishmentType type, String punisherUUID, String playerUUID, long expires) {

        this.type = type;
        this.punisher = punisherUUID;
        this.player = playerUUID;
        this.expires = expires;
        execute();
    }

    private void execute() {}

    private boolean isPerm() {
        return expires == -1;
    }

    public void broadcast(boolean silent) {

        Profile playerProfile = PunishmentUtils.getProfile(player);
        Profile punisherProfile = PunishmentUtils.getProfile(punisher);

        String message;
        if (isPerm()) {
            message= playerProfile.getDisplayName() + " &ahas been permanently banned by " + punisherProfile.getDisplayName();
        } else {
            message= playerProfile.getDisplayName() + " &ahas been temporarily banned by " + punisherProfile.getDisplayName();
        }

        if (silent) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("core.punish")) player.sendMessage(ChatColor.get("&7[Silent] &a" + message));
            }
        } else {
            Bukkit.broadcastMessage(ChatColor.get(message));
        }

    }

}
