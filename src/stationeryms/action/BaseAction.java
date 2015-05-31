package stationeryms.action;

import java.util.ArrayList;

import stationeryms.common.CommonException;
import stationeryms.entity.Stationery;
import stationeryms.entity.StationeryData;

public class BaseAction {
  private StationeryData stationeryData;

  /**
   * コンストラクタ
   *
   * @throws CommonException
   */
  public BaseAction() throws CommonException {
    this.stationeryData = new StationeryData();
    this.stationeryData.loadData();
  }

  /**
   * @return 文房具リストを返す
   */
  public ArrayList<Stationery> getAllStationeryList() {
    return this.stationeryData.getStationeryList();
  }

  /**
   * @param brandName
   *          検索対象の商品名
   * @param location
   *          検索対象の管理場所
   * @return 商品名と管理場所に該当する最初の文房具オブジェクトを返す
   * @throws CommonException
   */
  public Stationery getStationery(String brandName, String location) throws CommonException {
    return this.getStationery(brandName, location);
  }
}
