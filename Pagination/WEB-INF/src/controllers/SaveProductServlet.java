package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

import models.Product;

@WebServlet("/save.do")
public class SaveProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        String productName = request.getParameter("product_name");
        Date productionDate = Date.valueOf(request.getParameter("production_date"));
        String companyName = request.getParameter("company_name");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Float discount = Float.parseFloat(request.getParameter("discount"));
        
        Product product = new Product(productName, companyName, price, quantity, discount, productionDate);
        if(product.saveProductInfo())
            session.setAttribute("message", "success");
            // request.setAttribute("message","success");
            // request.setAttribute("dynamic",dynamic);
        
        // request.getRequestDispatcher("index.jsp").forward(request, response);
        response.sendRedirect("index.jsp");
    }
}