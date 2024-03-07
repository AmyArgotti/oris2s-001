
package com.example.oris2s001.controlllers;

import com.example.oris2s001.dto.ArticleForm;
import com.example.oris2s001.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public String addArticle(@PathVariable("user-id") Long id,
                             @RequestBody ArticleForm articleForm) {
        articleService.addArticle(id, articleForm);
        return  "redirect:/users/{user-id}/article";
    }
    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long id, Model model) {
        model.addAttribute("user_id",id);
        model.addAttribute("articles", articleService.getByUser(id));
        return "article_page";
    }
    @PostMapping("/users/{user-id}/articles/{article-id}/like")
    @ResponseBody
    public Object like(@PathVariable("user-id")Long id,
                       @PathVariable("article-id")Long articleId){
        return articleService.like(id,articleId);
    }
}