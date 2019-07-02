package com.cognizant.service;

import com.cognizant.entity.FavoriteArticle;
import com.cognizant.entity.User;

public interface FavoriteArticleService {
	FavoriteArticle save(FavoriteArticle favoriteArticle);
	void delete(FavoriteArticle favoriteArticle);
	void removeByArticleId(int articleId, User user);
}