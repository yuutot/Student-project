package com.itea.filter;

import com.itea.entity.Student;
import com.itea.entity.Teacher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/student")
public class StudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String id = servletRequest.getParameter("id");

        if (id == null) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            Object user = session.getAttribute("user");
            if(!(user instanceof Student)) {
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/home");
                requestDispatcher.forward(servletRequest, servletResponse);
            } else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}
