package dev.sanda.apifigraphqldemo.model;

import dev.sanda.apifi.annotations.EntityCollectionApi;
import dev.sanda.apifi.annotations.WithCRUDEndpoints;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

import static dev.sanda.apifi.generator.entity.CRUDEndpoints.CREATE;
import static dev.sanda.apifi.generator.entity.CRUDEndpoints.GET_BY_ID;
import static dev.sanda.apifi.generator.entity.EntityCollectionEndpointType.ASSOCIATE_WITH;

@Data
@Entity
@WithCRUDEndpoints({CREATE, GET_BY_ID})
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "author")
    @EntityCollectionApi(endpoints = {ASSOCIATE_WITH})
    private Set<BlogPost> blogPosts = new HashSet<>();
}
