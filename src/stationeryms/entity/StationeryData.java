package stationeryms.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import stationeryms.common.CommonException;
import stationeryms.common.MsgProperties;

public class StationeryData {
  /*
   * フィールド
   */
  protected ArrayList<Stationery> stationeryList; // 文房具管理リスト

  /* 文房具一覧DB */
  private static final File MY_FILE = new File("./stationery.db"); // 対象ファイル
  private static final String FIELD_DELIM = ","; // デリミタ
  private static final int FIELD_COUNT = 4; // フィールド数

  /* 文房具一覧DB I/O */
  private FileReader fr;
  private BufferedReader br;
  private FileOutputStream fo;
  private OutputStreamWriter os;
  private BufferedWriter bw;

  /**
   * 文房具管理リストの初期化
   */
  public void loadData() throws CommonException {
    // 読み込みストリームの生成
    this.openStreamReader();

    // 文房具リストの生成
    this.stationeryList = new ArrayList<Stationery>();

    // DBからデータを挿入する
    try {
      String data;
      while ((data = this.br.readLine()) != null) {
        // フィールド長が4でない場合、仕様外データとしてスキップ
        String[] fields = data.split(FIELD_DELIM);
        if (fields.length != FIELD_COUNT) {
          continue;
        }

        // データをリストに格納
        this.stationeryList.add(new Stationery(fields[0].trim(), Integer.parseInt(fields[1].trim()), Integer.parseInt(fields[2].trim()), fields[3].trim()));
      }
    } catch (IOException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG91"));
    } finally {
      // 読み込みストリームのクローズ処理
      this.closeStreamReader();
    }
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
    for (Stationery stationery : this.stationeryList) {
      if (stationery.getBrandName().equals(brandName) && stationery.getLocation().equals(location)) { return stationery; }
    }
    throw new CommonException(MsgProperties.prop.getProperty("ERROR_MSG3"));
  }

  /**
   * @return 文房具管理リスト
   */
  public ArrayList<Stationery> getStationeryList() {
    return this.stationeryList;
  }

  /**
   * 文房具一覧DB 読み込みストリームの生成
   *
   * @throws CommonException
   */
  private void openStreamReader() throws CommonException {
    try {
      // 対象ファイルが存在しなかった場合、新規作成する
      if (!MY_FILE.exists()) {
        MY_FILE.createNewFile();
      }

      // 読み込みストリームの生成
      this.br = new BufferedReader(this.fr = new FileReader(MY_FILE));

    } catch (FileNotFoundException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG92"));
    } catch (IOException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG91"));
    }
  }

  /**
   * 文房具一覧DB 書き込みストリームの生成
   *
   * @throws CommonException
   */
  private void openStreamWriter() throws CommonException {
    try {
      // 対象ファイルが存在しなかった場合、新規作成する
      if (!MY_FILE.exists()) {
        MY_FILE.createNewFile();
      }

      // 書き込みストリームの生成
      if (this.fo == null) {
        this.os = new OutputStreamWriter(this.fo);
      }
      if (this.bw == null) {
        this.bw = new BufferedWriter(this.os);
      }

    } catch (FileNotFoundException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG92"));
    } catch (IOException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG91"));
    }
  }

  /**
   * 文房具一覧DB 読み込みストリームのクローズ処理
   *
   * @throws CommonException
   */
  private void closeStreamReader() throws CommonException {
    try {
      if (this.br != null) {
        this.br.close();
      }
      if (this.fr != null) {
        this.fr.close();
      }
    } catch (IOException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG91"));
    } finally {
      this.br = null;
      this.fr = null;
    }
  }

  /**
   * 文房具一覧DB 書き込みストリームのクローズ処理
   *
   * @throws CommonException
   */
  private void closeStreamWriter() throws CommonException {
    try {
      if (this.bw != null) {
        this.bw.close();
      }
      if (this.fo != null) {
        this.fo.close();
      }
    } catch (IOException e) {
      throw new CommonException(MsgProperties.prop.getProperty("ERROE_MSG91"));
    } finally {
      this.bw = null;
      this.fo = null;
    }
  }
}
