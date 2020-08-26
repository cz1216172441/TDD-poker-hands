package com.example;

import java.util.Objects;

public class Poker implements Comparable<Poker> {

  private int num;
  private char suit;

  public Poker() {}

  public Poker(int num, char suit) {
    this.num = num;
    this.suit = suit;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public char getSuit() {
    return suit;
  }

  public void setSuit(char suit) {
    this.suit = suit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Poker poker = (Poker) o;
    return num == poker.num &&
        suit == poker.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(num, suit);
  }

  @Override
  public int compareTo(Poker o) {
    return o.getNum() - this.getNum();
  }
}
