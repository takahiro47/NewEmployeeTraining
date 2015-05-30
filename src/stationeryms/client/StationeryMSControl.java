package stationeryms.client;

import stationeryms.common.CommandRead;

public class StationeryMSControl {
  private CommandRead commandRead; // コマンドラインで入力した情報を管理

  /*
   * コンストラクタ
   */
  public StationeryMSControl() {
    this.commandRead = new CommandRead();
  }

  /*
   * ユーザが入力した番号のメニューを実行するメソッド
   */
  public void control() {
    String in;

    while(true) {
      // メニュー画面の表示
      System.out.println("\n トップメニュー::処理を選択してください\n\n[99]終了\n");

      // 標準入力から番号を取得
      in = this.commandRead.getInputData();

      // 番号によってメニュー分岐
      if (in.equals("99")) { // 『99』: 終了
        return;
      } else {               // その他: 再入力
        System.out.println("正しい値を入力してください。");
      }

    }
  }
}
