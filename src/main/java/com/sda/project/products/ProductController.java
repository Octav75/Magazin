package com.sda.project.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService){this.productsService = productsService;}

    @GetMapping("/addProduct")
    public String showProductForm(Model model){
        Product p = new Product();
        model.addAttribute("product", p);
        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String postRegister(Product product){
        productsService.saveProduct(product);
        return  "index";
    }



//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(Product product){
//        productsService.saveProduct(product);
//        return "redirect:/product/" + product.getId();
//    }
}
