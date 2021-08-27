package org.nervos.mercury.model;

import java.math.BigInteger;
import java.util.ArrayList;
import org.nervos.mercury.FeeConstant;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.req.To;
import org.nervos.mercury.model.req.payload.SmartTransferPayload;
import org.nervos.mercury.model.req.since.SinceConfig;

public class SmartTransferPayloadBuilder extends SmartTransferPayload {
  public SmartTransferPayloadBuilder() {
    this.feeRate = FeeConstant.DEFAULT_FEE_RATE;
    this.from = new ArrayList<>(1);
    this.to = new ArrayList<>(1);
  }

  public void addFrom(String address) {
    this.from.add(address);
  }

  public void assetInfo(AssetInfo assetInfo) {
    this.assetInfo = assetInfo;
  }

  public void addTo(To to) {
    this.to.add(to);
  }

  public void change(String change) {
    this.change = change;
  }

  public void feeRate(BigInteger feeRate) {
    this.feeRate = feeRate;
  }

  public void since(SinceConfig since) {
    this.since = since;
  }

  public SmartTransferPayload build() {
    assert !(this.from == null) : "from not null";
    assert !(this.to.size() <= 0) : "items not empty";

    return this;
  }
}
