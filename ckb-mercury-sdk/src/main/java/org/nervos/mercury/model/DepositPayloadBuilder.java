package org.nervos.mercury.model;

import java.math.BigInteger;
import java.util.ArrayList;
import org.nervos.mercury.FeeConstant;
import org.nervos.mercury.model.req.From;
import org.nervos.mercury.model.req.Source;
import org.nervos.mercury.model.req.item.Item;
import org.nervos.mercury.model.req.payload.DepositPayload;

public class DepositPayloadBuilder extends DepositPayload {
  public DepositPayloadBuilder() {
    this.from = new ArrayList<>(1);
    this.feeRate = FeeConstant.DEFAULT_FEE_RATE;
  }

  public void addFrom(Item item, Source source) {
    From from = new From(item, source);
    this.from.add(from);
  }

  public void to(String to) {
    this.to = to;
  }

  public void amount(BigInteger amount) {
    this.amount = amount;
  }

  public void feeRate(BigInteger feeRate) {
    this.feeRate = feeRate;
  }

  public DepositPayload build() {
    return this;
  }
}
