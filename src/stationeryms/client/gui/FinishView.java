package stationeryms.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 処理終了フレーム
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class FinishView extends OriginalFrame {

  /**
   * コンストラクタ
   *
   * @param title
   *          フレームタイトル
   */
  public FinishView(String title) {
    // フレームタイトルの設定
    super(title);

    /* コンテナパネルの作成 */

    JPanel containerPanel = new JPanel();
    containerPanel.setLayout(new BorderLayout());

    /* メッセージパネルの作成 */

    JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    messagePanel.add(new JLabel("ありがとうございました。"));

    /* ボタンパネルの作成 */

    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton backToTopButton = new JButton("TOPへ戻る");
    backToTopButton.setActionCommand("top");
    backToTopButton.addActionListener(new StationeryActionListener(this));
    actionPanel.add(backToTopButton);

    /* コンテナパネルに部品を追加 */

    containerPanel.add(messagePanel, BorderLayout.NORTH);
    containerPanel.add(actionPanel, BorderLayout.SOUTH);

    /* フレームにコンテナパネルを追加 */

    this.add(containerPanel);

    /* フレームの設定 */

    super.beforeViewTask();
  }

}
