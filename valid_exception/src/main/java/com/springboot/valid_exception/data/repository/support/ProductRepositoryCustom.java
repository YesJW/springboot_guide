package com.springboot.valid_exception.data.repository.support;

import com.springboot.valid_exception.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);

}
