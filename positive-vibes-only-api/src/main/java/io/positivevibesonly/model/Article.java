package io.positivevibesonly.model;

import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Article
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-09T14:54:12.787Z[GMT]")
public class Article   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("header")
  private String header = null;

  @JsonProperty("body")
  private String body = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("subcategory")
  private String subcategory = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("createdDateTime")
  private LocalDateTime createdDateTime = null;

  @JsonProperty("updatedDateTime")
  private LocalDateTime updatedDateTime = null;

  public Article name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "article name", required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Article header(String header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(example = "article header", required = true, value = "")
      @NotNull

    public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public Article body(String body) {
    this.body = body;
    return this;
  }

  /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(example = "article body", required = true, value = "")
      @NotNull

    public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Article category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(example = "article body", required = true, value = "")
      @NotNull

    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public Article author(String author) {
    this.author = author;
    return this;
  }
  /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(example = "author", required = true, value = "")
      @NotNull

    public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Article subcategory(String subcategory) {
    this.subcategory = subcategory;
    return this;
  }

  /**
   * Get subcategory
   * @return subcategory
   **/
  @ApiModelProperty(example = "article body", required = true, value = "")
  @NotNull

  public String getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(String subcategory) {
    this.subcategory = subcategory;
  }


  public Article createdDateTime(LocalDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
    return this;
  }

  /**
   * Get createdDateTime
   * @return createdDateTime
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")


    @Valid
    public LocalDateTime getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(LocalDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Article updatedDateTime(LocalDateTime updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
    return this;
  }

  /**
   * Get updatedDateTime
   * @return updatedDateTime
  **/
  @ApiModelProperty(example = "2016-08-29T09:12:33.001Z", required = true, value = "")

    @Valid
    public LocalDateTime getUpdatedDateTime() {
    return updatedDateTime;
  }

  public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(this.name, article.name) &&
        Objects.equals(this.header, article.header) &&
        Objects.equals(this.body, article.body) &&
        Objects.equals(this.category, article.category) &&
        Objects.equals(this.subcategory, article.subcategory) &&
        Objects.equals(this.createdDateTime, article.createdDateTime) &&
        Objects.equals(this.updatedDateTime, article.updatedDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, header, body, category, subcategory, createdDateTime, updatedDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Article {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    subcategory: ").append(toIndentedString(subcategory)).append("\n");
    sb.append("    createdDateTime: ").append(toIndentedString(createdDateTime)).append("\n");
    sb.append("    updatedDateTime: ").append(toIndentedString(updatedDateTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
