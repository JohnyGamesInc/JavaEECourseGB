package gb.servlet;

import gb.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static gb.listener.ContextListener.PRODUCT_REPO;

@WebServlet(name = "ControllerServlet", urlPatterns = {"", "/main", "/catalog"})
public class ControllerServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ControllerServlet.class);

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute(PRODUCT_REPO);

        if (this.productRepository == null) {
            throw new ServletException("Product Repository is not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/WEB-INF/templates/";
        if (request.getServletPath().equals("/") ||
                request.getServletPath().equals("/main")) {
            url += "index.jsp";
        } else if (request.getServletPath().equals("/catalog")) {
            url += "catalog.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
