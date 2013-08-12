/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.utility.Utility;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

/**
 * ユーザーストレージマッピング用のクラスです。
 *
 * @author moscowmule2240
 */
@Component
public class UserRowMapper implements ParameterizedRowMapper<User> {

	/*
	 * (非 Javadoc)
	 * @see org.springframework.jdbc.core.simple.ParameterizedRowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(Utility.getDatabaseData(rs, "userid", new Long(0)));
		user.setUserName(rs.getString("username"));
		user.setDisplayName(rs.getString("displayname"));
		user.setPassword(rs.getString("password"));
		user.setIntroduction(rs.getString("introduction"));
		user.setFollow(Utility.getDatabaseData(rs, "follow", new Boolean(false)));
		return user;
	}
}
