/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;

/**
 * プロフィールサービスインターフェース。
 *
 * @author moscowmule2240
 */
public interface ProfileService {

	/**
	 * ユーザー情報を取得します。
	 *
	 * @param userId
	 *            ユーザーID
	 * @return ユーザー情報
	 */
	public User getUser(Long userId);

	/**
	 * ツイートを取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdTweet
	 *            取得対象ユーザーID
	 * @return ツイート
	 */
	public List<Tweet> getTweets(Long userId, Long userIdTweet);

	/**
	 * フォローしているユーザー情報を取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdTweet
	 *            取得対象ユーザーID
	 * @return ユーザー情報
	 */
	public List<User> getFollows(Long userId, Long userIdFollow);

	/**
	 * フォロワーのユーザー情報を取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdFollower
	 *            取得対象ユーザーID
	 * @return ユーザー情報
	 */
	public List<User> getFollowers(Long userId, Long userIdFollower);

	/**
	 * お気に入りを取得します。
	 *
	 * @param userId
	 *            閲覧しているユーザーのユーザーID
	 * @param userIdFavorite
	 *            取得対象ユーザーID
	 * @return お気に入り
	 */
	public List<Tweet> getFavorites(Long userId, Long userIdFavorite);

}
