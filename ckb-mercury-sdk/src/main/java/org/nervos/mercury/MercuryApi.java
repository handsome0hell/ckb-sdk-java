package org.nervos.mercury;

import java.io.IOException;
import java.util.List;
import org.nervos.mercury.model.common.PaginationResponse;
import org.nervos.mercury.model.req.lumos.LumosCell;
import org.nervos.mercury.model.req.lumos.LumosTransaction;
import org.nervos.mercury.model.req.payload.AdvanceQueryPayload;
import org.nervos.mercury.model.req.payload.CreateAssetAccountPayload;
import org.nervos.mercury.model.req.payload.DepositPayload;
import org.nervos.mercury.model.req.payload.GetBalancePayload;
import org.nervos.mercury.model.req.payload.GetSpentTransactionPayload;
import org.nervos.mercury.model.req.payload.QueryTransactionsPayload;
import org.nervos.mercury.model.req.payload.SmartTransferPayload;
import org.nervos.mercury.model.req.payload.TransferPayload;
import org.nervos.mercury.model.req.payload.WithdrawPayload;
import org.nervos.mercury.model.req.payload.getBlockInfoPayload;
import org.nervos.mercury.model.resp.BlockInfoResponse;
import org.nervos.mercury.model.resp.GetBalanceResponse;
import org.nervos.mercury.model.resp.GetTransactionInfoResponse;
import org.nervos.mercury.model.resp.TransactionCompletionResponse;
import org.nervos.mercury.model.resp.TransactionInfo;
import org.nervos.mercury.model.resp.TransactionView;
import org.nervos.mercury.model.resp.info.DBInfo;
import org.nervos.mercury.model.resp.info.MercuryInfo;

public interface MercuryApi {

  GetBalanceResponse getBalance(GetBalancePayload payload) throws IOException;

  TransactionCompletionResponse buildTransferTransaction(TransferPayload payload)
      throws IOException;

  TransactionCompletionResponse buildSmartTransferTransaction(SmartTransferPayload payload)
      throws IOException;

  TransactionCompletionResponse buildAssetAccountCreationTransaction(
      CreateAssetAccountPayload payload) throws IOException;

  GetTransactionInfoResponse getTransactionInfo(String txHash) throws IOException;

  BlockInfoResponse getBlockInfo(getBlockInfoPayload payload) throws IOException;

  List<String> registerAddresses(List<String> normalAddresses) throws IOException;

  PaginationResponse<TransactionView> queryTransactionsWithTransactionView(
      QueryTransactionsPayload payload) throws IOException;

  PaginationResponse<TransactionInfo> queryTransactionsWithTransactionInfo(
      QueryTransactionsPayload payload) throws IOException;

  TransactionView getSpentTransactionWithTransactionView(GetSpentTransactionPayload payload)
      throws IOException;

  TransactionInfo getSpentTransactionWithTransactionInfo(GetSpentTransactionPayload payload)
      throws IOException;

  PaginationResponse<LumosCell> advanceQueryWithCell(AdvanceQueryPayload payload)
      throws IOException;

  PaginationResponse<LumosTransaction> advanceQueryWithCellWithTransaction(
      AdvanceQueryPayload payload) throws IOException;

  TransactionCompletionResponse buildDepositTransaction(DepositPayload payload) throws IOException;

  TransactionCompletionResponse buildWithdrawTransaction(WithdrawPayload payload)
      throws IOException;

  MercuryInfo getMercuryInfo() throws IOException;

  DBInfo getDbInfo() throws IOException;
}
