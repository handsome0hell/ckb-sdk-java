package org.nervos.mercury.model.req.lumos;

import com.google.gson.annotations.SerializedName;
import org.nervos.ckb.type.transaction.TransactionWithStatus;

public class LumosTransaction implements QueryResponse<TransactionWithStatus> {
  @SerializedName("Transaction")
  public TransactionWithStatus transaction;
}
