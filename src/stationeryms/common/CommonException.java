package stationeryms.common;

/**
 * 独自例外
 *
 * @author takahiro
 *
 */
@SuppressWarnings("serial")
public class CommonException extends Exception {

  /**
   * コンストラクタ
   *
   * @param message
   *          エラーメッセージ
   */
  public CommonException(String message) {
    super(message);
  }
}
