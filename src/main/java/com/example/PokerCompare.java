package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PokerCompare {
  public String compare(List<Poker> black, List<Poker> white) {
    List<Poker> blackSorted = black.stream().sorted().collect(Collectors.toList());
    List<Poker> whiteSorted = white.stream().sorted().collect(Collectors.toList());
    if(isPokersConsistent(blackSorted,whiteSorted)){
      return ResultEnum.TIE.getResult();
    }
    if (isPokersStraightFlush(blackSorted)) {
      return ResultEnum.BLACK_WIN.getResult();
    }
    if (isPokersStraightFlush(whiteSorted)) {
      return ResultEnum.WHITE_WIN.getResult();
    }
    for (Poker blackPoker : blackSorted) {
      for (Poker whitePoker : whiteSorted) {
        if (blackPoker.getNum() > whitePoker.getNum()) {
          return ResultEnum.BLACK_WIN.getResult();
        } else if (blackPoker.getNum() < whitePoker.getNum()) {
          return ResultEnum.WHITE_WIN.getResult();
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

  private boolean isPokersConsistent(List<Poker> black, List<Poker> white) {
    for(int i = 0; i < black.size() - 1; i++){
      if(!(black.get(i).equals(white.get(i)))){
        return false;
      }
    }
    return true;
  }

}
