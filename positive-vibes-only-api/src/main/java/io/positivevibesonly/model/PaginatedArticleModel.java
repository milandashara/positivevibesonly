package io.positivevibesonly.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Getter
@Setter
public class PaginatedArticleModel {

    @JsonProperty("articles")
    @Valid
    private List<Article> articles;

    private Long total;

    private Integer pageSize;

    private Integer totalPages;

    @ApiModelProperty(example = "page number starts from 0", value = "0")
    private Integer pageIndex;

    @Override
    public String toString() {
        return "PaginatedArticleModel{" +
                "articles=" + articles +
                '}';
    }
}
