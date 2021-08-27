package org.nervos.mercury.model.common;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.List;

public class Record {

  public List<Byte> id;

  public String address;

  public BigInteger amount;

  @SerializedName("asset_info")
  public AssetInfo assetInfo;

  public RecordStatus recordStatus;

  public ExtraFilter extra;
}
