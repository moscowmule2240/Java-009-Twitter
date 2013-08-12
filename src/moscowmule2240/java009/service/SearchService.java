/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;

/**
 * 検索サービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface SearchService {

	/**
	 * 検索する値がツイート内容にヒットするタイムラインを取得します。
	 * 
	 * @param tweet
	 *            検索する値
	 * @return タイムライン
	 */
	public List<Tweet> getTimeLine(String tweet);

	/**
	 * 検索する値がユーザー名にヒットするユーザー情報を取得します。
	 * 
	 * @param userName
	 *            検索する値
	 * @return ユーザー情報
	 */
	public List<User> getUser(String userName);

}
