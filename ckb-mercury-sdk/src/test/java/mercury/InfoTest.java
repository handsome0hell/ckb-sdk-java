package mercury;

import com.google.gson.Gson;
import java.io.IOException;
import mercury.constant.MercuryApiFactory;
import org.junit.jupiter.api.Test;
import org.nervos.mercury.model.resp.info.DBInfo;
import org.nervos.mercury.model.resp.info.MercuryInfo;

public class InfoTest {

  @Test
  public void testMercuryInfo() {
    MercuryInfo mercuryInfo = null;
    try {
      mercuryInfo = MercuryApiFactory.getApi().getMercuryInfo();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(new Gson().toJson(mercuryInfo));
  }

  @Test
  public void testDbInfo() {
    DBInfo dbInfo = null;
    try {
      dbInfo = MercuryApiFactory.getApi().getDbInfo();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(new Gson().toJson(dbInfo));
  }
}
