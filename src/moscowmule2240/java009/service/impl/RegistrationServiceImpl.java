/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.service.RegistrationService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ユーザー登録サービス。
 * 
 * @author moscowmule2240
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.RegistrationService#registration(moscowmule2240.java009.bean.User)
	 */
	@Override
	public int registration(User user) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.insert(user);
	}
}
