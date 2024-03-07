package com.example.oris2s001.services;

import com.example.oris2s001.dto.ArticleDto;
import com.example.oris2s001.dto.ArticleForm;
import com.example.oris2s001.models.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long userId);

    ArticleDto addArticle(Long userId, ArticleForm articleForm);
    ArticleDto like(Long userId , Long articleId);
}