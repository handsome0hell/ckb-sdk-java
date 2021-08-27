package org.nervos.mercury.model.common;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

public class DaoInfo {

  @SerializedName("BlockNumber")
  public BigInteger blockNumber;

  public DaoState state;

  public BigInteger reward;
}
