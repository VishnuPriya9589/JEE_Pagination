package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;

@WebServlet("/delete.do")
public class DeleteProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer productId = Integer.parseInt(request.getParameter("product_id"));

        Product product = new Product(productId);
        product.deleteProduct();

        request.getRequestDispatcher("show.do").forward(request, response);
    }
}
