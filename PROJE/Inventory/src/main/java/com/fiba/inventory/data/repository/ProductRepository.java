package com.fiba.inventory.data.repository;

import com.fiba.inventory.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    @Query("select p from Product as p where p.category.categoryId = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId")long categoryId);
}
