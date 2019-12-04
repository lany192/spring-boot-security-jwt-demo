package org.zerhusen.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.zerhusen.eniity.Result;
import org.zerhusen.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

   @Override
   public void commence(HttpServletRequest request,
                        HttpServletResponse response,
                        AuthenticationException authException) throws IOException {
      // This is invoked when user tries to access a secured REST resource without supplying any credentials
      // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
      // Here you can place any message you want
//      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

      log.info("错误401，访问" + request.getRequestURI() + "访问失败，" + authException.getMessage());
      Result result = new Result();
      result.setCode(401);
      result.setMsg("权限不足！");
      ResponseUtils.result(response, result);
   }
}
