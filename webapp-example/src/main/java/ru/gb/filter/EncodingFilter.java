package ru.gb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class EncodingFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader("Content-Type", "text/html; charset=utf-8");

        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
    }

}
