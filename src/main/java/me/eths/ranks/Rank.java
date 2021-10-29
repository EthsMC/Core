package me.eths.ranks;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Rank {

    private final String name;

    private String color = "";
    private String prefix = "";
    private String suffix = "";

    private int rankId;

    private List<String> permissions = new ArrayList<>();

    public Rank(String name, int rankId) {
         this.rankId = rankId; this.name = name;
    }

}
