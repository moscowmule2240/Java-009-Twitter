/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.utility.Utility;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

/**
 * ツイートストレージマッピング用のクラスです。
 * 
 * @author moscowmule2240
 */
@Component
public class TweetRowMapper implements ParameterizedRowMapper<Tweet> {

	/*
	 * (非 Javadoc)
	 * @see org.springframework.jdbc.core.simple.ParameterizedRowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tweet tweet = new Tweet();
		tweet.setTweetId(Utility.getDatabaseData(rs, "tweetid", new Long(0)));
		tweet.setUserId(Utility.getDatabaseData(rs, "userid", new Long(0)));
		tweet.setTweetTime(rs.getTimestamp("tweettime"));
		tweet.setTweet(rs.getString("tweet"));
		tweet.setDisplayName(rs.getString("displayname"));
		tweet.setFavorite(Utility.getDatabaseData(rs, "favorite", new Boolean(false)));
		return tweet;
	}
}
