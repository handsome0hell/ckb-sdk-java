package org.nervos.mercury.model.req.payload;

import com.google.gson.annotations.SerializedName;
import org.nervos.mercury.model.common.PaginationRequest;
import org.nervos.mercury.model.common.Range;
import org.nervos.mercury.model.req.lumos.QueryType;
import org.nervos.mercury.model.req.lumos.RpcScriptWrapper;

public class AdvanceQueryPayload {

  @SerializedName("lock")
  public RpcScriptWrapper lock;

  @SerializedName("type_")
  public RpcScriptWrapper type;

  public String data;

  @SerializedName("args_len")
  public Integer argsLen;

  @SerializedName("block_range")
  public Range blockRange;

  public PaginationRequest pagination;

  @SerializedName("query_type")
  public QueryType queryType;
}
