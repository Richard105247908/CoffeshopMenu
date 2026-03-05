package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")// means all URL starts with  http://localhost:8080/products/
public class ProductController {

    //The List.of(…) method creates an immutable list, which is great for fixed data
    private List<Product> productList= List.of(
            new Product(1, "Espresso", 2.50),
            new Product(2, "Latte", 3.50),
            new Product(3, "Croissant", 2.00),
            new Product(4, "Chocolate Muffin", 2.25),
            new Product(5, "Americano", 2.75)
    );
}
