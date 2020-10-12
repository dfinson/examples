package dev.sanda.apifigraphqldemo.model;

import dev.sanda.apifi.annotations.WithCRUDEndpoints;
import dev.sanda.apifi.generator.entity.CRUDEndpoints;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import static dev.sanda.apifi.generator.entity.CRUDEndpoints.CREATE;

@Data
@Entity
@EqualsAndHashCode(exclude = "author")
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(length = 20000)
    private String content;
    @ManyToOne
    private Author author;
}
