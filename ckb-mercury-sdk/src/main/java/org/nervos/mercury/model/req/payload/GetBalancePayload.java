package org.nervos.mercury.model.req.payload;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.Set;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.req.item.Item;

/** @author zjh @Created Date: 2021/7/16 @Description: @Modify by: */
public class GetBalancePayload {
  public Item item;

  @SerializedName("asset_types")
  public Set<AssetInfo> assetTypes;

  @SerializedName("block_num")
  public BigInteger blockNum;

  protected GetBalancePayload() {}
}
