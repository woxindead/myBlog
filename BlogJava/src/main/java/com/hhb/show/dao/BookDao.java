package com.hhb.show.dao;

import com.hhb.show.entity.Book;
import com.hhb.show.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keywords1,String keywords2);
}
