package ru.gb.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class MainServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
        String appPath = getServletConfig().getServletContext().getContextPath();

        servletResponse.getWriter().println("<h1>Main</h1>");

        servletResponse.getWriter().printf("<ul>" +
                "<li><a href=%s/%s>Main</a></li>" +
                "<li><a href=%s/%s>Catalog</a></li>" +
                "<li><a href=%s/%s>Product</a></li>" +
                "<li><a href=%s/%s>Order</a></li>" +
                "<li><a href=%s/%s>Cart</a></li>" +
                "</ul>",
                appPath, "main",
                appPath, "catalog",
                appPath, "product",
                appPath, "order",
                appPath, "cart");
    }

    @Override
    public String getServletInfo() {
        return "Servlet is: " + this.getClass().getName();
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
