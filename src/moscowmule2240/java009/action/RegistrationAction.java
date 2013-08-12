/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.RegistrationService;
import moscowmule2240.java009.utility.Utility;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ユーザー登録アクション。
 * 
 * @author moscowmule2240
 */
public class RegistrationAction extends Action {

	/**
	 * 登録サービス。
	 */
	@Autowired
	private RegistrationService registrationService;

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
			String userName = dynaValidatorForm.getString("userName");
			String displayName = dynaValidatorForm.getString("displayName");
			String password = dynaValidatorForm.getString("password");
			String introduction = dynaValidatorForm.getString("introduction");

			// 登録内容設定
			User user = new User();
			user.setUserName(userName);
			user.setDisplayName(displayName);
			user.setPassword(password);
			user.setIntroduction(introduction);

			// 登録
			int updateCount = this.registrationService.registration(user);
			if (updateCount == 0) {
				throw new Exception("登録件数が０件です。");
			}

			// 正常終了
			return mapping.findForward("success");
		} catch (Exception e) {

			ActionMessages errors = new ActionMessages();
			SQLException exception = Utility.getSQLException(e);
			if ((exception != null) && (exception.getErrorCode() == Constants.SQL_ERROR_CODE_MYSQL_DUPLICATE)) {

				// ユーザ名一意制約違反時
				errors.add("userName", new ActionMessage("registration.errors.unique", this.getResources(request).getMessage("registration.form.userName")));
			} else {

				// その他例外発生時
				e.printStackTrace();
				errors.add("message", new ActionMessage("errors.databaseaccess"));
			}
			this.saveErrors(request, errors);
			return mapping.findForward("error");
		}
	}
}
