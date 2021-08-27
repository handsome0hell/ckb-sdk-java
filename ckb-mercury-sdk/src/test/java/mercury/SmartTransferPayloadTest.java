package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigInteger;
import mercury.constant.AddressWithKeyHolder;
import mercury.constant.CkbNodeFactory;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.ckb.type.transaction.Transaction;
import org.nervos.mercury.model.SmartTransferPayloadBuilder;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.req.Mode;
import org.nervos.mercury.model.req.To;
import org.nervos.mercury.model.resp.TransactionCompletionResponse;

public class SmartTransferPayloadTest {
  @Test
  public void testSmartTransferPayload() {
    SmartTransferPayloadBuilder builder = new SmartTransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(AddressWithKeyHolder.testAddress1());
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByFrom, new BigInteger("100")));

    System.out.println(new Gson().toJson(builder.build()));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildSmartTransferTransaction(builder.build());

      Transaction tx = SignUtils.sign(s);

      System.out.println(new Gson().toJson(tx));
      String txHash = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(txHash);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
