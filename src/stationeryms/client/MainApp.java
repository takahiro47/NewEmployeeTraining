package stationeryms.client;

/**
 * 文房具管理アプリケーション
 *
 * @author takahiro
 *
 */
public class MainApp {

  /**
   * @param args
   *          コマンドライン引数
   */
  public static void main(String[] args) {
    StationeryMSControl stationery = null;

    System.out.println("\n 文房具管理システム");

    try {
      stationery = new StationeryMSControl();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // このメソッドが終了した場合は、アプリケーションを終了
    stationery.control();

    System.out.println("アプリケーション終了");
  }

}
