package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dto.article.ArticlePostDto;
import az.edu.itbrains.blog.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {
    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    public PostController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/post/{id}")
    public String showPost(@PathVariable Long id, Model model){
        ArticlePostDto articlePostDto=articleService.getArticleById(id);
        model.addAttribute("post",articlePostDto);
        return "/post";
    }
}
