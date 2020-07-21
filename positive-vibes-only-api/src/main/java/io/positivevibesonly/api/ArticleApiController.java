package io.positivevibesonly.api;

import io.positivevibesonly.model.Article;
import io.positivevibesonly.model.PaginatedArticleModel;
import io.positivevibesonly.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-09T14:54:12.787Z[GMT]")
@Controller
public class ArticleApiController implements ArticleApi {

    private static final Logger log = LoggerFactory.getLogger(ArticleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ArticleService articleService;


    @org.springframework.beans.factory.annotation.Autowired
    public ArticleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addArticle(@ApiParam(value = "article item to add"  )  @Valid @RequestBody Article body
) {
        Article article = articleService.createArticle(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteArticle(@ApiParam(value = "article item to add"  )  @Valid @RequestParam Long id) {
        String accept = request.getHeader("Accept");
        articleService.deleteArticle(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<PaginatedArticleModel> searchArticle(@ApiParam(value = "pass an optional search string for looking up article") @Valid @RequestParam(value = "searchString", required = false) String searchString
,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip
,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit,
                                                       @ApiParam(value = "id") @Valid @PathVariable(value = "id", required = false) Optional<Long> id
) {
        String accept = request.getHeader("Accept");
        if (id.isPresent()){
            List<Article> articleList = articleService.getArticleById(id.get());
            PaginatedArticleModel paginatedArticleModel = new PaginatedArticleModel();
            paginatedArticleModel.setArticles(articleList);
            return new ResponseEntity<PaginatedArticleModel>(paginatedArticleModel, HttpStatus.OK);
        }else {
            PaginatedArticleModel paginatedArticleModel = articleService.searchPaginated(searchString, skip, limit);
            return new ResponseEntity<PaginatedArticleModel>(paginatedArticleModel, HttpStatus.OK);
        }

    }

    public ResponseEntity<PaginatedArticleModel> getArticlesByCateory(@ApiParam(value = "pass an optional search string for looking up article") @Valid @RequestParam(value = "category", required = false) String category
            ,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false, defaultValue = "0") Integer skip
            ,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit
    ) {
        String accept = request.getHeader("Accept");

            PaginatedArticleModel paginatedArticleModel = articleService.getArticlesByCategory(category, skip, limit);
            return new ResponseEntity<PaginatedArticleModel>(paginatedArticleModel, HttpStatus.OK);

    }

    public ResponseEntity<Void> updateArticle(@ApiParam(value = "article item updated"  )  @Valid @RequestBody Article body
) {
        String accept = request.getHeader("Accept");
        Article article = articleService.updateArticle(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
