package org.nervos.mercury.model.resp;

import org.nervos.ckb.type.transaction.TransactionWithStatus;

/** @author zjh @Created Date: 2021/7/20 @Description: @Modify by: */
public class GetTransactionInfoResponse {

  public TransactionInfoResponse transaction;

  // TODO: 2021/8/26 zhengjianhui Replenishment Status
  public TransactionWithStatus.Status status;

  public Integer reason;
}
