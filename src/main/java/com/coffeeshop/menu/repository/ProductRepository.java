package com.coffeeshop.menu.repository;

import com.coffeeshop.menu.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product, Long>{
}
