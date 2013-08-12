/**
 * ミニブログ。
 */
package moscowmule2240.java009.service;

import java.util.List;

import moscowmule2240.java009.bean.User;

/**
 * ログインサービスインターフェース。
 *
 * @author moscowmule2240
 */
public interface AddressService {

	/**
	 * 相互フォローのユーザー情報を取得します。
	 *
	 * @param userId 閲覧者
	 * @return 相互フォローユーザー情報
	 */
	public List<User> getUsers(Long userId);

}
