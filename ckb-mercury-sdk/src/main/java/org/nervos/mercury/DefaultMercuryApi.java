package org.nervos.mercury;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.nervos.ckb.service.RpcService;
import org.nervos.mercury.model.common.Claimable;
import org.nervos.mercury.model.common.Fixed;
import org.nervos.mercury.model.common.PaginationResponse;
import org.nervos.mercury.model.common.Status;
import org.nervos.mercury.model.req.lumos.LumosCell;
import org.nervos.mercury.model.req.lumos.LumosTransaction;
import org.nervos.mercury.model.req.lumos.QueryResponse;
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
import org.nervos.mercury.model.resp.TxView;
import org.nervos.mercury.model.resp.info.DBInfo;
import org.nervos.mercury.model.resp.info.MercuryInfo;

public class DefaultMercuryApi implements MercuryApi {

  private RpcService rpcService;
  private Gson g =
      new GsonBuilder()
          .registerTypeAdapter(Status.class, new Claimable(BigInteger.ZERO))
          .registerTypeAdapter(Status.class, new Fixed(BigInteger.ZERO))
          .registerTypeAdapter(TxView.class, new TransactionInfo())
          .registerTypeAdapter(TxView.class, new TransactionView())
          .registerTypeAdapter(QueryResponse.class, new LumosCell())
          .registerTypeAdapter(QueryResponse.class, new LumosTransaction())
          .create();

  public DefaultMercuryApi(String mercuryUrl, boolean isDebug) {
    this.rpcService = new RpcService(mercuryUrl, isDebug);
  }

  public DefaultMercuryApi(RpcService rpcService) {
    this.rpcService = rpcService;
  }

  @Override
  public GetBalanceResponse getBalance(GetBalancePayload payload) throws IOException {

    return this.rpcService.post(
        RpcMethods.GET_BALANCE, Arrays.asList(payload), GetBalanceResponse.class, g);
  }

  @Override
  public TransactionCompletionResponse buildTransferTransaction(TransferPayload payload)
      throws IOException {
    //    List<TransferItem> transferItems =
    //        payload.items.stream()
    //            .filter(x -> Objects.equals(x.to.getClass(), ToKeyAddress.class))
    //            .collect(toList());
    //    if (transferItems.size() > 0) {
    //      if (payload.items.stream().anyMatch(item -> !item.to.isPayByFrom())
    //          && (payload.udtHash == null || payload.udtHash == "")) {
    //        throw new RuntimeException("The transaction does not support ckb");
    //      }
    //    }

    return this.rpcService.post(
        RpcMethods.BUILD_TRANSFER_TRANSACTION,
        Arrays.asList(payload),
        TransactionCompletionResponse.class);
  }

  @Override
  public TransactionCompletionResponse buildSmartTransferTransaction(SmartTransferPayload payload)
      throws IOException {
    return this.rpcService.post(
        RpcMethods.BUILD_SMART_TRANSFER_TRANSACTION,
        Arrays.asList(payload),
        TransactionCompletionResponse.class);
  }

  @Override
  public TransactionCompletionResponse buildAssetAccountCreationTransaction(
      CreateAssetAccountPayload payload) throws IOException {
    return this.rpcService.post(
        RpcMethods.BUILD_ADJUST_ACCOUNT_TRANSACTION,
        Arrays.asList(payload),
        TransactionCompletionResponse.class);
  }

  @Override
  public GetTransactionInfoResponse getTransactionInfo(String txHash) throws IOException {
    return this.rpcService.post(
        RpcMethods.GET_TRANSACTION_INFO, Arrays.asList(txHash), GetTransactionInfoResponse.class);
  }

  @Override
  public BlockInfoResponse getBlockInfo(getBlockInfoPayload payload) throws IOException {
    return this.rpcService.post(
        RpcMethods.GET_BLOCK_INFO, Arrays.asList(payload), BlockInfoResponse.class);
  }

  @Override
  public List<String> registerAddresses(List<String> normalAddresses) throws IOException {
    return this.rpcService.post(
        RpcMethods.REGISTER_ADDRESSES,
        Arrays.asList(normalAddresses),
        new TypeToken<List<String>>() {}.getType());
  }

  @Override
  public <T extends TxView> PaginationResponse<T> queryTransactions(
      QueryTransactionsPayload payload) throws IOException {
    return this.rpcService.post(
        RpcMethods.QUERY_TRANSACTIONS, Arrays.asList(payload), PaginationResponse.class);
  }

  @Override
  public <T extends TxView> T getSpentTransaction(GetSpentTransactionPayload payload)
      throws IOException {
    return this.rpcService.post(
        RpcMethods.GET_SPENT_TRANSACTION, Arrays.asList(payload), Object.class);
  }

  @Override
  public <T extends QueryResponse> PaginationResponse<T> advanceQuery(AdvanceQueryPayload payload)
      throws IOException {
    return this.rpcService.post(RpcMethods.ADVANCE_QUERY, Arrays.asList(payload), Object.class);
  }

  @Override
  public TransactionCompletionResponse buildDepositTransaction(DepositPayload payload)
      throws IOException {
    return this.rpcService.post(
        RpcMethods.BUILD_DEPOSIT_TRANSACTION,
        Arrays.asList(payload),
        TransactionCompletionResponse.class);
  }

  @Override
  public TransactionCompletionResponse buildWithdrawTransaction(WithdrawPayload payload)
      throws IOException {
    return this.rpcService.post(
        RpcMethods.BUILD_WITHDRAW_TRANSACTION,
        Arrays.asList(payload),
        TransactionCompletionResponse.class);
  }

  @Override
  public MercuryInfo getMercuryInfo() throws IOException {
    return this.rpcService.post(RpcMethods.GET_MERCURY_INFO, Arrays.asList(), MercuryInfo.class);
  }

  @Override
  public DBInfo getDbInfo() throws IOException {
    return this.rpcService.post(RpcMethods.GET_DB_INFO, Arrays.asList(), DBInfo.class);
  }
}
