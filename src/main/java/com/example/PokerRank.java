package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerRank {
    public int calculatePokerRank(List<Poker> pokers) {
        List<Poker> pokersSorted = pokers.stream().sorted().collect(Collectors.toList());
        if (isPokersStraightFlush(pokersSorted)) {
            return PokerRankEnum.STRAIGHT_FLUSH.getRank();
        }
        if (isFourOfAKind(pokersSorted)) {
            return PokerRankEnum.FOUR_OF_A_KIND.getRank();
        }
        if (isFullHouse(pokersSorted)) {
            return PokerRankEnum.FULL_HOUSE.getRank();
        }
        if (isPokersFlush(pokersSorted)) {
            return PokerRankEnum.FLUSH.getRank();
        }
        return -1;
    }

    private boolean isPokersStraightFlush(List<Poker> pokers) {
        return isPokersStraight(pokers) && isPokersFlush(pokers);
    }

    private boolean isPokersStraight(List<Poker> pokers) {
        boolean isPokersStraight = true;
        for (int i = 0; i < pokers.size() - 1; i++) {
            if (pokers.get(i).getNum() - pokers.get(i + 1).getNum() != 1) {
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
        Map<Integer, Integer> map = classify(pokers);
        for (Integer num: map.keySet()) {
            if (map.get(num) == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse(List<Poker> pokers) {
        long count = pokers.stream()
                .map(Poker::getNum)
                .distinct()
                .count();
        return count == 2;
    }

    private Map<Integer, Integer> classify(List<Poker> pokers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Poker poker : pokers) {
            if (!map.containsKey(poker.getNum())) {
                map.put(poker.getNum(), 1);
            } else {
                map.put(poker.getNum(), map.get(poker.getNum()) + 1);
            }
        }
        return map;
    }
}
