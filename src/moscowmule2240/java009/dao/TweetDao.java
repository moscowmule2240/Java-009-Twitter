/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;

/**
 * UserストレージへアクセスするためのDAOインターフェース。
 * 
 * @author moscowmule2240
 */
public interface TweetDao {

	/**
	 * ツイート情報を取得するためのSQLを示す定数です。
	 */
	final String SEARCH_BY_USERID_SQL = "select tw.tweetid, tw.tweet, tw.tweettime, us.userid, us.displayname, case when fa.userid is null then 0 else 1 end as favorite from tweets as tw inner join users as us on tw.userid = us.userid left join favorites as fa on fa.userid = ? and tw.tweetid = fa.tweetid where tw.userid = ? order by tw.tweettime desc, tw.tweetid asc";

	/**
	 * お気に入り情報を取得するためのSQLを示す定数です。
	 */
	final String SEARCH_FAVORITE_BY_USERID_SQL = "select us.userid, us.displayname, tw.tweetid, tw.tweet, tw.tweettime, case when fa2.userid is null then 0 else 1 end as favorite from favorites as fa1 inner join tweets as tw on fa1.tweetid = tw.tweetid inner join users as us on tw.userid = us.userid left join favorites as fa2 on fa2.userid = ? and fa1.tweetid = fa2.tweetid where fa1.userid = ? order by tw.tweettime desc, us.userid asc";

	/**
	 * タイムライン情報を確認するためのSQLを示す定数です。
	 */
	final String SEARCH_TIMELINE_BY_USERID_SQL = "select tw.userid, us.displayname, tw.tweetid, tw.tweet, tw.tweettime, case when fa.tweetid is null then 0 else 1 end as favorite "
			+ "from tweets as tw " + "inner join users as us " + "on tw.userid = us.userid " + "left join favorites as fa " + "on fa.userid = ? " + "and tw.tweetid = fa.tweetid "
			+ "where tw.userid = ? " + "or exists( " + "select * " + "from follows as fo " + "where fo.userid = ? " + "and fo.useridfollow = tw.userid) "
			+ "order by tw.tweettime desc, tw.tweetid asc";

	/**
	 * タイムライン情報を確認するためのSQLを示す定数です。
	 */
	final String SEARCH_TIMELINE_BY_TWEET_LIKE_SQL = "select tw.userid, us.displayname, tw.tweetid, tw.tweet, tw.tweettime, null as favorite " + "from tweets as tw " + "inner join users as us "
			+ "on tw.userid = us.userid " + "where tw.tweet like ? " + "order by tw.tweettime desc, tw.tweetid asc";

	/**
	 * 登録を行うためのSQLを示す定数です。
	 */
	final String INSERT_SQL = "insert into tweets (userid, tweet) values (?, ?)";

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
	 * ユーザーIDに該当するツイートを取得します。
	 * 
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdTweet
	 *            検索対象ユーザーID
	 * @return 検索結果
	 */
	public List<Tweet> findByUserId(Long userId, Long userIdTweet);

	/**
	 * ユーザーIDに該当するユーザーが登録したお気に入りを取得します。
	 * 
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdFavorite
	 *            検索対象ユーザーID
	 * @return 検索結果
	 */
	public List<Tweet> findFavoriteByUserId(Long userId, Long userIdFavorite);

	/**
	 * ユーザーIDに該当するタイムラインを取得します。
	 * 
	 * @param userId
	 *            検索対象ユーザーID
	 * @return 検索結果
	 */
	public List<Tweet> findTimeLineByUserId(Long userId);

	/**
	 * 検索する値に該当するタイムラインを取得します。
	 * 
	 * @param tweet
	 *            検索する値
	 * @return タイムライン
	 */
	public List<Tweet> findTimeLineBySearchValue(String tweet);

	/**
	 * 指定されたツイートを登録します。
	 * 
	 * @param tweet
	 *            登録するツイート
	 * @return 登録した件数
	 */
	public int insert(Tweet tweet);

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
