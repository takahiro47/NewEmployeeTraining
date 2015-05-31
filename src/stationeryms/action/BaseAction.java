package stationeryms.action;

import java.util.ArrayList;

import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;
import stationeryms.entity.Stationery;
import stationeryms.entity.StationeryData;

/**
 * ビジネス処理 ベースクラス
 *
 * @author takahiro
 *
 */
public class BaseAction {
  /*
   * フィールド
   */
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
    return this.stationeryData.getStationery(brandName, location);
  }

  /**
   * 文房具リストをファイルへ保存する
   *
   * @throws CommonException
   */
  public void commitData() throws CommonException {
    this.stationeryData.commitData();
  }

  /**
   * メニュー番号が 10 であるか確認する
   *
   * @param num
   *          メニュー番号
   * @return メニュー番号がトップメニューのものであるかの真偽値を返す
   */
  public boolean isTopMenuNum(String num) {
    // 番号が 10 ならば true を返す
    if (num.equals("10")) {
      return true;
    }
    // それ以外の場合は false を返す
    return false;
  }

  /**
   * 番号が 1, 2, 3 のいずれかであるかを確認する
   * 番号が 1, 2, 3 のいずれかで無ければ例外を発生させる
   *
   * @param num
   *          メニュー番号
   * @throws CommonException
   */
  public void numCheck(String num) throws CommonException {
    // 番号が 1, 2, 3 のいずれかで無ければ例外を発生させる
    if (!(num.equals("1") || num.equals("2") || num.equals("3"))) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG1"));
    }
    return;
  }

  /**
   * 番号に対応した商品名を返す
   *
   * @param num
   *          商品番号
   * @return 商品番号に対応した商品名を返す
   * @throws CommonException
   */
  public String getBrandName(String num) throws CommonException {
    String brandName = "";
    // 番号が 1, 2, 3 のいずれかであるか確認する
    this.numCheck(num);

    // それぞれの番号に対応する保管場所を返す
    if (num.equals("1")) {
      brandName = "鉛筆";
    } else if (num.equals("2")) {
      brandName = "ノート";
    } else if (num.equals("3")) {
      brandName = "消しゴム";
    }
    return brandName;
  }

  /**
   * 番号に対応した保管場所を返す
   *
   * @param num
   *          保管場所番号
   * @return 保管場所番号に対応した保管場所を返す
   * @throws CommonException
   */
  public String getLocation(String num) throws CommonException {
    String location = "";
    // 番号が 1, 2, 3 のいずれかであるか確認する
    this.numCheck(num);

    // それぞれの番号に対応する保管場所を返す
    if (num.equals("1")) {
      location = "東京";
    } else if (num.equals("2")) {
      location = "千葉";
    } else if (num.equals("3")) {
      location = "埼玉";
    }
    return location;
  }

  /**
   * 一度に入荷/出荷できる数量範囲(1〜100)かどうかを確認する。
   * 範囲外の数量の時は、例外を返す。
   *
   * @param num
   *          入荷/出荷する数量
   * @throws CommonException
   */
  public void quantityCheck(int num) throws CommonException {
    if (!(1 <= num && num <= 100)) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG1"));
    }
    return;
  }
}
