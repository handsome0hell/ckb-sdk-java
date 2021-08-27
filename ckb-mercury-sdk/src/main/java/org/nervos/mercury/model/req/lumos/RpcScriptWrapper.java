package org.nervos.mercury.model.req.lumos;

import com.google.gson.annotations.SerializedName;

public class RpcScriptWrapper {

  public RpcScript script;

  @SerializedName("io_type")
  public IOType ioType;

  @SerializedName("args_len")
  public Integer argsLen;

  public RpcScriptWrapper(RpcScript script, IOType ioType, Integer argsLen) {
    this.script = script;
    this.ioType = ioType;
    this.argsLen = argsLen;
  }
}
