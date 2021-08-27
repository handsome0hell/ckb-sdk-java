package org.nervos.mercury.model.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Objects;

public class ExtraFilter implements JsonSerializer<ExtraFilter>, JsonDeserializer<ExtraFilter> {
  public ExtraFilterType type;
  public DaoInfo daoInfo;

  @Override
  public ExtraFilter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    if (json.isJsonPrimitive()
        && Objects.equals(json.getAsString(), ExtraFilterType.CellBase.toString())) {
      ExtraFilter extraFilter = new ExtraFilter();
      extraFilter.type = ExtraFilterType.CellBase;
      return extraFilter;
    } else {

      return RpcExtraFilter.toExtraFilter(json);
    }
  }

  @Override
  public JsonElement serialize(ExtraFilter src, Type typeOfSrc, JsonSerializationContext context) {

    if (Objects.equals(src.type, ExtraFilterType.CellBase)) {
      return new JsonPrimitive(ExtraFilterType.CellBase.toString());
    } else {
      return context.serialize(RpcExtraFilter.build(src));
    }
  }

  static class RpcExtraFilter {
    public RpcDaoInfo Dao;

    public static RpcExtraFilter build(ExtraFilter src) {
      RpcDaoState state;
      if (Objects.equals(src.daoInfo.state, DaoState.Deposit)) {
        state = new RpcDeposit(src.daoInfo.blockNumber);
      } else {
        state = new RpcWithdraw(src.daoInfo.blockNumber);
      }

      RpcDaoInfo info = new RpcDaoInfo();
      info.reward = src.daoInfo.reward;
      info.state = state;

      RpcExtraFilter e = new RpcExtraFilter();
      e.Dao = info;

      return e;
    }

    public static ExtraFilter toExtraFilter(JsonElement json) {
      JsonObject filter = json.getAsJsonObject();
      JsonObject dao = filter.getAsJsonObject("Dao");
      JsonObject state = dao.getAsJsonObject("state");

      DaoInfo info = new DaoInfo();
      if (state.has("Deposit")) {
        info.state = DaoState.Deposit;
        info.blockNumber = state.get("Deposit").getAsBigInteger();
      } else {
        info.state = DaoState.Withdraw;
        info.blockNumber = state.get("Withdraw").getAsBigInteger();
      }

      info.reward = dao.get("reward").getAsBigInteger();

      ExtraFilter e = new ExtraFilter();
      e.type = ExtraFilterType.Dao;
      e.daoInfo = info;

      return e;
    }
  }

  static class RpcDaoInfo {
    public RpcDaoState state;
    public BigInteger reward;
  }

  interface RpcDaoState {}

  static class RpcDeposit implements RpcDaoState {
    public BigInteger Deposit;

    public RpcDeposit() {}

    public RpcDeposit(BigInteger deposit) {
      Deposit = deposit;
    }
  }

  static class RpcWithdraw implements RpcDaoState {
    public BigInteger Withdraw;

    public RpcWithdraw() {}

    public RpcWithdraw(BigInteger withdraw) {
      Withdraw = withdraw;
    }
  }
}
