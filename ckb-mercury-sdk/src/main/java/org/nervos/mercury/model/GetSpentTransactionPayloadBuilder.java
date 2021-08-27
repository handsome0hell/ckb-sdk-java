package org.nervos.mercury.model;

import org.nervos.ckb.type.OutPoint;
import org.nervos.mercury.model.req.ViewType;
import org.nervos.mercury.model.req.payload.GetSpentTransactionPayload;

public class GetSpentTransactionPayloadBuilder extends GetSpentTransactionPayload {

  public void outpoint(OutPoint outpoint) {
    this.outpoint = outpoint;
  }

  public void viewType(ViewType viewType) {
    this.viewType = viewType;
  }

  public GetSpentTransactionPayload build() {
    return this;
  }
}
