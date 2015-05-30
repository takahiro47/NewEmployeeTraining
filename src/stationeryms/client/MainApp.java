package stationeryms.client;

public class MainApp {

  public static void main(String[] args) {
    StationeryMSControl stationery;

    System.out.println("\n 文房具管理システム");

    stationery = new StationeryMSControl();
    stationery.control(); // リターンが返された場合は、アプリケーションを終了

    System.out.println("アプリケーション終了");
  }

}
