/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;

/**
 * お気に入り登録サービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface HomeService {

	/**
	 * 指定したユーザーのタイムラインを取得します。
	 * 
	 * @param user
	 *            ユーザー
	 * @return タイムライン
	 */
	public List<Tweet> getTimeLine(User user);

}
