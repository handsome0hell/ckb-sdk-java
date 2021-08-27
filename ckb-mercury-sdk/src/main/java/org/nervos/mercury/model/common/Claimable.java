package org.nervos.mercury.model.common;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

public class Claimable extends Status {
  @SerializedName("Claimable")
  public BigInteger claimable;

  public Claimable(BigInteger claimable) {
    this.claimable = claimable;
  }
}
