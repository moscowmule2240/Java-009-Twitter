/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.FavoriteService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * お気に入り登録アクション。
 * 
 * @author moscowmule2240
 */
public class FavoriteAction extends Action {

	/**
	 * お気に入りサービス。
	 */
	@Autowired
	private FavoriteService favoriteService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 入力値取得
			DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
			Long tweetId = (Long) dynaValidatorForm.get("tweetId");
			boolean favoriteValue = (Boolean) dynaValidatorForm.get("favorite");

			// セッションに取得したユーザー情報を登録
			User user = (User) request.getSession().getAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY);

			// 登録
			this.favoriteService.registration(favoriteValue, user.getUserId(), tweetId);

			return mapping.findForward("success");

		} catch (Exception e) {
			ActionMessages errors = new ActionMessages();
			errors.add("message", new ActionMessage("errors.databaseaccess"));
			this.saveErrors(request, errors);
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}
}
