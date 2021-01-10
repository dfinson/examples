package dev.sanda.ecommerce_api_demo.model;

import dev.sanda.apifi.annotations.EntityCollectionApi;
import dev.sanda.apifi.generator.entity.EntityCollectionEndpointType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

import static dev.sanda.apifi.generator.entity.EntityCollectionEndpointType.ASSOCIATE_WITH;
import static dev.sanda.apifi.generator.entity.EntityCollectionEndpointType.REMOVE_FROM;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    @EntityCollectionApi(
            endpoints = {ASSOCIATE_WITH, REMOVE_FROM},
            associatePreExistingOnly = true
    )
    private Set<Product> products;
}
