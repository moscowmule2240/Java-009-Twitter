/**
 * ミニブログ。
 */
package moscowmule2240.java009.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.service.SearchService;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.validator.DynaValidatorForm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 検索アクション
 * 
 * @author moscowmule2240
 */
public class SearchAction extends LookupDispatchAction {

	/**
	 * 検索サービス。
	 */
	@Autowired
	private SearchService searchService;

	/*
	 * (非 Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<>();
		map.put("from.button.search.user", "searchUser");
		map.put("from.button.search.tweet", "serchTweet");
		return map;
	}

	/**
	 * ユーザー検索を行います。
	 * 
	 * @param mapping
	 *            mapping
	 * @param form
	 *            form
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @return ActionForward
	 * @throws Exception
	 *             Exception
	 */
	public ActionForward searchUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 入力値取得
			DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
			String userName = dynaValidatorForm.getString("searchValue");

			// 検索
			List<User> usersList = this.searchService.getUser(userName);
			request.setAttribute("usersList", usersList);

			return mapping.findForward("success");

		} catch (Exception e) {
			e.printStackTrace();
			ActionMessages errors = new ActionMessages();
			errors.add("message", new ActionMessage("errors.databaseaccess"));
			this.saveErrors(request, errors);
			return mapping.findForward("error");
		}
	}

	/**
	 * ツイート検索を行います。
	 * 
	 * @param mapping
	 *            mapping
	 * @param form
	 *            form
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @return ActionForward
	 * @throws Exception
	 *             Exception
	 */
	public ActionForward serchTweet(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			// 入力値取得
			DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
			String tweet = dynaValidatorForm.getString("searchValue");

			// 検索
			List<Tweet> timeLineList = this.searchService.getTimeLine(tweet);
			request.setAttribute("timeLineList", timeLineList);

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
