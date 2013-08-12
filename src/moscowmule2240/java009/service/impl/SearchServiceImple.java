/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.TweetDao;
import moscowmule2240.java009.dao.UserDao;
import moscowmule2240.java009.service.SearchService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 検索サービス。
 * 
 * @author moscowmule2240
 */
@Service("searchService")
public class SearchServiceImple implements SearchService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.SearchService#getTimeLine(java.lang.String)
	 */
	@Override
	public List<Tweet> getTimeLine(String tweet) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		TweetDao tweetDao = (TweetDao) beanFactory.getBean("tweetDao");
		return tweetDao.findTimeLineBySearchValue(tweet);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.SearchService#getUser(java.lang.String)
	 */
	@Override
	public List<User> getUser(String userName) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findByUserNameLike(userName);
	}
}
