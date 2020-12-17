package com.hhb.show.dao;

import com.hhb.show.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDAO extends JpaRepository<Article,Integer> {
    Article findById(int id);
}
