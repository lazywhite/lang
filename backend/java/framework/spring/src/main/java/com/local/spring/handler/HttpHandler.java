package com.local.spring.handler;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by white on 17/7/13.
 */
public class HttpHandler implements HttpRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request", "request");
        request.getSession().setAttribute("session", "session");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
