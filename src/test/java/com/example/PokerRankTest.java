package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerRankTest {

    private final PokerRank pokerRank = new PokerRank();

    @Test
    void should_return_straight_flush_rank_when_calculate_poker_rank_given_3H_4H_5H_6H_7H() {
        // given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, 'H'));
        pokers.add(new Poker(4, 'H'));
        pokers.add(new Poker(5, 'H'));
        pokers.add(new Poker(6, 'H'));
        pokers.add(new Poker(7, 'H'));
        // when
        int actualRank = pokerRank.calculatePokerRank(pokers);
        // then
        assertEquals(PokerRankEnum.STRAIGHT_FLUSH.getRank(), actualRank);
    }

    @Test
    void should_return_four_of_a_kind_rank_when_calculate_poker_rank_given_3H_3D_3S_5C_3D() {
        // given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, 'H'));
        pokers.add(new Poker(3, 'D'));
        pokers.add(new Poker(3, 'S'));
        pokers.add(new Poker(5, 'C'));
        pokers.add(new Poker(3, 'D'));
        // when
        int actualRank = pokerRank.calculatePokerRank(pokers);
        // then
        assertEquals(PokerRankEnum.FOUR_OF_A_KIND.getRank(), actualRank);
    }

    @Test
    void should_return_full_house_rank_when_calculate_poker_rank_given_3H_3D_5S_5C_3D() {
        // given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, 'H'));
        pokers.add(new Poker(3, 'D'));
        pokers.add(new Poker(5, 'S'));
        pokers.add(new Poker(5, 'C'));
        pokers.add(new Poker(3, 'D'));
        // when
        int actualRank = pokerRank.calculatePokerRank(pokers);
        // then
        assertEquals(PokerRankEnum.FULL_HOUSE.getRank(), actualRank);
    }

    @Test
    void should_return_flush_rank_when_calculate_poker_rank_given_2H_3H_5H_9H_KH() {
        // given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(2, 'H'));
        pokers.add(new Poker(3, 'H'));
        pokers.add(new Poker(5, 'H'));
        pokers.add(new Poker(9, 'H'));
        pokers.add(new Poker(13, 'H'));
        // when
        int actualRank = pokerRank.calculatePokerRank(pokers);
        // then
        assertEquals(PokerRankEnum.FLUSH.getRank(), actualRank);
    }

    @Test
    void should_return_straight_rank_when_calculate_poker_rank_given_3H_4D_5S_6C_7D() {
        // given
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(3, 'H'));
        pokers.add(new Poker(4, 'D'));
        pokers.add(new Poker(5, 'S'));
        pokers.add(new Poker(6, 'C'));
        pokers.add(new Poker(7, 'D'));
        // when
        int actualRank = pokerRank.calculatePokerRank(pokers);
        // then
        assertEquals(PokerRankEnum.STRAIGHT.getRank(), actualRank);
    }

}
