package stationeryms.client;

import stationeryms.common.CommandRead;
import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

public class StationeryMSControl {
  private CommandRead commandRead; // コマンドライン入力値を管理
  public MsgProperties msgProperties; // メッセージプロパティ値を格納

  /**
   * コンストラクタ
   * @throws CommonException
   */
  public StationeryMSControl() throws CommonException {
    this.commandRead = new CommandRead();
    this.msgProperties = new MsgProperties();
  }

  /**
   * ユーザが入力した番号のメニューを実行するメソッド
   */
  public void control() {
    String in = null;

    while(true) {
      // メニュー画面の表示
      System.out.println(MsgProperties.prop.getProperty("TOP_OPERATION"));

      // 標準入力から番号を取得
      try {
        in = this.commandRead.getInputData();
      } catch (CommonException e) {
        // e.printStackTrace();
        System.out.println(e.getMessage());
      }

      // 番号によってメニュー分岐
      if (in.equals("1")) { // 『1』: 在庫照会
        return;
      } else if (in.equals("99")) { // 『99』: 終了
          return;
      } else {               // その他: 再入力
        System.out.println(MsgProperties.prop.getProperty("ERROR_MSG2"));
      }

    }
  }
}
