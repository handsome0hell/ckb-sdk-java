package mercury.normal;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigInteger;
import mercury.SignUtils;
import mercury.constant.AddressWithKeyHolder;
import mercury.constant.CkbNodeFactory;
import mercury.constant.MercuryApiFactory;
import mercury.constant.UdtHolder;
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

/** @author zjh @Created Date: 2021/7/23 @Description: @Modify by: */
public class AcpTest {
  String acpAddress = "ckt1qyp07nuu3fpu9rksy677uvchlmyv9ce5saes824qjq";
  String key = "0x6aa38b72d55efc781c0c2bedcbd8adba2c946d90c1075189749d5049301ca84a";

  @Test
  void testFromAcp() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newUdtAseet(UdtHolder.UDT_HASH));
    builder.addFrom(From.newFrom(new Address(acpAddress), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByFrom, new BigInteger("100")));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      System.out.println(new Gson().toJson(s));
      Transaction tx = SignUtils.signByKey(s, key);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testToAcp() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newUdtAseet(UdtHolder.UDT_HASH));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress0()), Source.Free));
    builder.addTo(To.newTo(acpAddress, Mode.HoldByFrom, new BigInteger("100")));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      System.out.println(new Gson().toJson(s));
      Transaction tx = SignUtils.sign(s);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
