package stationeryms.common;

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
