package stationeryms.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MsgProperties {
  /* クラス変数 */
  public static final Properties prop = new Properties(); // 独自定義プロパティを保持

  /**
   * コンストラクタ
   * @throws CommonException
   */
  public MsgProperties() throws CommonException {
    super();
    try {
      prop.load(new FileInputStream("./message.properties"));
    } catch (IOException e) {
      // e.printStackTrace();
      throw new CommonException(" メッセージファイルロード失敗");
    }
  }


}
