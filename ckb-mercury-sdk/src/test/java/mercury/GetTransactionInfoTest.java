package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.mercury.model.resp.GetTransactionInfoResponse;

/** @author zjh @Created Date: 2021/7/20 @Description: @Modify by: */
public class GetTransactionInfoTest {

  @Test
  void testGetGenericTransaction() {
    try {
      GetTransactionInfoResponse genericTransaction =
          MercuryApiFactory.getApi()
              .getTransactionInfo(
                  "0x4329e4c751c95384a51072d4cbc9911a101fd08fc32c687353d016bf38b8b22c");

      System.out.println(new Gson().toJson(genericTransaction));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
