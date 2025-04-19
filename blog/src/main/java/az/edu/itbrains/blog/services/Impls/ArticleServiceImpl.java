package az.edu.itbrains.blog.services.Impls;

import az.edu.itbrains.blog.dto.article.*;
import az.edu.itbrains.blog.models.Article;
import az.edu.itbrains.blog.repository.ArticleRepository;
import az.edu.itbrains.blog.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

//    @Override
//    public List<ArticleHomeDto> getAllArticles() {
//        List<ArticleHomeDto> getAllArticles=articleRepository.findAll()
//                .stream().map(article ->  {
//                    ArticleHomeDto articleHomeDto=new ArticleHomeDto();
//                    articleHomeDto.setId(article.getId());
//                    articleHomeDto.setTitle(article.getTitle());
//                    articleHomeDto.setAuthor(article.getAuthor());
//                    articleHomeDto.setSubtitle(article.getSubtitle());
//                    articleHomeDto.setPublishDate(article.getPublishDate());
//                    return articleHomeDto;
//                }).collect(Collectors.toList());
//        return getAllArticles;
//    }

    @Override
    public List<ArticleHomeDto> getAllArticles() {
        List<ArticleHomeDto> getAllArticles=articleRepository.findAll().stream().map(article -> modelMapper.map(article,ArticleHomeDto.class)).collect(Collectors.toList());
        return getAllArticles;
    }

    @Override
    public ArticlePostDto getArticleById(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        ArticlePostDto articlePostDto=new ArticlePostDto();
        articlePostDto.setId(article.getId());
        articlePostDto.setContent(article.getContent());
        return  articlePostDto;
    }

    @Override
    public List<ArticleGetAll> getArticlesAll() {
        List<ArticleGetAll> result=articleRepository.findAll().stream().map(articles->modelMapper.map(articles,ArticleGetAll.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public ArticleGetIdDto articleGetIdDto(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        ArticleGetIdDto articleGetIdDto=modelMapper.map(article,ArticleGetIdDto.class);
        return articleGetIdDto;
    }

    @Override
    public void createArticle(ArticleCreateDto articleCreateDto) {
        Article article=new Article();
        article.setTitle(articleCreateDto.getTitle());
        article.setContent(articleCreateDto.getContent());
        article.setSubtitle(articleCreateDto.getSubtitle());
        article.setAuthor(articleCreateDto.getAuthor());
        article.setPublishDate(articleCreateDto.getPublishDate());
        articleRepository.save(article);
    }

    @Override
    public void updateArticle(ArticleUpdateDto articleUpdateDto, Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        article.setId(articleUpdateDto.getId());
        article.setTitle(articleUpdateDto.getTitle());
        article.setContent(articleUpdateDto.getContent());
        article.setSubtitle(articleUpdateDto.getSubtitle());
        article.setAuthor(articleUpdateDto.getAuthor());
        article.setPublishDate(articleUpdateDto.getPublishDate());
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        Article findArticle=articleRepository.findById(id).orElseThrow();
        articleRepository.delete(findArticle);
    }
}



