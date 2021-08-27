package org.nervos.mercury.model;

import java.math.BigInteger;
import java.util.HashSet;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.common.ExtraFilter;
import org.nervos.mercury.model.common.PaginationRequest;
import org.nervos.mercury.model.common.Range;
import org.nervos.mercury.model.req.ViewType;
import org.nervos.mercury.model.req.item.Item;
import org.nervos.mercury.model.req.payload.QueryTransactionsPayload;

/** @author zjh @Created Date: 2021/7/26 @Description: @Modify by: */
public class QueryTransactionsPayloadBuilder extends QueryTransactionsPayload {

  public QueryTransactionsPayloadBuilder() {
    this.assets = new HashSet<>(2, 1);
    this.viewType = ViewType.TransactionView;
    this.pagination = new PaginationRequest();
    this.pagination.limit = new BigInteger("50");
    this.pagination.order = PaginationRequest.ORDER_BY_DESC;
    this.pagination.returnCount = Boolean.FALSE;
  }

  public void item(Item item) {
    this.item = item;
  }

  public void addAssetInfo(AssetInfo info) {
    this.assets.add(info);
  }

  public void range(Range range) {
    this.blockRange = range;
  }

  public void limit(BigInteger limit) {
    this.pagination.limit = limit;
  }

  public void cursor(BigInteger cursor) {
    this.pagination.cursor = cursor;
  }

  public void order(String order) {
    this.pagination.order = order;
  }

  public void skip(BigInteger skip) {
    this.pagination.skip = skip;
  }

  public void returnCount(Boolean returnCount) {
    this.pagination.returnCount = returnCount;
  }

  public void extraFilter(ExtraFilter extraFilter) {
    this.extraFilter = extraFilter;
  }

  public void viewType(ViewType viewType) {
    this.viewType = viewType;
  }

  public QueryTransactionsPayload build() {
    return this;
  }
}
