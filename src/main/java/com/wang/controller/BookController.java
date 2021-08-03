package com.wang.controller;


import com.wang.pojo.Books;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Controller层调用Service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回一个书籍展示页面
    @RequestMapping("/allBooks")
    public String list(Model model){
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBooks";
    }
    //跳转到增加书籍的页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBooks";
    }
    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBooksById(id);
        model.addAttribute("queryBooks",books);
        return "updateBook";
    }
    //修改页面的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBooks";
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBooks";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBooksByName(queryBookName);

        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null){
            list = bookService.queryAllBooks();
            model.addAttribute("error","未查到书籍！");
        }
        model.addAttribute("list",list);
        return "allBooks";
    }

}
