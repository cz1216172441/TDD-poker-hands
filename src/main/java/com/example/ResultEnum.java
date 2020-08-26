package com.example;

public enum ResultEnum {

  TIE("Tie."),
  BLACK_WIN("Black wins."),
  WHITE_WIN("White wins.");

  private String result;

  ResultEnum(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
