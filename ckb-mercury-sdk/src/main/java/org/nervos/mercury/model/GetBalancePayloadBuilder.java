package org.nervos.mercury.model;

import java.math.BigInteger;
import java.util.HashSet;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.req.item.Item;
import org.nervos.mercury.model.req.payload.GetBalancePayload;

/** @author zjh @Created Date: 2021/7/16 @Description: @Modify by: */
public class GetBalancePayloadBuilder extends GetBalancePayload {

  public GetBalancePayloadBuilder() {
    this.assetTypes = new HashSet<>(2, 1);
  }

  public void item(Item item) {
    this.item = item;
  }

  public void addAssetInfo(AssetInfo info) {
    this.assetTypes.add(info);
  }

  public void blockNum(BigInteger blockNum) {
    this.blockNum = blockNum;
  }

  public GetBalancePayload build() {
    return this;
  }
}
