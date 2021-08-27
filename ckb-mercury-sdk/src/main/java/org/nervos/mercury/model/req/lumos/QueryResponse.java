package org.nervos.mercury.model.req.lumos;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public abstract class QueryResponse
    implements JsonSerializer<QueryResponse>, JsonDeserializer<QueryResponse> {

  @Override
  public QueryResponse deserialize(
      JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (json.getAsJsonObject().has("Cell")) {
      return context.deserialize(json.getAsJsonObject().get("Cell"), LumosCell.class);
    } else {
      return context.deserialize(json.getAsJsonObject().get("Cell"), LumosTransaction.class);
    }
  }

  @Override
  public JsonElement serialize(
      QueryResponse src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src, src.getClass());
  }
}
