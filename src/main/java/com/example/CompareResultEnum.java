package com.example;

public enum CompareResultEnum {

  TIE("Tie.", 0),
  BLACK_WIN("Black wins.", 1),
  WHITE_WIN("White wins.", -1);

  private String result;
  private int value;

  CompareResultEnum(String result, int value) {
    this.result = result;
    this.value = value;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
