package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokerCompareTest {

    private PokerCompare pokerCompare;

    private PokerRank pokerRank;

    @BeforeEach
    public void setUp() {
        pokerRank = mock(PokerRank.class);
        pokerCompare = new PokerCompare(pokerRank);
    }

    @Test
    void should_return_white_win_value_when_compare_given_black_2H_3D_5S_9C_10D_and_white_2C_3H_4S_8C_14H() {
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
        when(pokerRank.calculatePokerRank(black)).thenReturn(0);
        when(pokerRank.calculatePokerRank(white)).thenReturn(0);
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.WHITE_WIN.getValue(), actual);
    }

    @Test
    void should_return_black_win_value_when_compare_given_black_2H_3D_5S_9C_10D_and_white_2C_3H_4S_8C_10S() {
        // given
        List<Poker> black = new ArrayList<>();
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
        white.add(new Poker(10, 'S'));

        // when
        when(pokerRank.calculatePokerRank(black)).thenReturn(0);
        when(pokerRank.calculatePokerRank(white)).thenReturn(0);
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.BLACK_WIN.getValue(), actual);
    }

    @Test
    void should_return_black_win_value_when_compare_given_black_3D_4D_5D_6D_7D_and_white_2C_3H_4S_8C_10S() {
        // given
        List<Poker> black = new ArrayList<>();
        black.add(new Poker(3, 'D'));
        black.add(new Poker(4, 'D'));
        black.add(new Poker(5, 'D'));
        black.add(new Poker(6, 'D'));
        black.add(new Poker(7, 'D'));

        List<Poker> white = new ArrayList<>();
        white.add(new Poker(2, 'C'));
        white.add(new Poker(3, 'H'));
        white.add(new Poker(4, 'S'));
        white.add(new Poker(8, 'C'));
        white.add(new Poker(10, 'S'));

        // when
        when(pokerRank.calculatePokerRank(black)).thenReturn(8);
        when(pokerRank.calculatePokerRank(white)).thenReturn(0);
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.BLACK_WIN.getValue(), actual);
    }

    @Test
    void should_return_tie_value_when_compare_given_black_3D_4D_5D_6D_7D_and_white_3D_4D_5D_6D_7D() {
        // given
        List<Poker> black = new ArrayList<>();
        black.add(new Poker(3, 'D'));
        black.add(new Poker(4, 'D'));
        black.add(new Poker(5, 'D'));
        black.add(new Poker(6, 'D'));
        black.add(new Poker(7, 'D'));

        List<Poker> white = new ArrayList<>();
        white.add(new Poker(3, 'D'));
        white.add(new Poker(4, 'D'));
        white.add(new Poker(5, 'D'));
        white.add(new Poker(6, 'D'));
        white.add(new Poker(7, 'D'));

        // when
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.TIE.getValue(), actual);
    }

    @Test
    void should_return_black_win_value_when_compare_given_black_3D_4D_5D_6D_7D_and_white_3H_3D_3S_5C_3D() {
        // given
        List<Poker> black = new ArrayList<>();
        black.add(new Poker(3, 'D'));
        black.add(new Poker(4, 'D'));
        black.add(new Poker(5, 'D'));
        black.add(new Poker(6, 'D'));
        black.add(new Poker(7, 'D'));

        List<Poker> white = new ArrayList<>();
        white.add(new Poker(3, 'H'));
        white.add(new Poker(3, 'D'));
        white.add(new Poker(3, 'S'));
        white.add(new Poker(5, 'C'));
        white.add(new Poker(3, 'D'));

        // when
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.BLACK_WIN.getValue(), actual);
    }

    @Test
    void should_return_white_win_value_when_compare_given_black_3D_4D_5D_6D_7D_and_white_4D_5D_6D_7D_8D() {
        // given
        List<Poker> black = new ArrayList<>();
        black.add(new Poker(3, 'D'));
        black.add(new Poker(4, 'D'));
        black.add(new Poker(5, 'D'));
        black.add(new Poker(6, 'D'));
        black.add(new Poker(7, 'D'));

        List<Poker> white = new ArrayList<>();
        white.add(new Poker(4, 'D'));
        white.add(new Poker(5, 'D'));
        white.add(new Poker(6, 'D'));
        white.add(new Poker(7, 'D'));
        white.add(new Poker(8, 'D'));

        // when
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.WHITE_WIN.getValue(), actual);
    }

    @Test
    void should_return_black_win_value_when_compare_given_black_3H_3D_3S_5C_3D_and_white_3H_3D_5S_5C_3D() {
        // given
        List<Poker> black = new ArrayList<>();
        black.add(new Poker(3, 'D'));
        black.add(new Poker(4, 'D'));
        black.add(new Poker(5, 'D'));
        black.add(new Poker(6, 'D'));
        black.add(new Poker(7, 'D'));

        List<Poker> white = new ArrayList<>();
        white.add(new Poker(3, 'H'));
        white.add(new Poker(3, 'D'));
        white.add(new Poker(5, 'S'));
        white.add(new Poker(5, 'C'));
        white.add(new Poker(3, 'D'));

        // when
        int actual = pokerCompare.compare(black, white);
        // then
        assertEquals(CompareResultEnum.BLACK_WIN.getValue(), actual);
    }

}
