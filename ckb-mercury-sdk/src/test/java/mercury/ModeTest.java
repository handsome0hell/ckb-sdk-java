package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigInteger;
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

public class ModeTest {

  Gson g = new Gson();

  @Test
  void transferCompletionCkbWithPayByFrom() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newCkbAseet());

    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress0()), Source.Free));
    builder.addTo(
        To.newTo(
            AddressWithKeyHolder.testAddress4(),
            Mode.HoldByFrom,
            new BigInteger("100"))); // unit: CKB, 1 CKB = 10^8 Shannon

    System.out.println(new Gson().toJson(builder.build()));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      System.out.println(g.toJson(s));
      Transaction tx = sign(s);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void transferCompletionSudtWithPayByFrom() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newUdtAseet(UdtHolder.UDT_HASH));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByFrom, new BigInteger("100")));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      Transaction tx = sign(s);

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //  @Test
  //  void transferCompletionCkbWithLendByFrom() {
  //    TransferPayloadBuilder builder = new TransferPayloadBuilder();
  //    builder.assetInfo(AssetInfo.newCkbAseet());
  //    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()),
  // Source.Free));
  //    builder.addTo(
  //        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByTo, new BigInteger("100")));
  //
  //    try {
  //      TransactionCompletionResponse s =
  //          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
  //    } catch (Exception e) {
  //      assertEquals("The transaction does not support ckb", e.getMessage());
  //    }
  //  }

  @Test
  void transferCompletionSudtWithLendByFrom() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newUdtAseet(UdtHolder.UDT_HASH));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress2(), Mode.HoldByTo, new BigInteger("100")));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      Transaction tx = sign(s);
      System.out.println(g.toJson(s.txView));

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //  @Test
  //  void transferCompletionCkbWithPayByTo() {
  //    TransferPayloadBuilder builder = new TransferPayloadBuilder();
  //    builder.assetInfo(AssetInfo.newCkbAseet());
  //    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()),
  // Source.Free));
  //    builder.addTo(
  //        To.newTo(AddressWithKeyHolder.testAddress1(), Mode.HoldByFrom, new BigInteger("100")));
  //
  //    try {
  //      TransactionCompletionResponse s =
  //          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
  //    } catch (Exception e) {
  //      assertEquals("The transaction does not support ckb", e.getMessage());
  //    }
  //  }

  @Test
  void transferCompletionSudtWithPayByTo() {
    TransferPayloadBuilder builder = new TransferPayloadBuilder();
    builder.assetInfo(AssetInfo.newUdtAseet(UdtHolder.UDT_HASH));
    builder.addFrom(From.newFrom(new Address(AddressWithKeyHolder.testAddress1()), Source.Free));
    builder.addTo(
        To.newTo(AddressWithKeyHolder.testAddress4(), Mode.HoldByFrom, new BigInteger("100")));

    System.out.println(g.toJson(builder.build()));

    try {
      TransactionCompletionResponse s =
          MercuryApiFactory.getApi().buildTransferTransaction(builder.build());
      Transaction tx = sign(s);
      System.out.println(g.toJson(s.txView));

      String result = CkbNodeFactory.getApi().sendTransaction(tx);
      System.out.println(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Transaction sign(TransactionCompletionResponse s) throws IOException {
    Transaction tx = SignUtils.sign(s);
    return tx;
  }
}
