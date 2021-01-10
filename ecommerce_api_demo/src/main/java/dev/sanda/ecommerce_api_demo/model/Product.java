package dev.sanda.ecommerce_api_demo.model;

import dev.sanda.apifi.annotations.WithCRUDEndpoints;
import dev.sanda.apifi.generator.entity.CRUDEndpoints;
import dev.sanda.datafi.persistence.Archivable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static dev.sanda.apifi.generator.entity.CRUDEndpoints.BATCH_CREATE;

@Data
@Entity
@WithCRUDEndpoints({BATCH_CREATE})
public class Product implements Archivable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Boolean isArchived = false;
}
