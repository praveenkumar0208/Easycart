package com.library.library.repository;

import com.library.library.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Productrepository  extends JpaRepository<Product,Long> {

    Product findByProductname(String pname);
}
