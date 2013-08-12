/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.utility.Utility;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

/**
 * メッセージストレージマッピング用のクラスです。
 * 
 * @author moscowmule2240
 */
@Component
public class DirectRowMapper implements ParameterizedRowMapper<Direct> {

	/*
	 * (非 Javadoc)
	 * @see org.springframework.jdbc.core.simple.ParameterizedRowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Direct mapRow(ResultSet rs, int rowNum) throws SQLException {
		Direct direct = new Direct();
		direct.setMessageId(Utility.getDatabaseData(rs, "messageid", new Long(0)));
		direct.setUserId(Utility.getDatabaseData(rs, "userid", new Long(0)));
		direct.setDisplayName(rs.getString("displayName"));
		direct.setUserIdReceiver(Utility.getDatabaseData(rs, "useridreceiver", new Long(0)));
		direct.setUserIdReciverDisplayName(rs.getString("useridreceiverdisplayname"));
		direct.setMessageTime(rs.getTimestamp("messagetime"));
		direct.setMessage(rs.getString("message"));
		return direct;
	}
}
