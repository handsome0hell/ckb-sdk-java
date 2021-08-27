package org.nervos.mercury.model.req.payload;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.common.ExtraFilter;
import org.nervos.mercury.model.common.PaginationRequest;
import org.nervos.mercury.model.common.Range;
import org.nervos.mercury.model.req.ViewType;
import org.nervos.mercury.model.req.item.Item;

/** @author zjh @Created Date: 2021/7/26 @Description: @Modify by: */
public class QueryTransactionsPayload {

  public Item item;

  public Set<AssetInfo> assets;

  @SerializedName("extra_filter")
  public ExtraFilter extraFilter;

  @SerializedName("block_range")
  public Range blockRange;

  public PaginationRequest pagination;

  @SerializedName("view_type")
  public ViewType viewType;

  protected QueryTransactionsPayload() {}
}
