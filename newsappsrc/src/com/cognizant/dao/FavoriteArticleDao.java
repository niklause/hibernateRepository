package com.cognizant.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.entity.FavoriteArticle;
import com.cognizant.entity.User;

public interface FavoriteArticleDao extends CrudRepository<FavoriteArticle, Integer> {
	FavoriteArticle findByArticleIdAndUser(int articleId, User user);
}