package org.nervos.mercury.model;

import java.math.BigInteger;
import org.nervos.mercury.FeeConstant;
import org.nervos.mercury.model.req.item.Item;
import org.nervos.mercury.model.req.payload.WithdrawPayload;

public class WithdrawPayloadBuilder extends WithdrawPayload {

  public WithdrawPayloadBuilder() {
    this.feeRate = FeeConstant.DEFAULT_FEE_RATE;
  }

  public void from(Item item) {
    this.from = item;
  }

  public void payFee(Item payFee) {
    this.payFee = payFee;
  }

  public void feeRate(BigInteger feeRate) {
    this.feeRate = feeRate;
  }

  public WithdrawPayload build() {
    return this;
  }
}
