/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.dao.rowmapper.UserRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Userストレージへアクセスするための実装されたDAOです。
 *
 * @author moscowmule2240
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	/**
	 * マッピングファイルのオブジェクト
	 */
	@Autowired
	private UserRowMapper userRowMapper;

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

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findByUserId(long)
	 */
	@Override
	public User findByUserId(long userId) {
		return this.simpleJdbcTemplate.queryForObject(UserDao.SEARCH_BY_USERID_SQL, this.userRowMapper, userId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findByUserNameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return this.simpleJdbcTemplate.queryForObject(UserDao.SEARCH_BY_LOGIN_SQL, this.userRowMapper, userName, password);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findByUserNameLike(java.lang.String)
	 */
	@Override
	public List<User> findByUserNameLike(String userName) {
		return this.simpleJdbcTemplate.query(UserDao.SEARCH_BY_USERNAME_LIKE_SQL, this.userRowMapper, "%" + userName + "%");
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findFollowByUserId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<User> findFollowByUserId(Long userId, Long userIdFollow) {
		return this.simpleJdbcTemplate.query(UserDao.SEARCH_FOLLOW_BY_USERID_SQL, this.userRowMapper, userId, userIdFollow);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findFollowerByUserId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<User> findFollowerByUserId(Long userId, Long userIdFollower) {
		return this.simpleJdbcTemplate.query(UserDao.SEARCH_FOLLOWER_BY_USERID_SQL, this.userRowMapper, userId, userIdFollower);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#findEachFollowsByUserId(java.lang.Long)
	 */
	@Override
	public List<User> findEachFollowsByUserId(Long userId) {
		return this.simpleJdbcTemplate.query(UserDao.SEARCH_EACH_FOLLOWS_BY_USERID_SQL, this.userRowMapper, userId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.UserDao#insert(moscowmule2240.java009.bean.User)
	 */
	@Override
	public int insert(User user) {
		return this.simpleJdbcTemplate.update(UserDao.INSERT_SQL, user.getUserName(), user.getDisplayName(), user.getPassword(), user.getIntroduction());
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
