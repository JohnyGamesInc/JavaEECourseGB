package ru.gb.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");

        String appPath = getServletConfig().getServletContext().getContextPath();

        resp.getWriter().printf("<h1>Order</h1>");
        resp.getWriter().printf("<ul>" +
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
}
