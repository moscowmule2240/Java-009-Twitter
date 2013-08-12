/**
 * ミニブログ。
 */
package moscowmule2240.java009.bean;

/**
 * ユーザー情報。
 *
 * @author moscowmule2240
 */
public class User {

	/**
	 * ユーザーID。
	 */
	private Long userId;

	/**
	 * ユーザー名。
	 */
	private String userName;

	/**
	 * 名前。
	 */
	private String displayName;

	/**
	 * パスワード。
	 */
	private String password;

	/**
	 * 自己紹介。
	 */
	private String introduction;

	/**
	 * フォロー。
	 */
	private Boolean isFollow;

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
	 * ユーザー名を取得します。
	 *
	 * @return ユーザー名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * ユーザー名を設定します。
	 *
	 * @param userName
	 *            設定するユーザー名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 名前を取得します。
	 *
	 * @return 名前
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * 名前を設定します。
	 *
	 * @param displayName
	 *            設定する名前
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * パスワードを取得します。
	 *
	 * @return パスワード
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * パスワードを設定します。
	 *
	 * @param password
	 *            設定するパスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * introductionを取得します。
	 *
	 * @return introduction
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * 自己紹介を設定します。
	 *
	 * @param introduction
	 *            設定する自己紹介
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * フォローを取得します。
	 *
	 * @return フォロー
	 */
	public Boolean getFollow() {
		return this.isFollow;
	}

	/**
	 * フォローを設定します。
	 *
	 * @param isFollow
	 *            設定するフォロー
	 */
	public void setFollow(Boolean isFollow) {
		this.isFollow = isFollow;
	}
}
