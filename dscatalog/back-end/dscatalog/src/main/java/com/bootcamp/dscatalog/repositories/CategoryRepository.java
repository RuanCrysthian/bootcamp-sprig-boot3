package com.bootcamp.dscatalog.repositories;

import com.bootcamp.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/* Para usar operações prontas feitas pelo JPA */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
