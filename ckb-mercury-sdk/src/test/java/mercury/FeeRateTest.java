package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigInteger;
import mercury.constant.AddressWithKeyHolder;
import mercury.constant.CkbNodeFactory;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.ckb.type.transaction.Transaction;
import org.nervos.mercury.model.TransferPayloadBuilder;
import org.nervos.mercury.model.common.AssetInfo;
import org.nervos.mercury.model.req.From;
import org.nervos.mercury.model.req.Mode;
import org.nervos.mercury.model.req.Source;
import org.nervos.mercury.model.req.To;
import org.nervos.mercury.model.req.item.Address;
import org.nervos.mercury.model.resp.TransactionCompletionResponse;

public class FeeRateTest {
  Gson g = new Gson();

  @Test
  void defaultFeeRate() {

    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress0()), Source.Free));
    builder.addTo(
        To.newTo(
            AddressWithKeyHolder.testAddress4(),
            Mode.HoldByFrom,
            new BigInteger("100"))); // unit: CKB, 1 CKB = 10^8 Shannon
    // default 1000 shannons/KB
    //    builder.feeRate(new BigInteger("1000"));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      System.out.println(g.toJson(s));

      Transaction tx = SignUtils.sign(s);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void customizedFeeRate() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress0()), Source.Free));
    builder.addTo(
        To.newTo(
            AddressWithKeyHolder.testAddress4(),
            Mode.HoldByFrom,
            new BigInteger("100"))); // unit: CKB, 1 CKB = 10^8 Shannon
    builder.feeRate(new BigInteger("10000"));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      System.out.println(g.toJson(s));

      Transaction tx = SignUtils.sign(s);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
