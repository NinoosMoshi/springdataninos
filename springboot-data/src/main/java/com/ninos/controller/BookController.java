package com.ninos.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.entity.Book;
import com.ninos.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repo;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return repo.findAll();
	}

	@GetMapping("/books/title")
	public List<Book> getBooksByTitle(@RequestParam("title") String title) {
		return repo.findByTitle(title);
	}

	@GetMapping("/books/contain")
	public List<Book> getBooksByContain(@RequestParam("title") String title) {
		return repo.findByTitleContaining(title);
	}

	@GetMapping("/books/start")
	public List<Book> getBooksBystart(@RequestParam("title") String title) {
		return repo.findByTitleStartingWith(title);
	}

	@GetMapping("/books/end")
	public List<Book> getBooksByEnd(@RequestParam("title") String title) {
		return repo.findByTitleEndingWith(title);
	}

	@GetMapping("/books/ignore")
	public List<Book> getBooksByIgnore(@RequestParam("title") String title) {
		return repo.findByTitleIgnoreCase(title);
	}

	@GetMapping("/books/page")
	public List<Book> getBooksPageEqual(@RequestParam("page") int page) {
		return repo.findByPageCountEquals(page);
	}

	// Relational Operators
	@GetMapping("/books/greater")
	public List<Book> getBooksPageGreater(@RequestParam("page") int page) {
		return repo.findByPageCountGreaterThan(page);
	}

	@GetMapping("/books/greater-equal")
	public List<Book> getBooksPageGreaterEqual(@RequestParam("page") int page) {
		return repo.findByPageCountGreaterThanEqual(page);
	}

//	@GetMapping("/books/between")
//	public List<Book> getBooksPageBtween(@RequestParam("min") int min, @RequestParam("max") int max) {
//		return repo.findByPageCountBetween(min, max);
//	}

	// Logical Operators
	@GetMapping("/books/or")
	public List<Book> getBooksOr(@RequestParam("title1") String title1, @RequestParam("title2") String title2) {
		return repo.findByTitleContainingOrTitleContaining(title1, title2);
	}

	// Date
	@GetMapping("/books/after")
	public List<Book> getBooksAfter(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("date") Date date) {
		return repo.findByPublishDateAfter(date);
	}
	
	@GetMapping("/books/before")
	public List<Book> getBooksBefore(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("date") Date date) {
		return repo.findByPublishDateBefore(date);
	}
	
	@GetMapping("/books/between")
	public List<Book> getBooksBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("date1") Date date1, @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("date2") Date date2) {
		return repo.findByPublishDateBetween(date1, date2);
	}
	
	// Ordering
	@GetMapping("/books/ordera")
	public List<Book> getBooksByOrderAsc(@RequestParam("title") String title) {
		return repo.findByTitleContainingOrderByTitleAsc(title);
	}
	
	@GetMapping("/books/order-page")
	public List<Book> getBooksByOrderByPageAsc() {
		return repo.findByOrderByPageCountAsc();
	}
	
	
	//Limiting Query
	@GetMapping("/books/price-a")
	public List<Book> getBooksByOrderByPriceAsc() {
		return repo.findTop5ByOrderByPriceDesc();
	}
	
	
	// Nested Properties
	@GetMapping("/books/nested")
	public List<Book> getBooksByNested(@RequestParam("country") String country) {
		return repo.findByAuthor_Country(country);
	}
	
	
	@GetMapping("/books/first-name")
	public List<Book> getBooksByfirstName(@RequestParam("firstname") String firstname) {
		return repo.findByAuthorFirstName(firstname);
	}
	
	

}
