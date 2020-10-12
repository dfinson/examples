package dev.sanda.ecommerce_api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany
    private Set<Product> products;
    private Double subtotal;
    private String shippingAddress;
}
