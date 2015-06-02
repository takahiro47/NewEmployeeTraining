package stationeryms.client.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * トップメニューを表示するフレーム
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class TopView extends OriginalFrame {

  /**
   * コンストラクタ
   *
   * @param title
   *          フレームタイトル
   */
  public TopView(String title) {
    // フレームタイトルの設定
    super(title);

    // コンテナパネルを生成
    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new GridLayout(2, 1));

    // ボタンパネルの生成
    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton referenceButton = new JButton("在庫照会");
    referenceButton.setActionCommand("reference");
    referenceButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(referenceButton);

    JButton subMenuButton = new JButton("入出荷");
    subMenuButton.setActionCommand("subMenu");
    subMenuButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(subMenuButton);

    // コンテナパネルに部品を追加
    containerPanel.add(new JLabel("TOPメニュー"));
    containerPanel.add(actionPanel);

    // フレームにコンテナパネルを追加
    this.add(containerPanel);

    // フレームの設定
    super.beforeViewTask();
  }

}
