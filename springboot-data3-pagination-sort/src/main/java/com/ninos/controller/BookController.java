package com.ninos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.entity.Book;
import com.ninos.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repo;

	// paging

	// http://localhost:8080/books/page?page=0&size=3   it will return all books , page=0 meaning firstPage size=3 meaning will return 3 books
	@GetMapping("/books/page")
	public Page<Book> findAllBooks(Pageable page) {
		return repo.findAll(page);
	}

	// http://localhost:8080/books/pagetitle?title=a     it will return books based on title (it will start from a then b then ....)
	@GetMapping("/books/pagetitle")
	public Page<Book> getBooksBypage(@RequestParam Optional<String> title) {
		return (Page<Book>) repo.findByTitleContaining(title.orElse("_"), PageRequest.of(0, 3, Sort.by("title")));
	}

	  
	@GetMapping("/books/pageid")  //http://localhost:8080/books/pageid?title=a  it will return books based on id  (first will check number 1 then 2 then ....)
	public Page<Book> getBooksByid(@RequestParam Optional<String> title) {
		return (Page<Book>) repo.findByTitleContaining(title.orElse("_"), PageRequest.of(0, 3, Sort.by("id")));
	}
	
	
	@GetMapping("/books/pagedd")  //http://localhost:8080/books/pageid?title=a  it will return books based on id  (last id then before last then ....)
	public Page<Book> getBooksBydd(@RequestParam Optional<String> title,Pageable page) {
		return (Page<Book>) repo.findByTitleContaining(title.orElse("_"), PageRequest.of(0, 3, Sort.by("id").descending()));
	}
	
	
	// http://localhost:8080/books/pagecount
	@GetMapping("/books/pagecount")
	public List<Book> getBooksBypagecount() {
		return repo.findByPageCountGreaterThan(33, PageRequest.of(0, 3));
	}
	
	
	// http://localhost:8080/books/pagecount
	@GetMapping("/books/page-asc")
	public Page<Book> getBooksasc() {
		return repo.findAll(PageRequest.of(0, 3,Sort.by("pageCount").descending()));
	}
	
	
    // http://localhost:8080/books/pageauthor    it will return all the books (pageCount greater than 33) based on author first name
	@GetMapping("/books/pageauthor")
	public List<Book> getBooksBypageauthor() {
		return repo.findByPageCountGreaterThan(33,Sort.by("author.firstName"));
	}
	
	
	
	
	
	
	
	
	
	
	

}
