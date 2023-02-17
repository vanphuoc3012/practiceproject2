package com.likelion.spring.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.likelion.spring.dto.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Component
@Order(1)
public class BrowserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String browserName = request.getHeader("user-agent");
        String method = request.getMethod();
        if(browserName.contains("Postman") && method.equals("GET")){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setTimestamp(LocalDateTime.now().toString());
            errorResponse.setStatus(String.valueOf(HttpStatus.FORBIDDEN.value()));
            errorResponse.setError(HttpStatus.FORBIDDEN.name());
            errorResponse.setMessage("You have called method 'GET' using Postman, which is not allowed in our system. Please use another browser.");
            errorResponse.setPath(request.getServletPath());

            ObjectMapper objectMapper = new ObjectMapper();
            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse));
            writer.close();
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
