package stationeryms.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandRead {

  /*
   * 標準入力データを取得し、呼び出し元に返すメソッド
   */
  public String getInputData() {
    String message = "";

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    do {
      System.out.print(">>");
      try {
        message = buf.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } while (message == "");

    return message;
  }
}
