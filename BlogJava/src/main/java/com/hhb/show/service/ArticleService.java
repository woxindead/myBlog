package com.hhb.show.service;

import com.hhb.show.dao.ArticleDAO;
import com.hhb.show.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleDAO articleDAO;

    /**
     * 读取文章列表
     * @return
     */
    public List<Article> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return articleDAO.findAll(sort);
    }

    /**
     * 读取文章详情
     * @param id
     * @return
     */
    public Object findById(int id) {
        return articleDAO.findById(id);
    }

    /**
     * 更新文章
     * @param article
     */
    public void updateArticle(Article article){
        articleDAO.save(article);
    }

}
