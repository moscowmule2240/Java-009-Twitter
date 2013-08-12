/**
 * ミニブログ。
 */
package moscowmule2240.java009.bean;

import java.sql.Timestamp;

/**
 * メッセージ情報。
 * 
 * @author moscowmule2240
 */
public class Direct {

	/**
	 * メッセージID。
	 */
	private Long messageId;

	/**
	 * 送信者ユーザーID。
	 */
	private Long userId;

	/**
	 * 送信者名。
	 */
	private String displayName;

	/**
	 * 受信者ユーザーID。
	 */
	private Long userIdReceiver;

	/**
	 * 受信者名。
	 */
	private String userIdReceiverDisplayName;

	/**
	 * 送信日時。
	 */
	private Timestamp messageTime;

	/**
	 * メッセージ。
	 */
	private String message;

	/**
	 * messageIdを取得します。
	 * 
	 * @return messageId
	 */
	public Long getMessageId() {
		return this.messageId;
	}

	/**
	 * messageIdを設定します。
	 * 
	 * @param messageId
	 *            設定するmessageId
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * userIdを取得します。
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * userIdを設定します。
	 * 
	 * @param userId
	 *            設定するuserId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * displayNameを取得します。
	 * 
	 * @return displayName
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * displayNameを設定します。
	 * 
	 * @param displayName
	 *            設定するdisplayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * userIdReciverを取得します。
	 * 
	 * @return userIdReceiver
	 */
	public Long getUserIdReceiver() {
		return this.userIdReceiver;
	}

	/**
	 * userIdReciverを設定します。
	 * 
	 * @param userIdReceiver
	 *            設定するuserIdReciver
	 */
	public void setUserIdReceiver(Long userIdReceiver) {
		this.userIdReceiver = userIdReceiver;
	}

	/**
	 * userIdReciverDisplayNameを取得します。
	 * 
	 * @return userIdReceiverDisplayName
	 */
	public String getUserIdReceiverDisplayName() {
		return this.userIdReceiverDisplayName;
	}

	/**
	 * userIdReciverDisplayNameを設定します。
	 * 
	 * @param userIdReceiverDisplayName
	 *            設定するuserIdReciverDisplayName
	 */
	public void setUserIdReciverDisplayName(String userIdReceiverDisplayName) {
		this.userIdReceiverDisplayName = userIdReceiverDisplayName;
	}

	/**
	 * messageTimeを取得します。
	 * 
	 * @return messageTime
	 */
	public Timestamp getMessageTime() {
		return this.messageTime;
	}

	/**
	 * messageTimeを設定します。
	 * 
	 * @param messageTime
	 *            設定するmessageTime
	 */
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}

	/**
	 * messageを取得します。
	 * 
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * messageを設定します。
	 * 
	 * @param message
	 *            設定するmessage
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
