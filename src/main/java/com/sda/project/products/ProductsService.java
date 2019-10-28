package com.sda.project.products;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("productsService")
public class ProductsService{

    private final ProductsRepository productsRepository;


    @Autowired
    public ProductsService(ProductsRepository productsRepository) {this.productsRepository= productsRepository;}

    public void saveProduct(Product product){
        productsRepository.save(product);

    }

    public Optional<Product> getById(Long id) {
        return productsRepository.findById(id);
    }

    public Product loadProductByProductName (String productName) throws NotFoundException{
        Optional<Product> byName = productsRepository.findByProductName(productName);
        Product product;
        if (byName.isPresent()){
            product = byName.get();
        } else {
            throw new NotFoundException("Product not found");
        }
        return product;
    }

    public Iterable<Product> findAll(){
        return productsRepository.findAll();
    }

}
