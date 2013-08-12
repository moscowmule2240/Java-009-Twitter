/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao;

import java.util.List;

import moscowmule2240.java009.bean.User;

/**
 * UserストレージへアクセスするためのDAOインターフェース。
 *
 * @author moscowmule2240
 */
public interface UserDao {

	/**
	 * ユーザー情報を取得するためのSQL。
	 */
	final String SEARCH_BY_USERID_SQL = "select *, null as follow from users where userid = ?";

	/**
	 * ログイン情報を確認するためのSQLを示す定数です。
	 */
	final String SEARCH_BY_LOGIN_SQL = "select *, null as follow from users where username = ? and password = ?";

	/**
	 * ユーザー情報を取得するためのSQL。
	 */
	final String SEARCH_BY_USERNAME_LIKE_SQL = "select *, null as follow from users where displayname like ? order by displayname asc";

	/**
	 * フォローしているユーザー情報を取得するためのSQL。
	 */
	final String SEARCH_FOLLOW_BY_USERID_SQL = "select us.userid, us.username, us.password, us.displayname, us.introduction, fo1.registrationtime, case when fo2.userid is null then 0 else 1 end as follow from follows fo1 inner join users us on fo1.useridfollow = us.userid left join follows as fo2 on fo1.useridfollow = fo2.useridfollow and fo2.userid = ? where fo1.userid = ? order by fo1.registrationtime desc, fo1.userid asc";

	/**
	 * フォロワーのユーザー情報を取得するためのSQL。
	 */
	final String SEARCH_FOLLOWER_BY_USERID_SQL = "select us.userid, us.username, us.password, us.displayname, us.introduction, fo1.registrationtime, case when fo2.userid is null then 0 else 1 end as follow from follows fo1 inner join users as us on fo1.userid = us.userid left join follows as fo2 on fo1.userid = fo2.useridfollow and fo2.userid = ? where fo1.useridfollow = ? order by fo1.registrationtime desc, us.userid asc";

	/**
	 * 相互フォローを取得するためのSQL。
	 */
	final String SEARCH_EACH_FOLLOWS_BY_USERID_SQL = "select  us.userid, us.username, us.password, us.displayname, us.introduction, null as follow from follows as fo1 inner join follows as fo2 on fo1.useridfollow = fo2.userid and fo1.userid = fo2.useridfollow inner join users as us on fo1.useridfollow = us.userid where fo1.userid = ? order by fo1.registrationtime desc, fo1.userid asc";

	/**
	 * 登録を行うためのSQLを示す定数です。
	 */
	final String INSERT_SQL = "insert into users (username, displayname, password, introduction) values (?, ?, ?, ?)";

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

	/**
	 * ユーザーIDからユーザー情報を取得します。
	 *
	 * @param userId
	 *            ユーザーID
	 * @return ユーザー情報
	 */
	public User findByUserId(long userId);

	/**
	 * 指定されたuserNameとpasswordを元にログイン情報を取得します。<br>
	 * ログインデータに一致しない場合、<code>null</code>を返します。
	 *
	 * @param userName
	 *            指定されたuserName
	 * @param password
	 *            指定されたpassword
	 * @return userNameとpasswordに一致したログインユーザ情報
	 */
	public User findByUserNameAndPassword(String userName, String password);

	/**
	 * 指定されたユーザー名を含むユーザー情報を取得します。
	 *
	 * @param userName
	 *            ユーザー名
	 * @return ユーザー情報
	 */
	public List<User> findByUserNameLike(String userName);

	/**
	 * 指定されたユーザーがフォローしているユーザー情報を取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdFollow
	 *            検索対象ユーザーのユーザーID
	 * @return ユーザー情報
	 */
	public List<User> findFollowByUserId(Long userId, Long userIdFollow);

	/**
	 * 指定されたユーザーのフォロワーのユーザー情報を取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdFollower
	 *            検索対象ユーザーのユーザーID
	 * @return ユーザー情報
	 */
	public List<User> findFollowerByUserId(Long userId, Long userIdFollower);

	/**
	 * 指定したユーザーの相互フォローを取得します。
	 *
	 * @param userId ユーザー
	 * @return 相互フォロー
	 */
	public List<User> findEachFollowsByUserId(Long userId);

	/**
	 * 指定されたUserを登録します。
	 *
	 * @param user
	 *            登録するUser
	 * @return 登録した件数
	 */
	public int insert(User user);

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
