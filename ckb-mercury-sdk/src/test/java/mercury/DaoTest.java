package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import java.math.BigInteger;
import mercury.constant.AddressWithKeyHolder;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.mercury.model.DepositPayloadBuilder;
import org.nervos.mercury.model.WithdrawPayloadBuilder;
import org.nervos.mercury.model.req.Source;
import org.nervos.mercury.model.req.item.Address;
import org.nervos.mercury.model.resp.TransactionCompletionResponse;

public class DaoTest {

  @Test
  public void testDeposit() {
    DepositPayloadBuilder builder = new DepositPayloadBuilder();
    builder.addFrom(new Address(AddressWithKeyHolder.testAddress3()), Source.Free);
    //    builder.to(AddressWithKeyHolder.testAddress4());
    builder.amount(new BigInteger("100"));

    System.out.println(new Gson().toJson(builder));

    TransactionCompletionResponse transactionCompletionResponse = null;
    try {
      transactionCompletionResponse =
          MercuryApiFactory.getApi().buildDepositTransaction(builder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(new Gson().toJson(transactionCompletionResponse));
  }

  @Test
  public void testWithdraw() {
    WithdrawPayloadBuilder builder = new WithdrawPayloadBuilder();
    builder.from(new Address(AddressWithKeyHolder.testAddress3()));
    builder.payFee(new Address(AddressWithKeyHolder.testAddress4()));

    System.out.println(new Gson().toJson(builder));

    TransactionCompletionResponse transactionCompletionResponse = null;
    try {
      transactionCompletionResponse =
          MercuryApiFactory.getApi().buildWithdrawTransaction(builder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(new Gson().toJson(transactionCompletionResponse));
  }
}
