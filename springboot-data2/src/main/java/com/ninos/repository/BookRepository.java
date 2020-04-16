package com.ninos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ninos.entity.Book;



public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	
	 @Query("select b from Book b where title like %?1%")
	 Page<Book> findByTitle(String title, Pageable pageable);
	
	 

//	@Query("select b from Book b")    // it will return all books
//	public List<Book> queryone(); 
//	
//	@Query("select b from Book b where b.title = ?1")   // number 1 it's meaning one parameter
//	public List<Book> querytow(String title); 
//	
//	@Query("select b from Book b where b.title =:title")  // this same result of query tow but using parameter
//	public List<Book> querythree(@Param("title") String title); 
//	
//	
//	@Query("select b from Book b where b.pageCount < ?1")    // http://localhost:8080/books/page?page=33  it's meaning less than pageCount 33
//	public List<Book> queryfour(int page); 
	
	
//	public List<Book> queryone(); 
//	public List<Book> querythree(@Param("title") String title);
	
	
}
