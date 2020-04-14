package com.ninos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.entity.Book;



public interface BookRepository extends JpaRepository<Book, Integer> {

	//Derived String Operators
	public List<Book> findByTitle(String title);   // http://localhost:8080/books/title?title=book of java
	public List<Book> findByTitleLike(String title);  // http://localhost:8080/books/contain?title=%java%
	public List<Book> findByTitleContaining(String title); // http://localhost:8080/books/start?title=java
	public List<Book> findByTitleStartingWith(String title); // http://localhost:8080/books/start?title=b
	public List<Book> findByTitleEndingWith(String title); // http://localhost:8080/books/end?title=s
	public List<Book> findByTitleIgnoreCase(String title); // http://localhost:8080/books/ignore?title=BOOK OF JAVA
	
	
	// Relational Operators(equal,greater than, less than, between)
	public List<Book> findByPageCountEquals(int page);     // http://localhost:8080/books/page?page=33
	public List<Book> findByPageCountGreaterThan(int page); // http://localhost:8080/books/greater?page=33  it will show all the pages more than 33
	public List<Book> findByPageCountLessThan(int page);
	public List<Book> findByPageCountGreaterThanEqual(int page); // http://localhost:8080/books/greater-equal?page=33  it will show all the pages from 33 and greater 
	public List<Book> findByPageCountLessThanEqual(int page);
	public List<Book> findByPageCountBetween(int min, int max); // http://localhost:8080/books/between?min=33&max=55
	
	
	// Logical Operators(Or,And,Not)
	public List<Book> findByTitleContainingOrTitleContaining(String title1, String title2);  // http://localhost:8080/books/or?title1=java&title2=html all the book contain java work and html word
	public List<Book> findByTitleContainingAndPageCount(String title, int page);    //  ex: title:book of java page:33  
	public List<Book> findByTitleNot(String title); // show all the books except this String provide in title
	
	
	
	// Date Comparisons
	public List<Book> findByPublishDateAfter(Date date);
	public List<Book> findByPublishDateBefore(Date date);
	public List<Book> findByPublishDateBetween(Date date1, Date date2); // http://localhost:8080/books/between?date1=2020-04-24&date2=2020-06-23
	
	
	// Ordering
	public List<Book> findByOrderByPageCountAsc();   // http://localhost:8080/books/order-page  it will return Asc based on pageCount
	public List<Book> findByTitleContainingOrderByTitleAsc(String title); // http://localhost:8080/books/ordera?title=java
	public List<Book> findByTitleContainingOrderByTitleDesc(String title);
	
	
	
	//Limiting Query
	public List<Book> findTop5ByOrderByPriceDesc(); // http://localhost:8080/books/price-a it will find the top five books expensive
	
	
	// Nested Properties
	public List<Book> findByAuthor_Country(String country);   // http://localhost:8080/books/nested?country=usa
	public List<Book> findByAuthorFirstName(String firstname); // http://localhost:8080/books/first-name?firstname=ninos
	
	
	
	
	
	
	
	
	
	
	
	
	
}
