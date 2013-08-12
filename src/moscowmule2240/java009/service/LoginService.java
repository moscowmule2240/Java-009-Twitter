/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import moscowmule2240.java009.bean.User;

/**
 * ログインサービスインターフェース。
 * 
 * @author moscowmule2240
 */
public interface LoginService {

	/**
	 * ユーザー情報を取得します。
	 * 
	 * @param userName
	 *            ユーザー名
	 * @param password
	 *            パスワード
	 * @return ユーザー情報
	 */
	public User getUser(String userName, String password);

}
