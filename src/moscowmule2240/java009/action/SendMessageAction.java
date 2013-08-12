/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.MessageService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 秘密メッセージアクション。
 * 
 * @author moscowmule2240
 */
public class SendMessageAction extends Action {

	/**
	 * 秘密メッセージサービス。
	 */
	@Autowired
	private MessageService messageService;

	/*
	 * (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 入力値取得
			DynaActionForm dynaActionForm = (DynaActionForm) form;
			Long receiverUserId = (Long) dynaActionForm.get("reciveUserId");
			String message = dynaActionForm.getString("message");

			// セッションからユーザー情報取得
			User user = (User) request.getSession().getAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY);

			// 登録内容設定
			Direct direct = new Direct();
			direct.setUserId(user.getUserId());
			direct.setUserIdReceiver(receiverUserId);
			direct.setMessage(message);

			// 登録
			int updateCount = this.messageService.message(direct);
			if (updateCount == 0) {
				throw new Exception("登録件数が０件です。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
