/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.LoginService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * ログインアクション。
 * 
 * @author moscowmule2240
 */
public class LoginAction extends Action {

	/**
	 * ログインサービス。
	 */
	@Autowired
	private LoginService loginService;

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
			String userName = dynaActionForm.getString("userName");
			String password = dynaActionForm.getString("password");

			// 検索
			User user = this.loginService.getUser(userName, password);

			// セッションに取得したユーザー情報を登録
			request.getSession().setAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY, user);
			return mapping.findForward("success");

		} catch (EmptyResultDataAccessException e) {

			// ユーザー名、パスワードが一致していない場合
			ActionMessages errors = new ActionMessages();
			errors.add("message", new ActionMessage("login.errors.nodata"));
			this.saveErrors(request, errors);
			return mapping.findForward("error");

		} catch (Exception e) {
			e.printStackTrace();
			ActionMessages errors = new ActionMessages();
			errors.add("message", new ActionMessage("errors.databaseaccess"));
			this.saveErrors(request, errors);
			return mapping.findForward("error");
		}
	}
}
