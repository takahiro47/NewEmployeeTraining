package stationeryms.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

/**
 * すべてのフレームで発生するイベントを処理する
 *
 * @author takahiro
 *
 */
public class StationeryActionListener implements ActionListener {
  /*
   * フィールド
   */
  private JFrame invoker; // 呼び出し元フレーム
  @SuppressWarnings("unused")
  private MsgProperties msgProperties; // プロパティ

  /**
   * コンストラクタ
   *
   * @param jFrame
   */
  public StationeryActionListener(JFrame jFrame) {
    this.invoker = jFrame;
    try {
      msgProperties = new MsgProperties();
    } catch (CommonException e) {
      e.printStackTrace();
    }
  }

  /**
   * イベント処理
   */
  @Override
  public void actionPerformed(ActionEvent ae) {
    // 実行されたコマンドを取得
    String command = ae.getActionCommand();

    try {
      // イベントの処理
      if (command.equals("reference")) {
        (new ReferenceView("在庫照会")).setVisible(true);
      } else if (command.equals("subMenu")) {
        // TODO
      } else if (command.equals("receipt")) {
        // TODO
      } else if (command.equals("shipment")) {
        // TODO
      } else if (command.equals("top")) {
        (new TopView("文房具在庫管理システム")).setVisible(true);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 呼び出し元の画面を非表示にする
      this.invoker.setVisible(false);
    }
  }

}
