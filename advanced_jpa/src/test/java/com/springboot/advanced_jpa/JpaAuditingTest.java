package com.springboot.advanced_jpa;

import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.repository.support.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaAuditingTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void auditingTest() {
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);

        Product saveProduct = productRepository.save(product);

        System.out.println("ProductName : " + saveProduct.getName());
        System.out.println("createAt : "+ saveProduct.getCreateAt());
    }
}
