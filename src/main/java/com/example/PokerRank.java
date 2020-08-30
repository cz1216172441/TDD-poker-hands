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
        if (isPokersStraight(pokersSorted)) {
            return PokerRankEnum.STRAIGHT.getRank();
        }
        if (isThreeOfAKind(pokersSorted)) {
            return PokerRankEnum.THREE_OF_A_KIND.getRank();
        }
        if (isTwoPairs(pokersSorted)) {
            return PokerRankEnum.TWO_PAIRS.getRank();
        }
        if (isPair(pokersSorted)) {
            return PokerRankEnum.PAIR.getRank();
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
        return judgeRepeatedKind(pokers, 4);
    }

    private boolean isThreeOfAKind(List<Poker> pokers) {
        return judgeRepeatedKind(pokers, 3);
    }

    private boolean isPair(List<Poker> pokers) {
        return judgeRepeatedKind(pokers, 2);
    }

    private boolean judgeRepeatedKind(List<Poker> pokers, int i) {
        Map<Integer, Integer> map = classify(pokers);
        for (Integer num : map.keySet()) {
            if (map.get(num) == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPairs(List<Poker> pokers) {
        long count = getDistinctPokersNumCount(pokers);
        return count == 3;
    }

    private boolean isFullHouse(List<Poker> pokers) {
        long count = getDistinctPokersNumCount(pokers);
        return count == 2;
    }

    private long getDistinctPokersNumCount(List<Poker> pokers) {
        return pokers.stream()
                .map(Poker::getNum)
                .distinct()
                .count();
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
