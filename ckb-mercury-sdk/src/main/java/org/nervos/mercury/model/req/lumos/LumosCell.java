package org.nervos.mercury.model.req.lumos;

import com.google.gson.annotations.SerializedName;
import org.nervos.ckb.type.cell.CellOutput;

public class LumosCell implements QueryResponse<CellOutput> {
  @SerializedName("Cell")
  public CellOutput cell;
}
