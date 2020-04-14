package com.ninos.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Entity
@Table(name="data")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="page_count")
	private int pageCount;
	
	@Column(name="title")
	private String title;
	
	@JsonFormat(pattern="yyyy-MM-dd", shape = Shape.STRING)
	@Column(name="publish_date")
	private Date publishDate;
	
	@Column(name="price")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	

}
