package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dto.article.ArticleCreateDto;
import az.edu.itbrains.blog.dto.article.ArticleGetAll;
import az.edu.itbrains.blog.dto.article.ArticleGetIdDto;
import az.edu.itbrains.blog.dto.article.ArticleUpdateDto;
import az.edu.itbrains.blog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/admin/article")
    public String getAll(Model model) {
        List<ArticleGetAll> allArticle = articleService.getArticlesAll();
        model.addAttribute("articles", allArticle);
        return "/dashboard/article/index";
    }

    @GetMapping("/admin/article/create")
    public String create(Model model) {
        return "/dashboard/article/create";
    }

    @PostMapping("/admin/article/create")
    public String create(@ModelAttribute("article") ArticleCreateDto articleCreateDto) {
        articleService.createArticle(articleCreateDto);
        return "redirect:/admin/article";

    }

    @GetMapping("/admin/article/update/{id}")
    public String updateArticle(@PathVariable("id") Long id, Model model) {
        ArticleGetIdDto articleGetIdDto = articleService.articleGetIdDto(id);
        model.addAttribute("article", articleGetIdDto);
        return "/dashboard/article/update";
    }

        @PostMapping("/admin/article/update/{id}")
        public String updateArticle(@ModelAttribute ArticleUpdateDto articleUpdateDto,@PathVariable("id") Long id) {
           articleService.updateArticle(articleUpdateDto,id);
            return "redirect:/admin/article";

        }
     @GetMapping("/admin/article/delete/{id}")
    public String delete(@PathVariable("id") Long id){
         return "/dashboard/article/delete";
     }
    @PostMapping("/admin/article/delete/{id}")
    public String removeArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return "redirect:/admin/article";

    }





}

