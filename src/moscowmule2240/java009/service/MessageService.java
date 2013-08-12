/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import java.util.List;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.bean.User;

/**
 * メッセージサービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface MessageService {

	/**
	 * ユーザー情報を取得します。
	 * 
	 * @param userId
	 *            ユーザーID
	 * @return ユーザー情報
	 */
	public User getUser(Long userId);

	/**
	 * 秘密メッセージ一覧を取得します。
	 * 
	 * @param userId
	 *            閲覧者
	 * @param reciveUserId
	 *            宛先
	 * @return メッセージ一覧
	 */
	public List<Direct> getMessages(Long userId, Long reciveUserId);

	/**
	 * 秘密メッセージを登録します。
	 * 
	 * @param direct
	 *            メッセージ
	 * @return 登録件数
	 */
	public int message(Direct direct);

}
