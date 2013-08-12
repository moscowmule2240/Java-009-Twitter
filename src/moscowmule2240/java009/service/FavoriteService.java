/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

/**
 * お気に入り登録サービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface FavoriteService {

	/**
	 * 指定したツイートをお気に入りとして登録、または解除します。
	 * 
	 * @param favorite
	 *            現在のお気に入り状態
	 * @param userId
	 *            ユーザーID
	 * @param tweetId
	 *            ツイートID
	 * @return 登録件数
	 */
	public int registration(boolean favorite, Long userId, Long tweetId);

}
