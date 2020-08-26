package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PokerCompare {
  public String compare(List<Poker> black, List<Poker> white) {
    List<Poker> blackSorted = black.stream().sorted().collect(Collectors.toList());
    List<Poker> whiteSorted = white.stream().sorted().collect(Collectors.toList());
    if (isPokersStraightFlush(blackSorted)) {
      return "Black wins.";
    }
    if (isPokersStraightFlush(whiteSorted)) {
      return "White wins.";
    }
    for (Poker blackPoker : blackSorted) {
      for (Poker whitePoker : whiteSorted) {
        if (blackPoker.getNum() > whitePoker.getNum()) {
          return "Black wins.";
        } else if (blackPoker.getNum() < whitePoker.getNum()) {
          return "White wins.";
        }
      }
    }
    return null;
  }

  private boolean isPokersStraightFlush(List<Poker> pokers) {
    return isPokersStraight(pokers) && isPokersFlush(pokers);
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

}
