package org.zerhusen.eniity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USER")
public class User {

   @JsonIgnore
   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
   @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
   private Long id;

   @Column(name = "USERNAME", length = 50, unique = true)
   @NotNull
   @Size(min = 4, max = 50)
   private String username;

   @JsonIgnore
   @Column(name = "PASSWORD", length = 100)
   @NotNull
   @Size(min = 4, max = 100)
   private String password;

   @Column(name = "FIRSTNAME", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String firstname;

   @Column(name = "LASTNAME", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String lastname;

   @Column(name = "EMAIL", length = 50)
   @NotNull
   @Size(min = 4, max = 50)
   private String email;

   @JsonIgnore
   @Column(name = "ACTIVATED")
   @NotNull
   private boolean activated;

   @ManyToMany
   @JoinTable(
      name = "USER_AUTHORITY",
      joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
      inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_NAME", referencedColumnName = "NAME")})
   @BatchSize(size = 20)
   private Set<Authority> authorities = new HashSet<>();
}
