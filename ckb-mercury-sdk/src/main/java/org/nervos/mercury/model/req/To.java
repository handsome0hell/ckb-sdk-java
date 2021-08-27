package org.nervos.mercury.model.req;

import java.math.BigInteger;

public class To {
  public String address;
  public Mode mode;
  public BigInteger amount;

  private To(String address, Mode mode, BigInteger amount) {
    this.address = address;
    this.mode = mode;
    this.amount = amount;
  }

  public static To newTo(String address, Mode mode, BigInteger amount) {
    return new To(address, mode, amount);
  }
}
