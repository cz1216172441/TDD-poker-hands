package com.example;

import java.util.Arrays;

public class PokerCompare {
  public String compare(String[] black, String[] white) {
    long blackCountA = Arrays.stream(black).filter(item -> item.charAt(0) == 'A').count();
    long whiteCountA = Arrays.stream(white).filter(item -> item.charAt(0) == 'A').count();
    if (blackCountA > 0) {
      return "Black wins.";
    } else if (whiteCountA > 0) {
      return "White wins.";
    }
    return null;
  }
}
