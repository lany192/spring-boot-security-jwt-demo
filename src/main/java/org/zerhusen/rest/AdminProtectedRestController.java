package org.zerhusen.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerhusen.eniity.Result;

@RestController
@RequestMapping("/api")
public class AdminProtectedRestController {

   @GetMapping("/hiddenmessage")
   public Result getAdminProtectedGreeting() {
      Result result = new Result();
      result.setCode(200);
      result.setMsg("请求成功！");
      return result;
   }
}
