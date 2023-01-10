package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductRepositoryTestByH2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest(){
        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        //when
        Product saveProduct = productRepository.save(product);

        //then
        assertEquals(product.getName(), saveProduct.getName());
        assertEquals(product.getPrice(), saveProduct.getPrice());
        assertEquals(product.getStock(), saveProduct.getStock());
    }

    @Test
    void selectTest() {
        //given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product saveProduct = productRepository.saveAndFlush(product);

        //when
        Product foundProduct = productRepository.findById(saveProduct.getNumber()).get();

        //then
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStock(), foundProduct.getStock());
    }
}
