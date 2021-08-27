package org.nervos.mercury.model.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.math.BigInteger;

public abstract class Status implements JsonSerializer<Status>, JsonDeserializer<Status> {
  @Override
  public Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (json.getAsJsonObject().has("Claimable")) {
      return new Claimable(new BigInteger(json.getAsJsonObject().get("Claimable").getAsString()));
    } else {
      return new Fixed(new BigInteger(json.getAsJsonObject().get("Fixed").getAsString()));
    }
  }

  @Override
  public JsonElement serialize(Status src, Type typeOfSrc, JsonSerializationContext context) {
    return context.serialize(src, src.getClass());
  }
}
