package com.bootcamp.dscatalog.dto;

import com.bootcamp.dscatalog.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO implements Serializable {

  private Long id;
  private String authority;

  public RoleDTO(Role role) {
    id = role.getId();
    authority = role.getAuthority();
  }
}
