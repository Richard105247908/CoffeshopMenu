package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")// means all URL starts with  http://localhost:8080/products/
public class ProductController {

    //The List.of(…) method creates an immutable list, which is great for fixed data
//    private List<Product> productsList = List.of(
//            new Product(1, "Espresso", 2.50),
//            new Product(2, "Latte", 3.50),
//            new Product(3, "Croissant", 2.00),
//            new Product(4, "Chocolate Muffin", 2.25),
//            new Product(5, "Americano", 2.75)
//    ); the list was immutable, cannot be changed


    //due to class level mapping it maps to /products/
    // Directs spring boot to send the returned string directly as an HTTP response

//    @RequestMapping("/")
//    @ResponseBody
//    public String home(){
//        return "Welcome to the Coffee Shop!";
//    }

//Method 1 to view all listed products

//    @RequestMapping("/list")
//    @ResponseBody
//    public String listProducts() {
//        String productDisplay = "<strong>Product List:</strong> <hr>";
//        for (Product product : productsList) {
//            productDisplay += "Product: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice() + "<br>";
//        }
//        return productDisplay;
//    }

    //help with jsp HTML in jsp file in webapp
//    @RequestMapping("/list") // This maps to the URL http://localhost:8080/products/list
//    public String listProducts(Model productListModel) { // Model argument is used to pass data to the view
//        productListModel.addAttribute("products", productsList); // Add the productsList to the model
//        return "menu";  // This returns the view name, that is, the JSP file name
//    }


    //Method 2 to list specific products
// PathVariable used to extract the id from the URL,
// which iterates through productList
// to find matching product.

//    @RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
//    @ResponseBody
//    public String getProductDetailsByID(@PathVariable int id) {
//        for (Product product : productsList) {
//            if (product.getId() == id) {
//                return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
//            }
//        }
//        return "Product not found!";
//    }

    private List<Product> productsList = new ArrayList<>(List.of(
            new Product(1, "Espresso", 2.50),
            new Product(2, "Latte", 3.50),
            new Product(3, "Croissant", 2.00),
            new Product(4, "Chocolate Muffin", 2.25),
            new Product(5, "Americano", 2.75)
    ));

    @RequestMapping("/")  // Maps to the URL http://localhost:8080/
    public String listProducts(Model productListModel) {
        productListModel.addAttribute("products", productsList);  // Add productsList to the model
        return "menu";  // Returns the view name (HTML file name)
    }

    @RequestMapping("/add")  // Maps to the URL http://localhost:8080/add
    public String showProductForm(Model productAddFormModel) {
        productAddFormModel.addAttribute("product", new Product());  // Add a new product instance to the model
        return "add-new-product";
    }

    @PostMapping("/addNewProduct")  // Handles the form submission
    public String addProduct(Product product) {
        productsList.add(product);  // Adds the submitted product to productsList
        System.out.println(productsList);  // Logs the updated product list
        return "redirect:/";  // Redirects back to the main product list view
    }

}