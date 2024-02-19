package com.example.LibabraryManagement.controller;

import com.example.LibabraryManagement.Entity.Book;
import com.example.LibabraryManagement.service.AuthorService;
import com.example.LibabraryManagement.service.BookService;
import com.example.LibabraryManagement.service.CategoryService;
import com.example.LibabraryManagement.service.PublisherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private static final Logger LOGGER = LogManager.getLogger(BookService.class);
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";

    }

    @GetMapping("/book/{id}")
    private String findBook(@PathVariable long id, Model model) {
        LOGGER.info("This method is used to find book by using Id: Book Controller");
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    private String deleteBook(@PathVariable long id, Model model) {
        LOGGER.info("This method is used to delete book by using Id: Book Controller");
        bookService.deleteBookById(id);
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book";
        }
        bookService.updateBookById(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/books";
    }
    @GetMapping("/add-book")
    public String addBook(Book book,Model model)
    {
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("publishers",publisherService.getAllPublishers());
        model.addAttribute("authors",authorService.getAllAuthors());
        return "add-book";
    }
    @PostMapping("/save-book")
    public String addBook(Book book,Model model,BindingResult result)
    {
        if(result.hasErrors())
        {
            return "add-book";
        }
        bookService.saveBooks(book);
        model.addAttribute("books",bookService.getAllBooks());
        return "redirect:/books";
    }
}
