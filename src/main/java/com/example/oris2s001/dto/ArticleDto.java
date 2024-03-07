package com.example.oris2s001.dto;



import com.example.oris2s001.models.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likesCount;

    public static ArticleDto from(Article article) {
            Integer likeCount = 0;
            if (article.getLike() != null) {
                likeCount = article.getLike().size();
            }
            return ArticleDto.builder()
                    .id(article.getArticleId())
                    .text(article.getText())
                    .authorName(article.getAuthor().getEmail())
                    .likesCount(likeCount)
                    .build();
        }


    public static List<ArticleDto> articleList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}