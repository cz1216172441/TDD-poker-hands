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
        List<Poker> pokers = new ArrayList<Poker>();
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

}
