package dev.sanda.ecommerce_api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private Set<Product> products;
}
