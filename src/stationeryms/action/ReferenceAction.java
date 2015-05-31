package stationeryms.action;

import stationeryms.common.CommonException;
import stationeryms.entity.Stationery;

public class ReferenceAction extends BaseAction {

  /**
   * コンストラクタ
   * @throws CommonException
   */
  public ReferenceAction() throws CommonException {
    super();
  }

  public void exec() {

    System.out.printf("%10s %10s %10s %10s\n", "商品名", "在庫数", "値段", "保管場所");

    for (Stationery stationery : this.getAllStationeryList()) {
      System.out.printf("%10s %10s %10s %10s\n",
          stationery.getBrandName(), stationery.getQuantity(), stationery.getQuantity(), stationery.getLocation());
    }
  }

}
