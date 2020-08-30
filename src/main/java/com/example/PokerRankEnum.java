package com.example;

public enum PokerRankEnum {

    STRAIGHT_FLUSH("Straight flush", 8),
    FOUR_OF_A_KIND("Four of a kind", 7),
    FULL_HOUSE("Full House", 6),
    FLUSH("Flush", 5),
    STRAIGHT("Straight", 4),
    THREE_OF_A_KIND("Three of a kind", 3),
    TWO_PAIRS("Two pairs", 2),
    PAIR("Pair", 1),
    HIGH_CARD("High Card", 0);

    private String name;

    private int rank;

    PokerRankEnum(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
