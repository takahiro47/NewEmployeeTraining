package stationeryms.entity;

import java.io.Serializable;

/**
 * 文房具
 * @author takahiro
 */
/*
 * Serializableインタフェース
 * …メソッドの定義が1つもないマーカーインタフェース。
 * これを実装することは、シリアライズ(=オブジェクトグラフ構造から直列データ構造への変換)が
 * 出来ることを保証することに等しい。つまり、デシリアライズしたら元通りに動作することを保証する。
 */
@SuppressWarnings("serial")
public class Stationery implements Serializable {
  /*
   * フィールド
   */
  private String brandName; // 商品名
  private int quantity; // 在庫数
  private int price; // 値段
  private String location; // 保管場所

  /**
   * コンストラクタ : 文房具情報の初期化
   * @param brandName 商品名
   * @param quantity 在庫数
   * @param price 値段
   * @param location 保管場所
   */
  public Stationery(String brandName, int quantity, int price, String location) {
    this.brandName = brandName;
    this.quantity = quantity;
    this.price = price;
    this.location = location;
  }

  /**
   * @return brandName 商品名を返す
   */
  public String getBrandName() {
    return this.brandName;
  }

  /**
   * @return quantity 在庫数を返す
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @return price 値段を返す
   */
  public int getPrice() {
    return price;
  }

  /**
   * @return location 管理場所を返す
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param quantity 更新後の在庫数
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
