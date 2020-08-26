package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PokerCompare {
  public String compare(List<Poker> black, List<Poker> white) {
    List<Poker> blackSorted = black.stream().sorted().collect(Collectors.toList());
    List<Poker> whiteSorted = white.stream().sorted().collect(Collectors.toList());
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
}
