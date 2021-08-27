package org.nervos.mercury.model.req.item;

import com.google.gson.annotations.SerializedName;

public class Record implements Item {
  @SerializedName("Record")
  public String record;
}
