package com.bootcamp.dscatalog.dto;

import com.bootcamp.dscatalog.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDTO implements Serializable {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  Set<RoleDTO> roles = new HashSet<>();

  public UserDTO(User entity) {
    this.id = entity.getId();
    this.firstName = entity.getFirstName();
    this.lastName = entity.getLastName();
    this.email = entity.getEmail();
    entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role))); // pegando a lista de role, percorre a lista e instancia no objeto RoleDTO
  }
}
