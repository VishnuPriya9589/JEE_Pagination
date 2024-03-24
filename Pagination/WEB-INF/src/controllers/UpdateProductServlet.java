package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Date;

import models.Product;

@WebServlet("/update.do")
public class UpdateProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer productId = Integer.parseInt(request.getParameter("product_id"));

        Product product = new Product(productId);
        product.fetchProductInfo();

        request.setAttribute("product", product);

        request.getRequestDispatcher("edit_product.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
        Integer productId = Integer.parseInt(request.getParameter("product_id"));
        String productName = request.getParameter("product_name");
        String companyName = request.getParameter("company_name");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Float discount = Float.parseFloat(request.getParameter("discount"));
        Date productionDate = Date.valueOf(request.getParameter("production_date"));

        Product product = new Product(productId, productName, companyName, price, quantity, discount, productionDate);
        product.updateProductInfo();

        request.getRequestDispatcher("show.do").forward(request, response);
    }    
}
