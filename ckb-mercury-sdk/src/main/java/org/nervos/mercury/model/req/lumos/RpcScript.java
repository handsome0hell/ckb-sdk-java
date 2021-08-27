package org.nervos.mercury.model.req.lumos;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RpcScript {

  @SerializedName("code_hash")
  public String codeHash;

  public List<Byte> args;

  @SerializedName("hash_type")
  public String hashType;

  public RpcScript(String codeHash, List<Byte> args, String hashType) {
    this.codeHash = codeHash;
    this.args = args;
    this.hashType = hashType;
  }
}
