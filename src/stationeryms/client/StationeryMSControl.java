package stationeryms.client;

import stationeryms.action.ReceiptAction;
import stationeryms.action.ReferenceAction;
import stationeryms.common.CommandRead;
import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

/**
 * 文房具管理アプリケーションの処理フローの分岐
 *
 * @author takahiro
 *
 */
public class StationeryMSControl {
  private CommandRead commandRead; // コマンドライン入力値を管理
  public MsgProperties msgProperties; // メッセージプロパティ値を格納

  /**
   * コンストラクタ
   *
   * @throws CommonException
   */
  public StationeryMSControl() throws CommonException {
    this.commandRead = new CommandRead();
    this.msgProperties = new MsgProperties();
  }

  /**
   * ユーザが入力した番号に対応したアクションクラスをインスタンス化し、その処理を行う。
   */
  public void control() {
    String in = null;

    while (true) {
      // メニュー画面の表示
      System.out.println(MsgProperties.prop.getProperty("TOP_OPERATION"));

      // 標準入力から番号を取得
      try {
        in = this.commandRead.getInputData();
      } catch (CommonException e) {
        System.out.println(e.getMessage());
      }

      // 番号によってメニュー分岐
      if (in.equals("1")) { // 『1』: 在庫照会処理
        try {
          (new ReferenceAction()).exec();
        } catch (CommonException e) {
          e.printStackTrace();
        }
      } else if (in.equals("2")) { // 『2』: 入荷処理
        try {
          (new ReceiptAction()).exec(this.commandRead);
        } catch (CommonException e) {
          e.printStackTrace();
        }
      } else if (in.equals("99")) { // 『99』: 終了
        return;
      } else { // その他: 再入力
        System.out.println(MsgProperties.prop.getProperty("ERROR_MSG2"));
      }

    }
  }
}
