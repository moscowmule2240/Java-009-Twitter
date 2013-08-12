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
import moscowmule2240.java009.service.ProfileService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * プロフィールサービス。
 *
 * @author moscowmule2240
 */
@Service("profileService")
public class ProfileServiceImple implements ProfileService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.ProfileService#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long userId) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.ProfileService#getTweets(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Tweet> getTweets(Long userId, Long userIdTweet) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		TweetDao tweetDao = (TweetDao) beanFactory.getBean("tweetDao");
		return tweetDao.findByUserId(userId, userIdTweet);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.ProfileService#getFollows(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<User> getFollows(Long userId, Long userIdFollow) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findFollowByUserId(userId, userIdFollow);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.ProfileService#getFollowers(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<User> getFollowers(Long userId, Long userIdFollower) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");
		return userDao.findFollowerByUserId(userId, userIdFollower);
	}

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.ProfileService#getFavorites(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Tweet> getFavorites(Long userId, Long userIdFavorite) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		TweetDao tweetDao = (TweetDao) beanFactory.getBean("tweetDao");
		return tweetDao.findFavoriteByUserId(userId, userIdFavorite);
	}
}
