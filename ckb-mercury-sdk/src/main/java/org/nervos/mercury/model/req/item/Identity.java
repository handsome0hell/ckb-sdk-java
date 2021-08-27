package org.nervos.mercury.model.req.item;

import com.google.gson.annotations.SerializedName;

public class Identity implements Item {
  @SerializedName("Identity")
  public String identity;
}
