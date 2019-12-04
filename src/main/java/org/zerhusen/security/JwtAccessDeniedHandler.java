package org.zerhusen.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.zerhusen.eniity.Result;
import org.zerhusen.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
      // This is invoked when user tries to access a secured REST resource without the necessary authorization
      // We should just send a 403 Forbidden response because there is no 'error' page to redirect to
      // Here you can place any message you want
      //response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());

      log.info("错误403，访问" + request.getRequestURI() + "访问失败，" + accessDeniedException.getMessage());
      Result result = new Result();
      result.setCode(403);
      result.setMsg("权限不足！");
      ResponseUtils.result(response, result);
   }
}
