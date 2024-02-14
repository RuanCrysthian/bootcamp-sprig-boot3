package com.bootcamp.dscatalog.repositories;

import com.bootcamp.dscatalog.entities.Product;
import com.bootcamp.dscatalog.factories.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class ProductRepositoryTests {

  @Autowired
  private ProductRepository repository;

  private long existingId;
  private long nonExistingId;
  private long countTotalProducts;

  @BeforeEach
  void setUp() {
    existingId = 1L;
    nonExistingId = 1000L;
    countTotalProducts = 25L;
  }

  @Test
  @DisplayName("Save Should Persist With Auto Increment When Id Is Null")
  public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {

    Product product = Factory.createProduct();
    product.setId(null);

    product = repository.save(product);
    Optional<Product> result = repository.findById(product.getId());

    Assertions.assertNotNull(product.getId());
    Assertions.assertEquals(countTotalProducts + 1L, product.getId());
    Assertions.assertTrue(result.isPresent());
    Assertions.assertSame(result.get(), product);
  }

  @Test
  @DisplayName("Delete Should Delete Object When Id Exists")
  public void deleteShouldDeleteObjectWhenIdExists() {

    repository.deleteById(existingId);

    Optional<Product> result = repository.findById(existingId);

    Assertions.assertFalse(result.isPresent());
  }

  @Test
  @DisplayName("Delete Should Not Delete Object When Id Does not Exist")
  public void deleteShouldNotDeleteObjectWhenIdDoesNotExist() {
    repository.deleteById(nonExistingId);
    Optional<Product> result = repository.findById(nonExistingId);
    Assertions.assertTrue(result.isEmpty());
  }

  @Test
  @DisplayName("findById Should Return Not Empty When Id Exist")
  public void findByIdShouldReturnNotEmptyWhenIdExist() {
    Optional<Product> result = repository.findById(existingId);
    Assertions.assertFalse(result.isEmpty());
  }

  @Test
  @DisplayName("findById Should Return Empty When Id Does Not Exist")
  public void findByIdShouldReturnEmptyWhenIdDoesNotExist() {
    Optional<Product> result = repository.findById(nonExistingId);
    Assertions.assertTrue(result.isEmpty());
  }
}
