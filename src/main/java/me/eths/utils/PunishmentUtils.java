package me.eths.utils;

import lombok.experimental.UtilityClass;
import me.eths.CorePlugin;
import me.eths.profile.Profile;

@UtilityClass
public class PunishmentUtils {

    private final CorePlugin instance = CorePlugin.instance;

    public boolean isSilent(String[] args) {
        for (String s : args) {
            if (s.equalsIgnoreCase("-s")) return true;
        }
        return false;
    }

    public Profile getProfile(String uuid) {
        return instance.getProfileManager().fetch(uuid);
    }

}
