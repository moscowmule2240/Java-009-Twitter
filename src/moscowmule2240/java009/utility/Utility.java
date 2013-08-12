/**
 * ミニブログ。
 */
package moscowmule2240.java009.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * ユーティリティ。
 * 
 * @author moscowmule2240
 */
public class Utility {

	/**
	 * コンストラクタ。
	 */
	private Utility() {
		// インスタンス化無効
	}

	/**
	 * MySQL接続時の例外からSQLExceptionクラスを取得します。
	 * 
	 * @param exception
	 *            MySQL接続時の例外
	 * @return SQLExceptionが取得できた場合SQLExceptionを返します。<br>
	 *         取得できなかった場合、<code>null</code>を返します。
	 */
	public static SQLException getSQLException(Exception exception) {
		if (exception.getCause().getClass() == MySQLIntegrityConstraintViolationException.class) {
			return (MySQLIntegrityConstraintViolationException) exception.getCause();
		}
		return null;
	}

	/**
	 * データベースから取得した値を型変換を行い返します。<br>
	 * <code>null</code>が入力された場合は<code>null</code>として返します。
	 * 
	 * @param resultSet
	 *            結果セット
	 * @param columnName
	 *            カラム名
	 * @param columnType
	 *            カラムタイプ
	 * @return 取得結果
	 * @throws SQLException
	 *             結果取得時に例外が発生した場合
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDatabaseData(ResultSet resultSet, String columnName, T columnType) throws SQLException {
		if (resultSet.getObject(columnName) == null) {
			return null;
		}
		if (columnType instanceof Boolean) {
			return (T) new Boolean(resultSet.getBoolean(columnName));
		}
		if (columnType instanceof Long) {
			return (T) new Long(resultSet.getLong(columnName));
		}
		return (T) resultSet.getObject(columnName);
	}
}
