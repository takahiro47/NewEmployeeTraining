package stationeryms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 標準入力管理
 *
 * @author takahiro
 *
 */
public class CommandRead {

  /**
   * @return 標準入力データ
   * @throws CommonException
   */
  public String getInputData() throws CommonException {
    String message = "";

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    do {
      System.out.print(">>");
      try {
        message = buf.readLine();
      } catch (IOException e) {
        throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG91"));
      }
    } while (message == "");

    return message;
  }
}
