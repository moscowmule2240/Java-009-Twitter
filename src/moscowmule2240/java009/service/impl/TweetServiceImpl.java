/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.TweetDao;
import moscowmule2240.java009.service.TweetService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ツイート登録サービス。
 * 
 * @author moscowmule2240
 */
@Service("tweetService")
public class TweetServiceImpl implements TweetService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.TweetService#tweet(moscowmule2240.java009.bean.Tweet)
	 */
	@Override
	public int tweet(Tweet tweet) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		TweetDao tweetDao = (TweetDao) beanFactory.getBean("tweetDao");
		return tweetDao.insert(tweet);
	}
}
