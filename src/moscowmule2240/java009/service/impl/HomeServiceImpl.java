/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import java.util.List;

import moscowmule2240.java009.bean.Tweet;
import moscowmule2240.java009.bean.User;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.TweetDao;
import moscowmule2240.java009.service.HomeService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ツイート登録サービス。
 * 
 * @author moscowmule2240
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.HomeService#getTimeLine(moscowmule2240.java009.bean.User)
	 */
	@Override
	public List<Tweet> getTimeLine(User user) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		TweetDao tweetDao = (TweetDao) beanFactory.getBean("tweetDao");
		return tweetDao.findTimeLineByUserId(user.getUserId());
	}

}
