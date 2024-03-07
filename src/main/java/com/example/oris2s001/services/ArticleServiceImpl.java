package com.example.oris2s001.services;


import com.example.oris2s001.dto.ArticleDto;
import com.example.oris2s001.dto.ArticleForm;
import com.example.oris2s001.models.Article;
import com.example.oris2s001.models.User;
import com.example.oris2s001.repositories.ArticleRepository;
import com.example.oris2s001.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articlesOfUser = user.getCreateArticles();
        return ArticleDto.articleList(articlesOfUser);
    }

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        User author = usersRepository.getOne(userId);

        Article newArticle = Article.builder()
                .author(author)
                .type(articleForm.getType())
                .text(articleForm.getText())
                .name(articleForm.getText())
                .build();

        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    public ArticleDto like(Long userId, Long articleId ){
        User user = usersRepository.getOne(userId);// action num 3
        Article article = articleRepository.getOne(articleId);//action num 3 , coming back from the sql to the backend and send it to the front.
        if (articleRepository.existsByArticleIdAndLikeContaining(articleId, user)){
            article.getLike().remove(user);

        }else {
            article.getLike().add(user);
        }
        articleRepository.save(article);//action num 4 bring from the front to the front.
        return ArticleDto.from(article);

    }
}