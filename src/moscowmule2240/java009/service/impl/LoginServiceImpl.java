/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.service.LoginService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ログインサービス。
 * 
 * @author moscowmule2240
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.LoginService#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String userName, String password) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findByUserNameAndPassword(userName, password);
	}
}
