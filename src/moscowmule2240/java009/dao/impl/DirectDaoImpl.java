/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.dao.DirectDao;
import moscowmule2240.java009.dao.rowmapper.DirectRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Userストレージへアクセスするための実装されたDAOです。
 * 
 * @author moscowmule2240
 */
@Repository("directDao")
public class DirectDaoImpl implements DirectDao {

	/**
	 * マッピングファイルのオブジェクト
	 */
	@Autowired
	private DirectRowMapper directRowMapper;

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

	/*
	 * (non-Javadoc)ß
	 * @see moscowmule2240.java009.dao.DirectDao#getMessages(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Direct> getMessages(Long userId, Long reciveUserId) {
		return this.simpleJdbcTemplate.query(DirectDao.SELECT_MESSAGES_SQL, this.directRowMapper, userId, reciveUserId, userId, reciveUserId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.dao.DirectDao#insert(moscowmule2240.java009.bean.Direct)
	 */
	@Override
	public int insert(Direct direct) {
		return this.simpleJdbcTemplate.update(DirectDao.INSERT_SQL, direct.getUserId(), direct.getUserIdReceiver(), direct.getMessage());
	}
}
