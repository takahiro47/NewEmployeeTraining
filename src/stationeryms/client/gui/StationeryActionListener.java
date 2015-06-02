package stationeryms.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import stationeryms.action.ReceiptAction;
import stationeryms.action.ShipmentAction;
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
      if (command.equals("reference")) { // 在庫照会
        (new ReferenceView("在庫照会")).setVisible(true);

      } else if (command.equals("subMenu")) { // 入出荷管理メニュー
        (new SubMenuView("入出荷管理メニュー")).setVisible(true);

      } else if (command.equals("receipt")) { // 入荷処理
        // 入力データを収集
        String brandName = ((SubMenuView) this.invoker).getSelectBrand(); // 商品名
        String location = ((SubMenuView) this.invoker).getSelectLocation(); // 保管場所
        int inQt = ((SubMenuView) this.invoker).getSelectQuantity(); // 入出荷量

        // 入荷処理
        ReceiptAction receiptAction = new ReceiptAction();
        receiptAction.quantityCheck(inQt);
        receiptAction.receipt(brandName, location, inQt);

        // 完了表示
        (new FinishView("入荷処理完了")).setVisible(true);

      } else if (command.equals("shipment")) { // 出荷処理
        // 入力データを収集
        String brandName = ((SubMenuView) this.invoker).getSelectBrand(); // 商品名
        String location = ((SubMenuView) this.invoker).getSelectLocation(); // 保管場所
        int inQt = ((SubMenuView) this.invoker).getSelectQuantity(); // 入出荷量

        // 入荷処理
        ShipmentAction shipmentAction = new ShipmentAction();
        shipmentAction.quantityCheck(inQt);
        shipmentAction.shipment(brandName, location, inQt);

        // 完了表示
        (new FinishView("出荷処理完了")).setVisible(true);

      } else if (command.equals("top")) { // トップページ
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
