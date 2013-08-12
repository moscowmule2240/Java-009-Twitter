/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import moscowmule2240.java009.bean.User;

/**
 * 登録サービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface RegistrationService {

	/**
	 * ユーザーを登録します。
	 * 
	 * @param user
	 *            登録ユーザー
	 * @return 登録件数
	 */
	public int registration(User user);
}
