/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import moscowmule2240.java009.bean.Favorite;
import moscowmule2240.java009.utility.Utility;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

/**
 * お気に入りストレージマッピング用のクラスです。
 * 
 * @author moscowmule2240
 */
@Component
public class FavoriteRowMapper implements ParameterizedRowMapper<Favorite> {

	/*
	 * (非 Javadoc)
	 * @see org.springframework.jdbc.core.simple.ParameterizedRowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
		Favorite favorite = new Favorite();
		favorite.setUserId(Utility.getDatabaseData(rs, "userid", new Long(0)));
		favorite.setUserId(Utility.getDatabaseData(rs, "tweetid", new Long(0)));
		return favorite;
	}
}
