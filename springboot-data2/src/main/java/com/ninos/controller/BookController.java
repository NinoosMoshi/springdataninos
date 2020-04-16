package com.ninos.controller;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ninos.entity.Book;
import com.ninos.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repo;

//	@GetMapping("/books")
//	public List<Book> getBooks() {
//		return repo.queryone();
//	}
	
	
//	@GetMapping("/books/title")
//	public List<Book> getBooksByTitle(@RequestParam("title") String title) {
//		return repo.querytow(title);
//	}

//	@GetMapping("/books/title-param")
//	public List<Book> getBooksByTitleparam(@RequestParam("title") String title) {
//		return repo.querythree(title);
//	}
	
	
	// paging
	@GetMapping("/books/page")
	public Page<Book> getBooksBypage(@RequestParam Optional<String> title) { 
		return (Page<Book>) repo.findByTitle(title.orElse("_"), PageRequest.of(0, 3,Sort.by("id")));
	}
	
	
	


}
