package io.positivevibesonly.service;

import io.positivevibesonly.entity.Article;
import io.positivevibesonly.model.PaginatedArticleModel;
import io.positivevibesonly.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public io.positivevibesonly.model.Article createArticle(io.positivevibesonly.model.Article article){

        Article articleEntity = new Article();

        articleEntity = convertToEntity(article,articleEntity);
        articleEntity.setCreatedDate(LocalDateTime.now());
        articleEntity.setLastModifiedDate(LocalDateTime.now());
        articleRepository.save(articleEntity);

        Article articleEntity1 = articleRepository.findByHeader(article.getHeader()).get();

        io.positivevibesonly.model.Article saveArticle = convertToModel(articleEntity1);
        return saveArticle;
    }


    public List<io.positivevibesonly.model.Article> getArticleById(Long id){
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()){
            List<Article> articles = Arrays.asList(articleRepository.findById(id).get());
            List<io.positivevibesonly.model.Article> articleList = articles.stream().map(articleEntity ->
                    convertToModel(articleEntity)
            ).collect(Collectors.toList());
            return articleList;
        }else {
            return new ArrayList<io.positivevibesonly.model.Article>();
        }


    }

    public List<io.positivevibesonly.model.Article> search(String searchStr, Integer skip, Integer limit){
        Page<Article> articlePage = articleRepository.findByCategoryIgnoreCaseContainingOrHeaderIgnoreCaseContaining(searchStr,searchStr,PageRequest.of(skip,limit));
        List<io.positivevibesonly.model.Article> articleList = articlePage.stream().map(articleEntity -> convertToModel(articleEntity)
        ).collect(Collectors.toList());
        return articleList;
    }

    public PaginatedArticleModel searchPaginated(String searchStr, Integer skip, Integer limit){

        Page<Article> articlePage = articleRepository.findByCategoryIgnoreCaseContainingOrHeaderIgnoreCaseContaining(searchStr,searchStr,PageRequest.of(skip,limit));

        List<io.positivevibesonly.model.Article> articleList = articlePage.stream().map(articleEntity -> convertToModel(articleEntity)
        ).collect(Collectors.toList());

        PaginatedArticleModel paginatedArticleModel = new PaginatedArticleModel();
        paginatedArticleModel.setArticles(articleList);
        paginatedArticleModel.setPageIndex(articlePage.getNumber());
        paginatedArticleModel.setPageSize(articlePage.getSize());
        paginatedArticleModel.setTotalPages(articlePage.getTotalPages());
        paginatedArticleModel.setTotal(articlePage.getTotalElements());
        return paginatedArticleModel;
    }

    public PaginatedArticleModel getArticlesByCategory(String category, Integer skip, Integer limit){

        Page<Article> articlePage = articleRepository.findByCategoryIgnoreCase(category,PageRequest.of(skip,limit));

        List<io.positivevibesonly.model.Article> articleList = articlePage.stream().map(articleEntity -> convertToModel(articleEntity)
        ).collect(Collectors.toList());

        PaginatedArticleModel paginatedArticleModel = new PaginatedArticleModel();
        paginatedArticleModel.setArticles(articleList);
        paginatedArticleModel.setPageIndex(articlePage.getNumber());
        paginatedArticleModel.setPageSize(articlePage.getSize());
        paginatedArticleModel.setTotalPages(articlePage.getTotalPages());
        paginatedArticleModel.setTotal(articlePage.getTotalElements());
        return paginatedArticleModel;
    }



    public io.positivevibesonly.model.Article updateArticle(io.positivevibesonly.model.Article article){


        Article articleEntity = articleRepository.findByHeader(article.getHeader()).get();

        articleEntity = convertToEntity(article,articleEntity);
        articleEntity.setLastModifiedDate(LocalDateTime.now());
        articleRepository.save(articleEntity);

        io.positivevibesonly.model.Article saveArticle = convertToModel(articleEntity);

        return saveArticle;
    }

    public void deleteArticle(Long id){
        Article articleEntity = articleRepository.findById(id).get();
        articleRepository.delete(articleEntity);
    }

    public io.positivevibesonly.model.Article convertToModel(Article articleEntity){
        io.positivevibesonly.model.Article article = new io.positivevibesonly.model.Article();
        article.setBody(articleEntity.getBody());
        article.setCategory(articleEntity.getCategory());
        article.setHeader(articleEntity.getHeader());
        article.setName(articleEntity.getName());
        article.setSubcategory(articleEntity.getSubcategory());
        article.setAuthor(articleEntity.getAuthor());
        article.setCreatedDateTime(articleEntity.getCreatedDate());
        article.setUpdatedDateTime(articleEntity.getLastModifiedDate());
        article.setId(articleEntity.getId());
        return article;
    }

    public Article convertToEntity(io.positivevibesonly.model.Article article, Article articleEntity){

        articleEntity.setBody(article.getBody());
        articleEntity.setCategory(article.getCategory());
        articleEntity.setHeader(article.getHeader());
        articleEntity.setName(article.getName());
        articleEntity.setSubcategory(article.getSubcategory());
        articleEntity.setAuthor(article.getAuthor());

        return articleEntity;
    }
}
