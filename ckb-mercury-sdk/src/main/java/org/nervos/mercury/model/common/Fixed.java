package org.nervos.mercury.model.common;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

public class Fixed extends Status {
  @SerializedName("Fixed")
  public BigInteger fixed;

  public Fixed(BigInteger fixed) {
    this.fixed = fixed;
  }
}
