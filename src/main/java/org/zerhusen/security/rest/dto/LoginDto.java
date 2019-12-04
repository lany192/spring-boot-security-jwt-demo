package org.zerhusen.security.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginDto {

   @NotNull
   @Size(min = 1, max = 50)
   private String username;

   @NotNull
   @Size(min = 4, max = 100)
   private String password;

   private Boolean rememberMe;
}
