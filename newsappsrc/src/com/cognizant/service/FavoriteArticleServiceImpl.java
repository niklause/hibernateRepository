package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.FavoriteArticleDao;
import com.cognizant.entity.FavoriteArticle;
import com.cognizant.entity.User;
@Service
public class FavoriteArticleServiceImpl implements FavoriteArticleService {
	
	@Autowired
	private FavoriteArticleDao favoriteArticleDao;
	
	@Override
	public FavoriteArticle save(FavoriteArticle favoriteArticle) {
		return favoriteArticleDao.save(favoriteArticle);
	}

	@Override
	public void delete(FavoriteArticle favoriteArticle) {
		favoriteArticleDao.delete(favoriteArticle);
	}

	//void removeByArticleId(int articleId, User user);
	@Override
	public void removeByArticleId(int articleId, User user) {
		FavoriteArticle favoriteArticle = favoriteArticleDao.findByArticleIdAndUser(articleId, user);
		
		delete(favoriteArticle);
		
	}
}