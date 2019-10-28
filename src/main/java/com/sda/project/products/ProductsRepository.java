package com.sda.project.products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ProductsRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByProductName(@Param("productName") String productName);
}