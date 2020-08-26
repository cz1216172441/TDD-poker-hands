package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerCompareTest {

  private PokerCompare pokerCompare;

  @BeforeEach
  private void setUp() {
    pokerCompare = new PokerCompare();
  }

  @Test
  void should_white_wins_when_compare_given_black_2H_3D_5S_9C_10D_and_white_2C_3H_4S_8C_14H() {
    // given
    List<Poker> black = new ArrayList<Poker>();
    black.add(new Poker(2, 'H'));
    black.add(new Poker(3, 'D'));
    black.add(new Poker(5, 'S'));
    black.add(new Poker(9, 'C'));
    black.add(new Poker(10, 'D'));

    List<Poker> white = new ArrayList<>();
    white.add(new Poker(2, 'C'));
    white.add(new Poker(3, 'H'));
    white.add(new Poker(4, 'S'));
    white.add(new Poker(8, 'C'));
    white.add(new Poker(14, 'H'));

    // when
    String actual = pokerCompare.compare(black, white);
    // then
    assertEquals("White wins.", actual);
  }

}
