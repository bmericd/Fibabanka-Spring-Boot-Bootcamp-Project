package com.fiba.inventory.data.repository;

import com.fiba.inventory.data.entity.Category;
import com.fiba.inventory.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long> {


}
