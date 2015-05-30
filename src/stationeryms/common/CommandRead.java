package stationeryms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class CommandRead {

  /*
   * 標準入力データを取得し、呼び出し元に返すメソッド
   */
  public String getInputData() throws CommonException {
    String message = "";

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    do {
      System.out.print(">>");
      try {
        message = buf.readLine();
      } catch (IOException e) {
        // e.printStackTrace();
        throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG91"));
      }
    } while (message == "");

    return message;
  }
}
