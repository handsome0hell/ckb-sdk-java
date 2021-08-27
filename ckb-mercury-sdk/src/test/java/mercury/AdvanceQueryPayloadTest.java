package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.ckb.type.Script;
import org.nervos.mercury.model.AdvanceQueryPayloadBuilder;
import org.nervos.mercury.model.common.PaginationResponse;
import org.nervos.mercury.model.req.lumos.LumosCell;
import org.nervos.mercury.model.req.lumos.QueryType;
import org.nervos.mercury.model.req.lumos.ScriptWrapper;

public class AdvanceQueryPayloadTest {

  @Test
  public void testAdvanceQueryPayload() {
    AdvanceQueryPayloadBuilder builder = new AdvanceQueryPayloadBuilder();
    builder.lock(
        new ScriptWrapper(
            new Script(
                "0x9bd7e06f3ecf4be0f2fcd2188b23f1b9fcc88e5d4b65a8637b17723bbda3cce8",
                "0xa3b8598e1d53e6c5e89e8acb6b4c34d3adb13f2b",
                Script.TYPE)));

    builder.queryType(QueryType.Transaction);

    System.out.println(new Gson().toJson(builder.build()));

    try {
      PaginationResponse<LumosCell> cells =
          MercuryApiFactory.getApi().advanceQueryWithCell(builder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
