package io.positivevibesonly.repository;

import io.positivevibesonly.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    List<Article> findByName(String name);

    Optional<Article>  findByHeader(String header);

    List<Article> findByCategory(String category);

    Page<Article> findByCategoryIgnoreCaseContainingOrHeaderIgnoreCaseContaining(String category, String header, Pageable pageable);


}
