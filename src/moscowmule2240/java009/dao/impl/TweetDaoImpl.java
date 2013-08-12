/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.dao.TweetDao;
import moscowmule2240.java009.dao.rowmapper.TweetRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Userストレージへアクセスするための実装されたDAOです。
 * 
 * @author moscowmule2240
 */
@Repository("tweetDao")
public class TweetDaoImpl implements TweetDao {

	/**
	 * マッピングファイルのオブジェクト
	 */
	@Autowired
	private TweetRowMapper tweetRowMapper;

	/**
	 * クエリテンプレートオブジェクト。
	 */
	private SimpleJdbcTemplate simpleJdbcTemplate;

	/**
	 * データソース情報を使用してクエリテンプレートオブジェクトを作成
	 * 
	 * @param dataSource
	 *            データソース
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	// // 全検索を行うメソッド
	// public List<User> findAll() {
	// return simpleJdbcTemplate.query(SEARCH_ALL_SQL, userRowMapper);
	// }
	//
	// // 条件検索を行うメソッド
	// public User findById(int id) {
	// return simpleJdbcTemplate.queryForObject(SEARCH_BY_ID_SQL, userRowMapper, id);
	// }

	// @Override
	// public User findByUserNameAndPassword(String userName, String password) {
	// return this.simpleJdbcTemplate.queryForObject(UserDao.SEARCH_BY_LOGIN_SQL, this.userRowMapper, userName, password);
	// }

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.TweetDao#findByUserId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Tweet> findByUserId(Long userId, Long userIdTweet) {
		return this.simpleJdbcTemplate.query(TweetDao.SEARCH_BY_USERID_SQL, this.tweetRowMapper, userId, userIdTweet);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.TweetDao#findFavoriteByUserId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Tweet> findFavoriteByUserId(Long userId, Long userIdFavorite) {
		return this.simpleJdbcTemplate.query(TweetDao.SEARCH_FAVORITE_BY_USERID_SQL, this.tweetRowMapper, userId, userIdFavorite);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.TweetDao#findTimeLineByUserId(java.lang.Long)
	 */
	@Override
	public List<Tweet> findTimeLineByUserId(Long userId) {
		return this.simpleJdbcTemplate.query(TweetDao.SEARCH_TIMELINE_BY_USERID_SQL, this.tweetRowMapper, userId, userId, userId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.TweetDao#findTimeLineBySearchValue(java.lang.String)
	 */
	@Override
	public List<Tweet> findTimeLineBySearchValue(String tweet) {
		return this.simpleJdbcTemplate.query(TweetDao.SEARCH_TIMELINE_BY_TWEET_LIKE_SQL, this.tweetRowMapper, "%" + tweet + "%");
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.TweetDao#insert(moscowmule2240.java009.bean.Tweet)
	 */
	@Override
	public int insert(Tweet tweet) {
		return this.simpleJdbcTemplate.update(TweetDao.INSERT_SQL, tweet.getUserId(), tweet.getTweet());
	}

	// // 更新を行うメソッド
	// public int update(User user) {
	// return simpleJdbcTemplate.update(UPDATE_SQL, user.getUserName(),user.getTel(),user.getPass(),user.getUserId());
	// }
	//
	// // 削除を行うメソッド
	// public int delete(int id) {
	// return simpleJdbcTemplate.update(DELETE_SQL, id);
	// }

}
