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

public class TransferCompletionTest {

  Gson g = new Gson();

  @Test
  void testSingleFromSingleTo() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByFrom, new BigInteger("100")));

    try {
      sendTx(builder);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testSingleFromMultiTo() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByFrom, new BigInteger("100")));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress3(), Mode.HoldByFrom, new BigInteger("100")));

    try {
      sendTx(builder);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testMultiFromSingleTo() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress2()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress3(), Mode.HoldByFrom, new BigInteger("100")));

    System.out.println(g.toJson(builder.build()));

    try {
      sendTx(builder);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testMultiFromMultiTo() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress2()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress3(), Mode.HoldByFrom, new BigInteger("100")));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress4(), Mode.HoldByFrom, new BigInteger("100")));

    System.out.println(g.toJson(builder.build()));

    try {
      sendTx(builder);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sendTx(TransferPayloadBuilder builder) throws IOException {
    TransactionCompletionResponse s =
        MercuryApiFactory.getApi().buildTransferTransaction(builder.build());

    Transaction tx = SignUtils.sign(s);

    System.out.println(g.toJson(tx));
    String txHash = CkbNodeFactory.getApi().sendTransaction(tx);
    System.out.println(txHash);
  }
}
