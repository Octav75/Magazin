package com.sda.project.pages;

import com.sda.project.products.Product;
import com.sda.project.products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowcaseController {

    private ProductsService productsService;

    @Autowired
    public ShowcaseController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/showcase")
    public String displayShowcase(Model model){
        addProductToDb();
        addProductToDb();
        addProductToDb();
        addProductToDb();
        addProductToDb();

        Iterable<Product> allProducts = productsService.findAll();
        model.addAttribute("products", allProducts);

        return "showcase";
    }

    private void addProductToDb(){
        Product p = new Product();
        p.setProductName("MyProduct");

        productsService.saveProduct(p);
    }

}