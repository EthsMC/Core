package me.eths.commands;

import me.eths.CorePlugin;
import me.eths.profile.Profile;
import me.eths.punishment.Punishment;
import me.eths.punishment.PunishmentType;
import me.eths.utils.ChatColor;
import me.eths.utils.PunishmentUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    private final CorePlugin instance = CorePlugin.instance;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Profile punisher = instance.getProfileManager().fetch(((Player) commandSender).getUniqueId().toString());
        Profile player = instance.getProfileManager().fetch(Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString());

        if (commandSender instanceof Player) {
        }

        Punishment ban = new Punishment(PunishmentType.BAN, punisher.getUuid(), player.getUuid());

        ban.broadcast(PunishmentUtils.isSilent(args));

        return false;
    }
}
