package az.edu.itbrains.blog.services;

import az.edu.itbrains.blog.dto.article.*;

import java.util.List;

public interface ArticleService {
    List<ArticleHomeDto> getAllArticles();
   ArticlePostDto getArticleById(Long id);
   List<ArticleGetAll> getArticlesAll();
   ArticleGetIdDto articleGetIdDto(Long id);
   void createArticle(ArticleCreateDto articleCreateDto);
   void updateArticle(ArticleUpdateDto articleUpdateDto,Long id);
   void deleteArticle(Long id);

}
