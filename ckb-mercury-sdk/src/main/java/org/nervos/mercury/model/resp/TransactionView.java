package org.nervos.mercury.model.resp;

import org.nervos.ckb.type.transaction.TransactionWithStatus;

public class TransactionView implements TxView<TransactionWithStatus> {
  public TransactionWithStatus transactionView;
}
