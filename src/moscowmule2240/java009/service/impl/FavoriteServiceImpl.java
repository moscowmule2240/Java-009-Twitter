/**
 * ミニブログ。
 */
package moscowmule2240.java009.service.impl;

import moscowmule2240.java009.bean.Favorite;
import moscowmule2240.java009.constant.Constants;
import moscowmule2240.java009.dao.FavoriteDao;
import moscowmule2240.java009.service.FavoriteService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * お気に入り登録サービス。
 * 
 * @author moscowmule2240
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

	/*
	 * (non-Javadoc)
	 * @see moscowmule2240.java009.service.FavoriteService#registration(boolean, java.lang.Long, java.lang.Long)
	 */
	@Override
	public int registration(boolean isFavorite, Long userId, Long tweetId) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(Constants.CONTEXT_PATH);
		FavoriteDao favoriteDao = (FavoriteDao) beanFactory.getBean("favoriteDao");
		Favorite favorite = new Favorite();
		favorite.setUserId(userId);
		favorite.setTweetId(tweetId);
		if (isFavorite) {
			return favoriteDao.delete(favorite);
		}
		return favoriteDao.insert(favorite);
	}
}
