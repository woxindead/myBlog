package com.hhb.show.service;

import com.hhb.show.dao.BookDao;
import com.hhb.show.dao.CategoryDAO;
import com.hhb.show.entity.Book;
import com.hhb.show.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    CategoryService categoryService;

    //图书列表
    public List<Book> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return bookDao.findAll(sort);
    }
    //按分类查询图书列表
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findByCategory(category);
    }
    //图书详情
    public Optional<Book> findById(int id) {
        return bookDao.findById(id);
    }
}
