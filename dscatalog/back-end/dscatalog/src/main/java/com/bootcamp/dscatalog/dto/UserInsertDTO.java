package com.bootcamp.dscatalog.dto;

import com.bootcamp.dscatalog.services.validation.UserInsertValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO {
  private String password;
}
