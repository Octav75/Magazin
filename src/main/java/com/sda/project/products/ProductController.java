package com.sda.project.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

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
    public String postRegister(@RequestParam("image") MultipartFile image, @Valid Product product){
        try {
            byte[] img = image.getBytes();
            product.setProductImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        productsService.saveProduct(product);
        return  "index";

    }
//    @GetMapping("/show/products")
//    public String getProduct(Model model,
//                             @ModelAttribute("product") Product product,
//                             BindingResult result) {
//        Optional<Product> products = this.productsService.getAllProducts(product.getProductName());
//        model.addAttribute("products", products);
//        return "show_product";
//    }



//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(Product product){
//        productsService.saveProduct(product);
//        return "redirect:/product/" + product.getId();
//    }
}
