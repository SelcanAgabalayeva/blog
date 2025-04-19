package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dto.article.ArticleHomeDto;
import az.edu.itbrains.blog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;

    }

    @GetMapping("/")
    public String home(Model model){

        List<ArticleHomeDto> findArticles=articleService.getAllArticles();
        model.addAttribute("articles",findArticles);
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return  "about";
    }
    @GetMapping("/post")
    public String post(){
        return  "post";
    }
    @GetMapping("/contact")
    public String contact(){
        return  "contact";
    }


}
