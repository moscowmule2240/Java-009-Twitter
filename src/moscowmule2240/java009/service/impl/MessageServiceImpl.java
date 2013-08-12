/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import java.util.List;

import moscowmule2240.java009.bean.Direct;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.DirectDao;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.service.MessageService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * メッセージサービス。
 * 
 * @author moscowmule2240
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.MessageService#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long userId) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.MessageService#getMessages(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Direct> getMessages(Long userId, Long reciveUserId) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		DirectDao directDao = (DirectDao) beanFactory.getBean("directDao");
		return directDao.getMessages(userId, reciveUserId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.MessageService#message(moscowmule2240.java009.bean.Direct)
	 */
	@Override
	public int message(Direct direct) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		DirectDao directDao = (DirectDao) beanFactory.getBean("directDao");
		return directDao.insert(direct);
	}
}
