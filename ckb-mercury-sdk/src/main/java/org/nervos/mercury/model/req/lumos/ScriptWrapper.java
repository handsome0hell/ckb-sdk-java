package org.nervos.mercury.model.req.lumos;

import com.google.gson.annotations.SerializedName;
import org.nervos.ckb.type.Script;

public class ScriptWrapper {

  public Script script;

  @SerializedName("io_type")
  public IOType ioType;

  @SerializedName("args_len")
  public Integer argsLen;

  public ScriptWrapper(Script script) {
    this.script = script;
  }

  public ScriptWrapper(Script script, IOType ioType, Integer argsLen) {
    this.script = script;
    this.ioType = ioType;
    this.argsLen = argsLen;
  }
}
