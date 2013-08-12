/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.MessageService;
import net.arnx.jsonic.JSON;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 秘密メッセージアクション。
 * 
 * @author moscowmule2240
 */
public class ReciveMessageAction extends Action {

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
			DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
			Long reciveUserId = (Long) dynaValidatorForm.get("reciveUserId");

			// セッションからユーザー情報取得
			User user = (User) request.getSession().getAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY);

			// 検索
			List<Direct> directList = this.messageService.getMessages(user.getUserId(), reciveUserId);

			response.setContentType("Content-Type: application/json; charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JSON.encode(directList));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
