package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerCompareTest {

  @Test
  void should_white_wins_when_compare_given_black_2H_3D_5S_9C_KD_and_white_2C_3H_4S_8C_AH() {
    // given
    PokerCompare pokerCompare = new PokerCompare();
    String[] black = new String[] {"2H", "3D", "5S", "9C", "KD"};
    String[] white = new String[] {"2C", "3H", "4S", "8C", "AH"};
    // when
    String actual = pokerCompare.compare(black, white);
    // then
    assertEquals("White wins.", actual);
  }

}
