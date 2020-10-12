package dev.sanda.ecommerce_api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToOne
    private ShoppingCart cart;
}
