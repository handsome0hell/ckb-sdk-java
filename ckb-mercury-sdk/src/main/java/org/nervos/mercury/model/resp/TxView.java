package org.nervos.mercury.model.resp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public abstract class TxView implements JsonSerializer<TxView>, JsonDeserializer<TxView> {

  @Override
  public TxView deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    if (json.getAsJsonObject().has("TransactionView")) {
      return context.deserialize(
          json.getAsJsonObject().get("TransactionView"), TransactionView.class);
    } else {
      return context.deserialize(
          json.getAsJsonObject().get("TransactionInfo"), TransactionInfo.class);
    }
  }

  @Override
  public JsonElement serialize(TxView src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src, src.getClass());
  }
}
