package org.nervos.mercury.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import org.nervos.mercury.model.common.PaginationRequest;
import org.nervos.mercury.model.common.Range;
import org.nervos.mercury.model.req.lumos.QueryType;
import org.nervos.mercury.model.req.lumos.RpcScript;
import org.nervos.mercury.model.req.lumos.RpcScriptWrapper;
import org.nervos.mercury.model.req.lumos.ScriptWrapper;
import org.nervos.mercury.model.req.payload.AdvanceQueryPayload;

public class AdvanceQueryPayloadBuilder extends AdvanceQueryPayload {

  public AdvanceQueryPayloadBuilder() {
    this.pagination = new PaginationRequest();
    this.pagination.limit = new BigInteger("50");
    this.pagination.order = PaginationRequest.ORDER_BY_DESC;
    this.pagination.returnCount = Boolean.FALSE;
  }

  public void lock(ScriptWrapper lock) {
    RpcScript script =
        new RpcScript(
            lock.script.codeHash,
            com.google.common.primitives.Bytes.asList(
                lock.script.args.getBytes(StandardCharsets.UTF_8)),
            lock.script.hashType);
    this.lock = new RpcScriptWrapper(script, lock.ioType, lock.argsLen);
  }

  public void type(ScriptWrapper type) {
    RpcScript script =
        new RpcScript(
            type.script.codeHash,
            com.google.common.primitives.Bytes.asList(
                type.script.args.getBytes(StandardCharsets.UTF_8)),
            type.script.hashType);
    this.type = new RpcScriptWrapper(script, type.ioType, type.argsLen);
  }

  public void data(String data) {
    this.data = data;
  }

  public void argsLen(Integer argsLen) {
    this.argsLen = argsLen;
  }

  public void blockRange(Range blockRange) {
    this.blockRange = blockRange;
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

  public void queryType(QueryType queryType) {
    this.queryType = queryType;
  }

  public AdvanceQueryPayload build() {
    return this;
  }
}
