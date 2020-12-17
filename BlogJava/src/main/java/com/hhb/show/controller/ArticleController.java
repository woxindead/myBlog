package com.hhb.show.controller;

import com.hhb.show.entity.Article;
import com.hhb.show.result.Result;
import com.hhb.show.result.ResultFactory;
import com.hhb.show.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    //获取文章列表接口
    @CrossOrigin
    @GetMapping("/api/articles")
    public List<Article> list() throws Exception{
        return articleService.list();
    }
    //获取单个文章详情
    @CrossOrigin
    @GetMapping("/api/articles/{id}")
    public Result getArticleDetails(@PathVariable("id") int id){
        return ResultFactory.buildSuccessResult(articleService.findById(id));
    }

    /**
     * 给文章点赞
     * @param article
     * @return
     */
    @CrossOrigin
    @PostMapping("/api/articles/{id}/addCount")
    public Result getAddCount(@RequestBody @Valid Article article){
        article.setArticleLikeCount(article.getArticleLikeCount()+1);
        return ResultFactory.buildSuccessResult("点赞成功");
    }
    
}
