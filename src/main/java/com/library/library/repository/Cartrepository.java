package com.library.library.repository;

import com.library.library.model.Cart;
import com.library.library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Cartrepository extends JpaRepository<Cart, Long> {
    Cart findByProduct(Product p);


}
