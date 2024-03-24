package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import models.Product;

@WebServlet("/show.do")
public class ShowProductsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer start = Integer.parseInt(request.getParameter("start"));
        if(start>=0){
            ArrayList<Product> products = Product.collectAllProducts(start);
            request.setAttribute("products", products);
        }else{
            ArrayList<Product> products =new ArrayList<>();
            request.setAttribute("products", products);
        }
        request.getRequestDispatcher("records.jsp").forward(request, response);
    }
}
