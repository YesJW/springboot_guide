package com.springboot.relationship.data.repository.support;

import com.springboot.advanced_jpa.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);

}
