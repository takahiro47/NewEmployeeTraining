package stationeryms.client.gui;

import javax.swing.JFrame;

/**
 * すべてのフレームのスーパークラス。フレームサイズや終了処理などの基本的な処理を実装する。
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class OriginalFrame extends JFrame {

  /**
   * コンストラクタ
   *
   * @param title
   *          フレームタイトル
   */
  public OriginalFrame(String title) {
    super(title);
  }

  /**
   * すべてのフレームが行う基本機能を提供する
   */
  public void beforeViewTask() {
    // ウィンドウを閉じたときにアプリケーションを終了する
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // 画面サイズを設定
    super.setSize(300, 300);
    // フレームを中央に配置する
    super.setLocationRelativeTo(rootPane);
  }

}
