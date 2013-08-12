/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao;

import moscowmule2240.java009.bean.Favorite;

/**
 * UserストレージへアクセスするためのDAOインターフェース。
 * 
 * @author moscowmule2240
 */
public interface FavoriteDao {

	/**
	 * 登録を行うためのSQLを示す定数です。
	 */
	final String INSERT_SQL = "insert into favorites (userid, tweetid) VALUES (?, ?)";

	/**
	 * 削除を行うためのSQLを示す定数です。
	 */
	final String DELETE_SQL = "delete from favorites where userid = ? and tweetid = ?";

	// /**
	// * ログイン情報を確認するためのSQLを示す定数です。
	// */
	// final String SEARCH_BY_LOGIN_SQL = "select * from users where username = ? and password = ?";
	//
	// /** 全検索を行うためのSQLを示す定数です。 */
	// final String SEARCH_ALL_SQL = "select * from users";
	// /** 条件検索を行うためのSQLを示す定数です。 */
	// final String SEARCH_BY_ID_SQL = "select * from users where userid = ?";
	//
	// /** 更新を行うためのSQLを示す定数です。 */
	// final String UPDATE_SQL = "update users set username = ?,tel = ?,pass = ? where userid = ?";
	// /** 削除を行うためのSQLを示す定数です。 */
	// final String DELETE_SQL = "delete from users where userid = ?";

	// /**
	// * Userを全件取得します。
	// * 1件もデータが存在しない場合はサイズ０のListを返します。
	// *
	// * @return 全件データ
	// */
	// public List<User> findAll();
	//
	// /**
	// * 指定されたidを持つUserを返します。
	// * 一致するUserが存在しない場合、デフォルト値がセットされたUserオブジェクトを返します。
	// * デフォルト値 IDに０をセット。
	// *
	// * @param id Userのid
	// * @return idが一致したUser
	// */
	// public User findById(int id);
	//
	// /**
	// * 指定されたuserNameとpasswordを元にログイン情報を取得します。<br>
	// * ログインデータに一致しない場合、<code>null</code>を返します。
	// *
	// * @param userName
	// * 指定されたuserName
	// * @param password
	// * 指定されたpassword
	// * @return userNameとpasswordに一致したログインユーザ情報
	// */
	// public User findByUserNameAndPassword(String userName, String password);

	/**
	 * 指定されたお気に入りを登録します。
	 * 
	 * @param favorite
	 *            登録するお気に入り
	 * @return 登録した件数
	 */
	public int insert(Favorite favorite);

	/**
	 * 指定されたお気に入りを解除します。
	 * 
	 * @param favorite
	 *            解除するお気に入り
	 * @return 解除した件数
	 */
	public int delete(Favorite favorite);

	// /**
	// * 指定されたUserをidに基づいて更新します。
	// *
	// * @param user 更新するUser
	// * @return 更新した件数
	// * @throws NullPointerException userがnullの場合
	// */
	// int update(User user);
	//
	// /**
	// * 指定されたidを持つUserを削除します。
	// *
	// * @param id 削除するid
	// * @return 削除した件数
	// */
	// int delete(int id);
}
