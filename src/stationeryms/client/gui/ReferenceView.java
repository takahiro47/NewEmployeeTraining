package stationeryms.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import stationeryms.action.BaseAction;
import stationeryms.common.CommonException;
import stationeryms.entity.Stationery;

/**
 * 在庫表示フレーム
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class ReferenceView extends OriginalFrame {

  /**
   * コンストラクタ
   *
   * @param title
   *          フレームタイトル
   * @throws CommonException
   */
  public ReferenceView(String title) throws CommonException {
    // フレームタイトルの設定
    super(title);

    // ベース処理
    BaseAction baseAction = new BaseAction();

    // 全在庫リストを取得し、テキスト形式に
    StringBuilder stringBuffer = new StringBuilder("");
    stringBuffer.append(String.format("%-10s\t%-10s\t%-10s\t%-10s%n", "商品名", "在庫数", "値段", "保管場所"));
    stringBuffer.append(String.format("%-10s\t%-10s\t%-10s\t%-10s%n", "------", "------", "------", "------"));
    for (Stationery stationery : baseAction.getAllStationeryList()) {
      stringBuffer.append(String.format("%-10s\t%-10s\t%-10s\t%-10s%n", stationery.getBrandName(), stationery.getQuantity(), stationery.getPrice(),
          stationery.getLocation()));
    }

    // コンテナパネルを生成
    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new BorderLayout());

    // テキスト表示パネルを生成
    JPanel textPanel = new JPanel();
    textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    JTextArea textarea = new JTextArea(stringBuffer.toString());
    JScrollPane scrollPane = new JScrollPane(textarea); // テキストエリアをスクロール可能にする
    scrollPane.setPreferredSize(new Dimension(200, 200)); // スクロールの広さを指定
    textPanel.add(scrollPane);

    // ボタンパネルの生成
    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton backToTopButton = new JButton("TOPへ戻る");
    backToTopButton.setActionCommand("top");
    backToTopButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(backToTopButton);

    // コンテナパネルに部品を追加
    containerPanel.add(new JLabel("在庫照会"), BorderLayout.NORTH);
    containerPanel.add(textPanel, BorderLayout.NORTH);
    containerPanel.add(actionPanel, BorderLayout.SOUTH);

    // フレームにコンテナパネルを追加
    this.add(containerPanel);

    // フレームの設定
    super.beforeViewTask();
  }

}
