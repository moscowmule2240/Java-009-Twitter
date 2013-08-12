/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import moscowmule2240.java009.bean.Tweet;

/**
 * ツイートサービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface TweetService {

	/**
	 * ツイートを登録します。
	 * 
	 * @param tweet
	 *            登録するツイート
	 * @return 登録件数
	 */
	public int tweet(Tweet tweet);

}
