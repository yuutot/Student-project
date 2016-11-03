package com.itea.filter;

import com.itea.entity.Teacher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.contains("auth") || path.contains("style")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            Object user = session.getAttribute("user");
            if (user == null) {
                servletRequest.getRequestDispatcher("/auth").forward(servletRequest, servletResponse);
            }else{
                if(!(user instanceof Teacher) && (path.contains("add")||path.contains("home"))){
                    servletRequest.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(servletRequest,servletResponse);
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}
