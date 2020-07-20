package io.positivevibesonly.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Getter
@Setter
public class Article extends Auditable<Article>{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name = null;

    @Column(unique = true)
    private String header = null;

    private String body = null;

    private String category = null;

    private String subcategory = null;

    private String author = null;

    //TODO add created datetime and updated datetime auditable

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                '}';
    }
}
