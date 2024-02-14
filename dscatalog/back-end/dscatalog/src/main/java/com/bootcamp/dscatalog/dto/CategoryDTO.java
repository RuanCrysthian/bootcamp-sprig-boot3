package com.bootcamp.dscatalog.dto;

import com.bootcamp.dscatalog.entities.Category;

import java.io.Serializable;

/*
 * DTO: são usados para evitar que o controller tenha acesso à uma entidade.
 * o que é transferido entre o controller e o service é o DTO (data transfer object).
 * Esse objeto não tem dependencia com a JPA, ele apenas carrega dados.
 * Vantagens:
 *  - é possível controlar quais dados serão apresentados para o controller
 *  - melhora a segurança de entidades e consequentemente da aplicação.
 *  - Diminui o tráfego na rede
 */
public class CategoryDTO implements Serializable {

  private Long id;
  private String name;

  public CategoryDTO() {
  }

  public CategoryDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  // usado para popular um DTO apenas informando sua entidade correspondente
  public CategoryDTO(Category entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
