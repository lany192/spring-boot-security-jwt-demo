package org.zerhusen.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.eniity.Person;

@RestController
@RequestMapping("/api")
public class PersonRestController {

   @GetMapping("/person")
   public ResponseEntity<Person> getPerson() {
      return ResponseEntity.ok(new Person("John Doe", "john.doe@test.org"));
   }
}
