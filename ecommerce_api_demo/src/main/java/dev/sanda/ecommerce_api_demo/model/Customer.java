package dev.sanda.ecommerce_api_demo.model;

import dev.sanda.apifi.annotations.WithCRUDEndpoints;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static dev.sanda.apifi.generator.entity.CRUDEndpoints.CREATE;
import static dev.sanda.apifi.generator.entity.CRUDEndpoints.GET_BY_ID;
import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@WithCRUDEndpoints({CREATE, GET_BY_ID})
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToOne(cascade = ALL)
    private ShoppingCart cart = new ShoppingCart();
}
