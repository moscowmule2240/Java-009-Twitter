/**
 * ミニブログ。
 */
package moscowmule2240.java009.bean;

import java.sql.Timestamp;

/**
 * ツイート情報。
 * 
 * @author moscowmule2240
 */
public class Tweet {

	/**
	 * ツイートID。
	 */
	private Long tweetId;

	/**
	 * ツイートしたユーザーID。
	 */
	private Long userId;

	/**
	 * ツイートした日時。
	 */
	private Timestamp tweetTime;

	/**
	 * ツイート内容；
	 */
	private String tweet;

	/**
	 * 名前。
	 */
	private String displayName;

	/**
	 * お気に入り。
	 */
	private Boolean isFavorite;

	/**
	 * ツイートIDを取得します。
	 * 
	 * @return ツイートID
	 */
	public Long getTweetId() {
		return this.tweetId;
	}

	/**
	 * ツイートIDを設定します。
	 * 
	 * @param tweetId
	 *            設定するツイートID
	 */
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	/**
	 * ツイートしたユーザーIDを取得します。
	 * 
	 * @return ツイートしたユーザーID
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * ツイートしたユーザーIDを設定します。
	 * 
	 * @param userId
	 *            設定するツイートしたユーザーID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * ツイートした日時を取得します。
	 * 
	 * @return ツイートした日時
	 */
	public Timestamp getTweetTime() {
		return this.tweetTime;
	}

	/**
	 * ツイートした日時を設定します。
	 * 
	 * @param tweetTime
	 *            設定するツイートした日時
	 */
	public void setTweetTime(Timestamp tweetTime) {
		this.tweetTime = tweetTime;
	}

	/**
	 * ツイート内容を取得します。
	 * 
	 * @return ツイート内容
	 */
	public String getTweet() {
		return this.tweet;
	}

	/**
	 * ツイート内容を設定します。
	 * 
	 * @param tweet
	 *            設定するツイート内容
	 */
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	/**
	 * 名前を取得します。
	 * 
	 * @return 名前
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * 名前を設定します。
	 * 
	 * @param displayName
	 *            設定する名前
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * お気に入りを取得します。
	 * 
	 * @return お気に入り
	 */
	public Boolean getFavorite() {
		return this.isFavorite;
	}

	/**
	 * お気に入りを設定します。
	 * 
	 * @param isFavorite
	 *            設定するお気に入り
	 */
	public void setFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
}
