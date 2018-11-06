package com.qding.test.lambda;

import java.util.List;
import java.util.Optional;

public class Article {

    private final String title;
    private final String author;
    private final List<String> tags;

    public Optional<Article> getFirstJavaArticle3(List<Article> articles) {
        Optional<Article> tt= articles.stream().filter(article -> article.getTags().contains("java")).findFirst();

        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    public Optional<Article> getFirstJavaArticle2(List<Article> articles) {
        articles.stream().filter(article -> article.getTags().contains("java")).findFirst();

        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }



    public Article getFirstJavaArticle(List<Article> articles) {

        for(Article article : articles) {
            if(article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }


    private Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }
}
