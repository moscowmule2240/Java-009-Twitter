/**
 * ミニブログ。
 */
package moscowmule2240.java009.dao;

import java.util.List;

import moscowmule2240.java009.bean.Direct;

/**
 * DirectストレージへアクセスするためのDAOインターフェース。
 * 
 * @author moscowmule2240
 */
public interface DirectDao {

	/**
	 * メッセージ一覧を表示するためのSQLを示す定数です。
	 */
	final String SELECT_MESSAGES_SQL = "select di.messageid, us1.userid, us1.displayname, us2.userid as useridreceiver, us2.displayname as useridreceiverdisplayname, di.messagetime, di.message from directs as di left join users as us1 on di.userid = us1.userid left join users as us2 on di.useridreceiver = us2.userid where (di.userid = ? and di.useridreceiver = ?) or(di.userid = ? and di.useridreceiver = ?) order by di.messagetime desc, di.messageid asc";

	/**
	 * 登録を行うためのSQLを示す定数です。
	 */
	final String INSERT_SQL = "insert into directs (userid, useridreceiver, message) values (?, ?, ?)";

	/**
	 * 指定されたメッセージを登録します。
	 * 
	 * @param direct
	 *            登録するメッセージ
	 * @return 登録した件数
	 */
	public int insert(Direct direct);

	/**
	 * メッセージ一覧を取得します。
	 * 
	 * @param userId
	 *            閲覧者
	 * @param reciveUserId
	 *            宛先
	 * @return メッセージ一覧
	 */
	public List<Direct> getMessages(Long userId, Long reciveUserId);

}
