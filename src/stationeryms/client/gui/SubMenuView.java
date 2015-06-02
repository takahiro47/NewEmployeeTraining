package stationeryms.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

/**
 * 入出荷処理フレーム
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class SubMenuView extends OriginalFrame {
  /*
   * フィールド
   */
  private JComboBox<String> brand; // 商品名セレクタ
  private JComboBox<String> location; // 保管場所セレクタ
  private JTextField quantity; // 入出荷量フィールド

  /**
   * コンストラクタ
   *
   * @param title
   *          フレームタイトル
   */
  public SubMenuView(String title) {
    // フレームタイトルの設定
    super(title);

    /* コンテナパネルの作成 */

    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new BorderLayout());

    /* 情報入力パネルの作成 */

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(3, 2));

    // ラベルの作成
    inputPanel.add(new JLabel("商品を選択して下さい"));

    // コンボボックスの作成
    String[] brandNameItems = { "鉛筆", "ノート", "消しゴム" };
    this.brand = this.createJComboBoxFromStringArray(brandNameItems);
    inputPanel.add(this.brand);

    // ラベルの作成
    inputPanel.add(new JLabel("場所を選択して下さい"));

    // コンボボックスの作成
    String[] locationItems = { "東京", "千葉", "埼玉" };
    this.location = this.createJComboBoxFromStringArray(locationItems);
    inputPanel.add(this.location);

    // ラベルの作成
    inputPanel.add(new JLabel("数量を選択して下さい"));

    // テキストフィールドの作成
    this.quantity = new JTextField(0);
    this.quantity.setColumns(4);
    inputPanel.add(this.quantity);

    /* ボタンパネルの作成 */

    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton receiptButton = new JButton("入荷");
    receiptButton.setActionCommand("receipt");
    receiptButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(receiptButton);

    JButton shipmentButton = new JButton("出荷");
    shipmentButton.setActionCommand("shipment");
    shipmentButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(shipmentButton);

    JButton backToTopButton = new JButton("TOPへ戻る");
    backToTopButton.setActionCommand("top");
    backToTopButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(backToTopButton);

    /* コンテナパネルに部品を追加 */

    containerPanel.add(inputPanel, BorderLayout.NORTH);
    containerPanel.add(actionPanel, BorderLayout.SOUTH);

    /* フレームにコンテナパネルを追加 */

    this.add(containerPanel);

    /* フレームの設定 */

    super.beforeViewTask();
  }

  /**
   * リストをもとにJComboBoxオブジェクトを生成する
   *
   * @param items
   *          プルダウンに表示したい文字列のリスト
   * @return JComboBoxオブジェクト
   */
  private JComboBox<String> createJComboBoxFromStringArray(String[] items) {
    Vector<String> vector = new Vector<String>();
    for (String item : items) {
      vector.add(item);
    }
    return new JComboBox<String>(vector);
  }

  /**
   * @return コンボボックスで選択された商品名を返す
   */
  public String getSelectBrand() {
    return this.brand.getSelectedItem().toString();
  }

  /**
   * @return コンボボックスで選択された保管場所を返す
   */
  public String getSelectLocation() {
    return this.location.getSelectedItem().toString();
  }

  /**
   * @return テキストフィールドで入力された入出荷したい商品の数量を返す
   */
  public int getSelectQuantity() throws CommonException {
    try {
      return Integer.parseInt(this.quantity.getText());
    } catch (NumberFormatException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG2"));
    }
  }

}
