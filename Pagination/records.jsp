<%@ page import="java.util.ArrayList,models.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-10 p-5">
                <div>
                    <% int start = Integer.parseInt(request.getParameter("start")); %>
                    <% ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products"); %>
                    <% if(products.size() == 0) { %>    
                        <div style="font-size:32px;color:red">No Records Found...</div>
                        <% if(start<=0) { %>
                            <a href="show.do?start=<%= start+5 %>" class="btn btn-info">Next</a>
                        <% } else { %>
                            <a href="show.do?start=<%= start-5 %>" class="btn btn-info">Prev</a>
                        <% } %>
                    <% }
                     else { %>
                        <table class="table table-secondary table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>Sr.No</th>
                                    <th>Product Name</th>
                                    <th>Company Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Discount</th>
                                    <th>Production Date</th>
                                    <th>Action</th>
                                </tr>
                            </thead>            
                                
                            <tbody>
                                <% for(Product product : products) { %>
                                    <tr>
                                        <td><%= product.getProductId() %></td>
                                        <td><%= product.getProductName() %></td>
                                        <td><%= product.getCompanyName() %></td>
                                        <td><%= product.getPrice() %></td>
                                        <td><%= product.getQuantity() %></td>
                                        <td><%= product.getDiscount() %></td>
                                        <td><%= product.getProductionDate() %></td>
                                        <td>
                                            <a href="update.do?product_id=<%= product.getProductId() %>" class="me-3">
                                                <img src="edit_2.png" width="24px">
                                            </a>
                                            <a href="delete.do?product_id=<%= product.getProductId() %>">
                                                <img src="delete.png" width="24px">
                                            </a>
                                        </td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
        
                        <div>
                          <a href="show.do?start=<%= start-5%>" class="btn btn-info">Prev</a>
                          <a href="show.do?start=<%= start+5 %>" class="btn btn-info">Next</a>
                        </div>
                    <% } %>
                </div>
                
            </div>
        </div>
    </div>    
</body>
</html>