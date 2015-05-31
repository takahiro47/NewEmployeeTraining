package stationeryms.client.gui;

/**
 * GUIクライアントの起動クラス
 *
 * @author takahiro
 *
 */
public class MainGuiApp {
  public static void main(String[] args) {
    (new TopView("文房具在庫管理システム")).setVisible(true);
  }
}
