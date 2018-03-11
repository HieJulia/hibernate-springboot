package com.project.hibernate.entity;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// Entity Article -> User(role) -> create Article
@Entity
@Data
@Table(name="article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id")
    private int articleId;

    @Column(name="title")
    private String title;

    @Column(name="category")
    private String category;

    @Column(name = "content",nullable = false)
    private String content;



}
