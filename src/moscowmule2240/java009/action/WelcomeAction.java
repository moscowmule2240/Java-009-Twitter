/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ツイートアクション。
 * 
 * @author moscowmule2240
 */
public class WelcomeAction extends Action {

	/*
	 * (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// セッションからユーザー情報取得
			User user = (User) request.getSession().getAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY);

			if (user == null) {
				return mapping.findForward("welcome");
			}
			return mapping.findForward("home");

		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
}
