package stationeryms.client;

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
    stationery.control(); // リターンが返された場合は、アプリケーションを終了

    System.out.println("アプリケーション終了");
  }

}
