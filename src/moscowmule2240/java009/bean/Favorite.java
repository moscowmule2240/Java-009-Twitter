/**
 * ミニブログ。
 */
package moscowmule2240.java009.bean;

/**
 * お気に入り情報。
 * 
 * @author moscowmule2240
 */
public class Favorite {

	/**
	 * ユーザーID。
	 */
	private Long userId;

	/**
	 * ツイートID。
	 */
	private Long tweetId;

	/**
	 * ユーザーIDを取得します。
	 * 
	 * @return ユーザーID
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * ユーザーIDを設定します。
	 * 
	 * @param userId
	 *            設定するユーザーID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

}
