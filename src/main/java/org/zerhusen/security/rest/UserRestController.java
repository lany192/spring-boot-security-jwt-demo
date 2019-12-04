package org.zerhusen.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.eniity.Result;
import org.zerhusen.security.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

   private final UserService userService;

   public UserRestController(UserService userService) {
      this.userService = userService;
   }

   @GetMapping("/user")
   public Result getActualUser() {
      Result result = new Result();
      result.setCode(200);
      result.setMsg("请求成功！");
      result.setData(userService.getUserWithAuthorities().get());
      return result;
   }
}
