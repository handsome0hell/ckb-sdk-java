package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.ckb.type.OutPoint;
import org.nervos.mercury.model.GetSpentTransactionPayloadBuilder;
import org.nervos.mercury.model.req.ViewType;
import org.nervos.mercury.model.resp.TransactionView;

public class getSpentTransactionTest {

  @Test
  public void testGetSpentTransaction() {
    GetSpentTransactionPayloadBuilder builder = new GetSpentTransactionPayloadBuilder();
    builder.outpoint(
        new OutPoint("0xbaea5058401c63e1eaaf33ef9155afaf6c57be038e8599f1d4e59fb24b63e512", "0"));
    builder.viewType(ViewType.TransactionView);

    System.out.println(new Gson().toJson(builder.build()));

    TransactionView view = null;
    try {
      view = MercuryApiFactory.getApi().getSpentTransactionWithTransactionView(builder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(new Gson().toJson(view));
  }
}
