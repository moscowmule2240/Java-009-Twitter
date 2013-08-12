/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.impl;

import javax.sql.DataSource;

import moscowmule2240.java009.bean.Favorite;
import moscowmule2240.java009.dao.FavoriteDao;
import moscowmule2240.java009.dao.rowmapper.FavoriteRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Favoriteストレージへアクセスするための実装されたDAOです。
 * 
 * @author moscowmule2240
 */
@Repository("favoriteDao")
public class FavoriteDaoImpl implements FavoriteDao {

	/**
	 * マッピングファイルのオブジェクト
	 */
	@Autowired
	private FavoriteRowMapper favoriteRowMapper;

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
	// return simpleJdbcTemplate.queryForObject(SEARCH_BY_ID_SQL, userRowMapper,
	// id);
	// }

	// @Override
	// public User findByUserNameAndPassword(String userName, String password) {
	// return
	// this.simpleJdbcTemplate.queryForObject(UserDao.SEARCH_BY_LOGIN_SQL,
	// this.userRowMapper, userName, password);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * moscowmule2240.java009.dao.FavoriteDao#insert(moscowmule2240.java009.
	 * bean.Favorite)
	 */
	@Override
	public int insert(Favorite favorite) {
		return this.simpleJdbcTemplate.update(FavoriteDao.INSERT_SQL,
				favorite.getUserId(), favorite.getTweetId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * moscowmule2240.java009.dao.FavoriteDao#delete(moscowmule2240.java009.
	 * bean.Favorite)
	 */
	@Override
	public int delete(Favorite favorite) {
		return this.simpleJdbcTemplate.update(FavoriteDao.DELETE_SQL,
				favorite.getUserId(), favorite.getTweetId());
	}

	// // 更新を行うメソッド
	// public int update(User user) {
	// return simpleJdbcTemplate.update(UPDATE_SQL,
	// user.getUserName(),user.getTel(),user.getPass(),user.getUserId());
	// }
	//
	// // 削除を行うメソッド
	// public int delete(int id) {
	// return simpleJdbcTemplate.update(DELETE_SQL, id);
	// }

}
