package org.nervos.mercury.model;

import java.math.BigInteger;
import org.nervos.mercury.model.req.payload.getBlockInfoPayload;

/** @author zjh @Created Date: 2021/7/20 @Description: @Modify by: */
public class GetBlockInfoPayloadBuilder extends getBlockInfoPayload {

  public void blockNum(BigInteger blockNum) {
    this.blockNum = blockNum;
  }

  public void blockHash(String blockHash) {
    this.blockHash = blockHash;
  }

  public getBlockInfoPayload build() {
    return this;
  }
}
