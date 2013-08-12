/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.service.ProfileService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * プロフィールアクション。
 *
 * @author moscowmule2240
 */
public class ProfileAction extends Action {

	/**
	 * プロフィールサービス。
	 */
	@Autowired
	private ProfileService profileService;

	/*
	 * (非 Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 検索対象取得
			DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
			Long userId = (Long) dynaValidatorForm.get("userId");
			String method = dynaValidatorForm.getString("method");

			// ユーザー情報検索
			User user = this.profileService.getUser(userId);
			request.setAttribute("user", user);

			// セッションから閲覧者のユーザー情報取得
			User userSession = (User) request.getSession().getAttribute(Constants.REGISTRATION_USER_INFOMATION_KEY);
			Long userIdSession;
			if (userSession == null) {
				userIdSession = null;
			} else {
				userIdSession = userSession.getUserId();
			}

			// 検索
			List<Tweet> tweetList;
			List<User> usersList;
			switch (method) {
			case "tweet":
				tweetList = this.profileService.getTweets(userIdSession, userId);
				request.setAttribute("tweetList", tweetList);
				break;
			case "follow":
				usersList = this.profileService.getFollows(userIdSession, userId);
				request.setAttribute("usersList", usersList);
				break;
			case "follower":
				usersList = this.profileService.getFollowers(userIdSession, userId);
				request.setAttribute("usersList", usersList);
				break;
			case "favorite":
				tweetList = this.profileService.getFavorites(userIdSession, userId);
				request.setAttribute("tweetList", tweetList);
				break;
			default:
				throw new Exception("不正な値が指定されました。method:[" + method + "]");
			}

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
