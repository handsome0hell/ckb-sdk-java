package org.nervos.mercury.model.common;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

public class PaginationRequest {

  public static final String ORDER_BY_DESC = "desc";
  public static final String ORDER_BY_ASC = "ASC";

  public BigInteger cursor;
  public String order;
  public BigInteger limit;
  // TODO: 2021/8/26 zhengjianhui
  public BigInteger skip;

  @SerializedName("return_count")
  public Boolean returnCount;
}
