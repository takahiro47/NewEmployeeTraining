package stationeryms.action;

import stationeryms.common.CommandRead;
import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;
import stationeryms.entity.Stationery;

/**
 * ビジネス処理 入荷処理
 *
 * @author takahiro
 *
 */
public class ReceiptAction extends BaseAction {

  /**
   * コンストラクタ
   *
   * @throws CommonException
   */
  public ReceiptAction() throws CommonException {
    super();
  }

  /**
   * 商品を入荷し、文房具の在庫情報を更新する
   *
   * @param brandName
   *          入荷した商品名
   * @param location
   *          入荷した商品の保管場所
   * @param inQt
   *          入荷する商品の数。この数だけ在庫数を増やす
   */
  public void receipt(String brandName, String location, int inQt) throws CommonException {
    // 在庫数を更新
    Stationery stationery = this.getStationery(brandName, location);
    stationery.setQuantity(stationery.getQuantity() + inQt);

    // 更新した在庫情報を保存
    this.commitData();
  }

  /**
   * クライアントと対話形式で入荷情報を受け取る
   *
   * @param commandRead
   * @throws CommonException
   */
  public void exec(CommandRead commandRead) throws CommonException {
    String in; // 標準入力の値を保持

    String brandName; // 商品名
    String location; // 保管場所
    int inQt; // 入荷数

    /* 商品番号選択フェーズ */

    // 入力メニューを出力
    System.out.println(MsgProperties.prop.getProperty("RECEIPT_BRANDNAME_SELECT"));

    // 標準入力から番号を取得
    in = commandRead.getInputData();

    // 10が入力された場合は終了
    if (isTopMenuNum(in)) {
      return;
    }

    // 対応した商品名を取得
    brandName = this.getBrandName(in);

    /* 保管場所選択フェーズ */

    // 入力メニューを出力
    System.out.println(MsgProperties.prop.getProperty("RECEIPT_LOCATION_SELECT"));

    // 標準入力から番号を取得
    in = commandRead.getInputData();

    // 番号に対応した保管場所を保持
    location = this.getLocation(in);

    /* 入荷数選択フェーズ */

    // 入力メニューを出力
    System.out.println(MsgProperties.prop.getProperty("RECEIPT_QUANTITY_SELECT"));

    // 入力された番号を取得
    in = commandRead.getInputData();

    // 入荷数を数値に変換する
    try {
      // 数値に変換できなかった場合は、例外をスローする
      inQt = Integer.parseInt(in);
    } catch (Exception e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG99"));
    }

    // 一度に入荷できる数量かチェックする
    this.quantityCheck(inQt);

    /* 入荷処理の実行 */

    // 入荷処理
    this.receipt(brandName, location, inQt);

    // 終了表示
    System.out.println(MsgProperties.prop.getProperty("RECEIPT_FIN"));
  }
}
