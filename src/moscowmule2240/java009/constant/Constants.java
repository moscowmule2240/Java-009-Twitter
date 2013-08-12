/**
 * ミニブログ。
 */
package moscowmule2240.java009.constant;

/**
 * 定数クラス。
 * 
 * @author moscowmule2240
 */
public interface Constants {

	/**
	 * データベースアクセス情報を管理する設定ファイルのPATH。
	 */
	public static final String CONTEXT_PATH = "moscowmule2240/java009/resources/beans.xml";

	/**
	 * 一意制約違反エラーコード（MySQL）。
	 */
	public static final int SQL_ERROR_CODE_MYSQL_DUPLICATE = 1062;

	/**
	 * ユーザー情報登録キー。
	 */
	public static final String REGISTRATION_USER_INFOMATION_KEY = "registration.user.infomation.key";

}
