package org.nervos.mercury.model.req.payload;

import com.google.gson.annotations.SerializedName;
import org.nervos.ckb.type.OutPoint;
import org.nervos.mercury.model.req.ViewType;

public class GetSpentTransactionPayload {
  public OutPoint outpoint;

  @SerializedName("view_type")
  public ViewType viewType;
}
