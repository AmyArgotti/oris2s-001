package com.example.oris2s001.repositories;
import com.example.oris2s001.models.User;


import com.example.oris2s001.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikeContaining(Long articleId , User user);
}