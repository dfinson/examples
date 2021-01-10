package dev.sanda.ecommerce_api_demo.api_hooks;

import dev.sanda.apifi.service.ApiHooks;
import dev.sanda.datafi.service.DataManager;
import dev.sanda.ecommerce_api_demo.model.CustomerOrder;
import dev.sanda.ecommerce_api_demo.model.Product;
import dev.sanda.ecommerce_api_demo.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomerOrderApiHooks implements ApiHooks<CustomerOrder> {

    /*
        Apifis' DataManager offers extensive data layer functionality,
        but for the most part we can simply use it like a JpaRepository.
    */
    @Autowired
    private DataManager<ShoppingCart> cartDataManager;

    @Override
    public void preCreate(
            CustomerOrder originalInput,
            DataManager<CustomerOrder> dataManager
    ) {
        // get cart id from transient shopping cart in CustomerOrderInput
        Long cartId = originalInput.getFromCart().getId();
        // load cart from database
        ShoppingCart cart = cartDataManager
                .findById(cartId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Can't find shopping cart with id #" + cartId
                        )
                );
        // get the products to be included in the new CustomerOrder object
        Set<Product> products = cart.getProducts();
        // mark the products as archived to remove them from the inventory
        products.forEach(product -> product.setIsArchived(true));
        // associate the products with the new CustomerOrder object
        originalInput.setProducts(products);
        // calculate and set the CustomerOrder subtotal
        originalInput.setSubtotal(
                products
                        .stream()
                        .map(Product::getPrice)
                        .reduce(Double::sum)
                        .orElse(0.00)
        );
        // empty the customers shopping cart by dissociating its products
        cart.setProducts(new HashSet<>());
        /* note this is all happening within a JPA Transaction,
         so all changes will be implicitly persisted to the database */
    }
}