package org.zerhusen.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.eniity.Person;
import org.zerhusen.eniity.Result;

@RestController
@RequestMapping("/api")
public class PersonRestController {

   @GetMapping("/person")
   public Result getPerson() {
      Result result = new Result();
      result.setCode(200);
      result.setMsg("请求成功！");
      result.setData(new Person("John Doe", "john.doe@test.org"));
      return result;
   }
}
