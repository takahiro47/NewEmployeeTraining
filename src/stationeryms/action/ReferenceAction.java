package stationeryms.action;

import stationeryms.common.CommonException;
import stationeryms.entity.Stationery;

/**
 * ビジネス処理 在庫照会処理
 *
 * @author takahiro
 *
 */
public class ReferenceAction extends BaseAction {

  /**
   * コンストラクタ
   *
   * @throws CommonException
   */
  public ReferenceAction() throws CommonException {
    super();
  }

  /**
   * 文房具の在庫一覧を標準出力する
   */
  public void exec() {
    // 列名を出力
    System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", "商品名", "在庫数", "値段", "保管場所");
    // 区切り線を出力
    System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", "------", "------", "------", "------");

    // データを出力
    for (Stationery stationery : this.getAllStationeryList()) {
      System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", stationery.getBrandName(), stationery.getQuantity(), stationery.getPrice(), stationery.getLocation());
    }
  }

}
