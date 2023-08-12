package com.llye.apache.apachecamel.model;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private String genre;
    private int publishedYear;
}
