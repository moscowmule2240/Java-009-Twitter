/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.service.MessageService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 秘密メッセージアクション。
 * 
 * @author moscowmule2240
 */
public class MessageAction extends Action {

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
			Long userId = (Long) dynaActionForm.get("userId");

			// 検索
			User user = this.messageService.getUser(userId);
			request.setAttribute("reciveUser", user);

			return mapping.findForward("success");

		} catch (Exception e) {
			e.printStackTrace();
			ActionMessages errors = new ActionMessages();
			errors.add("message", new ActionMessage("errors.databaseaccess"));
			this.saveErrors(request, errors);
			return mapping.findForward("error");
		}
	}
}
