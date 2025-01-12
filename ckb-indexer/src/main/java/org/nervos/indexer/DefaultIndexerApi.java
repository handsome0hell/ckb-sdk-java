package org.nervos.indexer;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.nervos.ckb.service.RpcService;
import org.nervos.indexer.model.SearchKey;
import org.nervos.indexer.model.resp.CellCapacityResponse;
import org.nervos.indexer.model.resp.CellsResponse;
import org.nervos.indexer.model.resp.TipResponse;
import org.nervos.indexer.model.resp.TransactionResponse;

public class DefaultIndexerApi implements CkbIndexerApi {

  protected RpcService rpcService;

  private Gson gson = new Gson();

  public DefaultIndexerApi(String mercuryUrl, boolean isDebug) {
    this.rpcService = new RpcService(mercuryUrl, isDebug);
  }

  public DefaultIndexerApi(RpcService rpcService) {
    this.rpcService = rpcService;
  }

  @Override
  public TipResponse getTip() throws IOException {
    return this.rpcService.post(CkbIndexerRpcMethods.GET_TIP, Arrays.asList(), TipResponse.class);
  }

  @Override
  public CellsResponse getCells(SearchKey searchKey, String order, String limit, String afterCursor)
      throws IOException {
    return this.rpcService.post(
        CkbIndexerRpcMethods.GET_CELLS,
        Arrays.asList(searchKey, order, limit, afterCursor),
        CellsResponse.class);
  }

  @Override
  public TransactionResponse getTransactions(
      SearchKey searchKey, String order, String limit, String afterCursor) throws IOException {
    return this.rpcService.post(
        CkbIndexerRpcMethods.GET_TRANSACTIONS,
        Arrays.asList(searchKey, order, limit, afterCursor),
        TransactionResponse.class);
  }

  @Override
  public CellCapacityResponse getCellsCapacity(SearchKey searchKey) throws IOException {
    return this.rpcService.post(
        CkbIndexerRpcMethods.GET_CELLS_CAPACITY,
        Arrays.asList(searchKey),
        CellCapacityResponse.class);
  }
}
