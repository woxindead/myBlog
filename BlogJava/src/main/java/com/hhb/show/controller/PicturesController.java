package com.hhb.show.controller;

import com.hhb.show.entity.Book;
import com.hhb.show.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PicturesController {
    @Autowired
    BookService bookService;
    //获取所有图书列表
    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception{
        return bookService.list();
    }
    //根据分类id获取对应图书列表
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }
    //获取单个图书详情
    @CrossOrigin
    @GetMapping("/api/books/{id}")
    public Optional<Book> getBookDetails(@PathVariable("id") int id){
        return bookService.findById(id);
    }
}
