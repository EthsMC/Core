package me.eths.ranks;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Rank {

    private final String name;

    private final String color = "";
    private final String prefix = "";
    private final String suffix = "";

    private final int tier = 999;

    public Rank(String name) {
        this.name = name;
    }

}
