package com.bootcamp.dscatalog.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity // Para definir que a classe é uma entidade (tabela) no banco de dados
@Table(name = "tb_category") // Para definir o nome da tabela no banco de dados
public class Category implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Category() {
  }

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
