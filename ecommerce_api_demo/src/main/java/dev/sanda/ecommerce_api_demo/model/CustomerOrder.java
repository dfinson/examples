package dev.sanda.ecommerce_api_demo.model;

import dev.sanda.apifi.annotations.WithCRUDEndpoints;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

import static dev.sanda.apifi.generator.entity.CRUDEndpoints.CREATE;

@Data
@Entity
@WithCRUDEndpoints({CREATE})
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private Set<Product> products;
    private Double subtotal;
    private String shippingAddress;

    @Transient
    @Getter(onMethod_ = @GraphQLQuery)
    private ShoppingCart fromCart;
}
