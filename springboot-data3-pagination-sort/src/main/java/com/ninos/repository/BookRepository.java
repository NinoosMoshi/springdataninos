package com.ninos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
	
	 //@Query("select b from Book b where title like %?1%")
	 Page<Book> findByTitleContaining(String title, Pageable pageable);
	
	 List<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable);
	 
	 List<Book> findByPageCountGreaterThan(int pageCount,Sort sort);


	
	
	 
}
