package org.nervos.mercury.model.resp;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import org.nervos.mercury.model.common.AssetInfo;

/** @author zjh @Created Date: 2021/7/16 @Description: @Modify by: */
public class BalanceResponse {

  @SerializedName("address")
  public String address;

  @SerializedName("asset_info")
  public AssetInfo assetInfo;

  public BigInteger free;

  public BigInteger occupied;

  public BigInteger feddzed;

  public BigInteger claimable;
}
