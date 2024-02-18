package com.bootcamp.dscatalog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String email;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER) // força que sempre vai trazer os ROLES do usuário
  @JoinTable(
    name = "tb_user_role",
    joinColumns = @JoinColumn(
      name = "user_id"
    ),
    inverseJoinColumns = @JoinColumn(
      name = "role_id"
    )
  )
  private Set<Role> roles = new HashSet<>();
}
