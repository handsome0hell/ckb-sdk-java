package org.nervos.mercury.model.req.payload;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.List;
import org.nervos.mercury.model.req.From;

public class DepositPayload {

  public List<From> from;

  public String to;

  public BigInteger amount;

  @SerializedName("fee_rate")
  public BigInteger feeRate;

  protected DepositPayload() {}
}
