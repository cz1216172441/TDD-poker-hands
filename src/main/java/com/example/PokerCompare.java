package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PokerCompare {

    private final PokerRank pokerRank;

    public PokerCompare(PokerRank pokerRank) {
        this.pokerRank = pokerRank;
    }

    public int compare(List<Poker> black, List<Poker> white) {
        List<Poker> blackSorted = black.stream().sorted().collect(Collectors.toList());
        List<Poker> whiteSorted = white.stream().sorted().collect(Collectors.toList());
        int blackRank = pokerRank.calculatePokerRank(black);
        int whiteRank = pokerRank.calculatePokerRank(white);
        if (isPokersConsistent(blackSorted, whiteSorted)) {
            return CompareResultEnum.TIE.getValue();
        }
        if (blackRank > whiteRank) {
            return CompareResultEnum.BLACK_WIN.getValue();
        } else if (whiteRank > blackRank) {
            return CompareResultEnum.WHITE_WIN.getValue();
        } else {
            return pokersSameRankCompare(blackSorted, whiteSorted);
        }
    }

    private boolean isPokersConsistent(List<Poker> blackSorted, List<Poker> whiteSorted) {
        for (int i = 0; i < blackSorted.size() - 1; i++) {
            if (!(blackSorted.get(i).equals(whiteSorted.get(i)))) {
                return false;
            }
        }
        return true;
    }

    private int pokersSameRankCompare(List<Poker> blackSorted, List<Poker> whiteSorted) {
        for (int i = 0; i < blackSorted.size(); i++) {
            if (blackSorted.get(i).getNum() > whiteSorted.get(i).getNum()) {
                return CompareResultEnum.BLACK_WIN.getValue();
            } else if (blackSorted.get(i).getNum() < whiteSorted.get(i).getNum()) {
                return CompareResultEnum.WHITE_WIN.getValue();
            }
        }
        return CompareResultEnum.TIE.getValue();
    }

}
