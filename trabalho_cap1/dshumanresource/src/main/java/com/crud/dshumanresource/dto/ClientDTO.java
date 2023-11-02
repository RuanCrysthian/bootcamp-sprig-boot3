package com.crud.dshumanresource.dto;

import java.io.Serializable;
import java.time.Instant;

import com.crud.dshumanresource.models.Client;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientDTO implements Serializable {

  private Long id;
  private String name;
  private String cpf;
  private Double income;
  private Instant birthDate;
  private Integer children;

  public ClientDTO(Client entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.cpf = entity.getCpf();
    this.income = entity.getIncome();
    this.birthDate = entity.getBirthDate();
    this.children = entity.getChildren();
  }

}
