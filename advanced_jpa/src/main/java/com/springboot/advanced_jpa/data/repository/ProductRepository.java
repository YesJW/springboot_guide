package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //find..By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByName(Long number);

    // exists..By
    boolean existsByNumber(Long number);

    // count..By
    long countByName(String name);

    // delete..By, remove..By
    void deleteByNumber(Long number);
    long removeByName(String name);

    // First<number>, Top<number>
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // findByNumber 메서드와 동일하게 동작, is -> Equals와 동일한 기능
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    // Not 키워드를 사용한 쿼리 메서드
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);


    // And, Or 키워드를 사용한 쿼리 메서드
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    // GreaterThan, LessThan, Between 키워드를 사용한 쿼리 메서드
    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceIsLessThan(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    //부분 일치 키워드를 사용한 쿼리 메서드
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    List<Product> findByNameContains(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameIsContaining(String name);

    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findBynameIsStartingWith(String name);

    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    // 정렬 처리 (Asc : 오름차순, Desc : 내림차순)
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    // And를 붙이지 않고 정렬
    List<Product> findByNameOrderByPriceAscStockDesc(String name);

    // 매개변수를 활용한 쿼리 정렬
    List<Product> findByName(String name, Sort sort);

    // 페이징 처리를 위한 쿼리 메서드
    Page<Product> findByName(String name, Pageable pageable);

    // @Query 어노테이션을 사용하는 메서드, ?1 -> 첫번째 파라미터를 의미
    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
    List<Product> findByName(String name);

    // @Query, @Param을 사용하는 메서드, @Param을 사용하여 :name -> 파라미터 name과 바인딩
    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    // 특정 칼럼만 추출하는 쿼리, List의 형태는 Object
    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);

}
