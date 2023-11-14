package com.bootcamp.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bootcamp.dscatalog.entities.Product;
import com.bootcamp.dscatalog.factories.Factory;

@DataJpaTest
public class ProductRepositoryTests {

  @Autowired
  private ProductRepository repository;
  private long existingId;
  private long nonExistingId;
  private long countTotalProducts;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 300L;
    countTotalProducts = 25L;
  }

  @Test
  public void deleteShouldDeleteObjectWhenIdExists() {
    repository.deleteById(existingId);
    Optional<Product> result = repository.findById(existingId);
    Assertions.assertFalse(result.isPresent());
  }

  @Test
  public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
    Product product = Factory.createProduct();
    product.setId(null);
    product = repository.save(product);
    Assertions.assertNotNull(product.getId());
    Assertions.assertEquals(countTotalProducts + 1, product.getId());
  }
}
