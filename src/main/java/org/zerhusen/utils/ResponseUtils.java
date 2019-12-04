package org.zerhusen.utils;


import org.zerhusen.eniity.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {

    public static void result(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        printWriter.write(JsonUtils.object2json(result));
        printWriter.flush();
    }
}
