package stationeryms.entity;

import java.util.ArrayList;

import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

public class StationeryData {
  /*
   * フィールド
   */
  protected ArrayList<Stationery> stationeryList; // 文房具管理リスト

  /**
   * 文房具管理リストの初期化
   */
  public void loadData() {
    this.stationeryList = new ArrayList<Stationery>();

    // テストデータ追加(デバッグ用)
    this.stationeryList.add(new Stationery("鉛筆", 200, 200, "東京"));
    this.stationeryList.add(new Stationery("鉛筆", 200, 200, "千葉"));
    this.stationeryList.add(new Stationery("鉛筆", 200, 200, "埼玉"));
    this.stationeryList.add(new Stationery("ノート", 200, 150, "東京"));
    this.stationeryList.add(new Stationery("ノート", 200, 150, "千葉"));
    this.stationeryList.add(new Stationery("ノート", 200, 150, "埼玉"));
    this.stationeryList.add(new Stationery("消しゴム", 200, 80, "東京"));
    this.stationeryList.add(new Stationery("消しゴム", 200, 80, "千葉"));
    this.stationeryList.add(new Stationery("消しゴム", 200, 80, "埼玉"));
  }

  /**
   * @param brandName 検索対象の商品名
   * @param location 検索対象の管理場所
   * @return 商品名と管理場所に該当する最初の文房具オブジェクトを返す
   * @throws CommonException
   */
  public Stationery getStationery(String brandName, String location) throws CommonException {
    for (Stationery stationery : this.stationeryList) {
      if ( stationery.getBrandName().equals(brandName) && stationery.getLocation().equals(location) ) {
        return stationery;
      }
    }
    throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG3"));
  }

  /**
   * @return 文房具管理リスト
   */
  public ArrayList<Stationery> getStationeryList() {
    return this.stationeryList;
  }
}
