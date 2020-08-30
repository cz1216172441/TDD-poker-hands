package com.example;

import java.util.List;

public class PokerRank {
    public int calculatePokerRank(List<Poker> pokers) {
        if (isPokersFlush(pokers) && isPokersFlush(pokers)) {
            return PokerRankEnum.STRAIGHT_FLUSH.getRank();
        }
        if (isFourOfAKind(pokers)) {
            return PokerRankEnum.FOUR_OF_A_KIND.getRank();
        }
        return -1;
    }

    private boolean isPokersStraight(List<Poker> pokers) {
        boolean isPokersStraight = true;
        for (int i = 0; i < pokers.size() - 1; i++) {
            if (!(pokers.get(i).getNum() - pokers.get(i + 1).getNum() == 1)) {
                isPokersStraight = false;
                break;
            }
        }
        return isPokersStraight;
    }

    private boolean isPokersFlush(List<Poker> pokers) {
        return pokers.stream()
                .filter(poker -> pokers.get(0).getSuit() == poker.getSuit())
                .count() == 5;
    }

    private boolean isFourOfAKind(List<Poker> pokers) {
        return pokers.stream()
                .map(Poker::getNum)
                .distinct()
                .count() == 2;
    }
}
