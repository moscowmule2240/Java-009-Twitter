/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import java.util.List;

import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.service.AddressService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ログインサービス。
 *
 * @author moscowmule2240
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.AddressService#getUsers(java.lang.Long)
	 */
	@Override
	public List<User> getUsers(Long userId) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findEachFollowsByUserId(userId);
	}
}
