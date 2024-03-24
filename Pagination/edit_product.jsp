<%@ page import="models.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    <% Product product = (Product)request.getAttribute("product"); %>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-sm-8 col-12 p-5 border border-secondary rounded" style="background-color: #eee;">
                <form action="update.do" method="post">
                    <input type="hidden" name="product_id" value="<%= product.getProductId() %>">
                    <div class="mb-3">
                        <label for="pname" class="h5">Product Name</label>
                        <select id="pname" name="product_name" class="form-select">
                            <option>Select</option>
                            <% 
                                String productName = product.getProductName(); 
                                if(productName.equals("Laptop")) { 
                            %>
                                    <option selected>Laptop</option>
                            <%  } else { %>
                                    <option>Laptop</option>                            
                            <%  } if(productName.equals("Tablet")) { %>        
                                    <option selected>Tablet</option>
                            <%  } else { %>
                                    <option>Tablet</option>
                            <%  } if(productName.equals("Smart Watch")) { %>
                                    <option selected>Smart Watch</option>
                            <%  } else { %>
                                    <option>Smart Watch</option>
                            <%  } if(productName.equals("Smart Phone")) { %>
                                    <option selected>Smart Phone</option>
                            <%  } else { %>
                                    <option>Smart Phone</option>
                            <%  } %>
                        </select> 
                    </div>
            
                    <% String companyName = product.getCompanyName(); %>
                    <div class="form-check mb-3">
                        <label for="" class="h5">Company Name</label>
                        <div class="form-check">
                            <% if(companyName.equals("HP")) { %>
                                <input type="radio" checked class="form-check-input" id="cnm1" name="company_name" value="HP">
                            <% } else { %>
                                <input type="radio" class="form-check-input" id="cnm1" name="company_name" value="HP">
                            <% } %>
                            <label for="cnm1" class="form-check-label h5">HP</label>
                        </div>
            
                        <div class="form-check">
                            <% if(companyName.equals("DELL")) { %>
                                <input type="radio" checked class="form-check-input" id="cnm2" name="company_name" value="DELL">
                            <% } else { %>
                                <input type="radio" class="form-check-input" id="cnm2" name="company_name" value="DELL">
                            <% } %>
                            <label for="cnm2" class="form-check-label h5">Dell</label>
                        </div>
                         
                        <div class="form-check">
                            <% if(companyName.equals("ASUS")) { %>
                                <input type="radio" checked class="form-check-input" id="cnm3" name="company_name" value="ASUS">
                            <% } else { %>
                                <input type="radio" class="form-check-input" id="cnm3" name="company_name" value="ASUS">
                            <% } %>
                            <label for="cnm3" class="form-check-label h5">Asus</label>
                        </div>                         
                    </div>
            
                    <div class="mb-3">
                        <label for="price" class="h5">Price</label>
                        <input type="number" class="form-control" id="price" name="price" value="<%= product.getPrice() %>">
                    </div>
            
                    <div class="mb-3">
                        <label for="quantity" class="h5">Quantity</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" value="<%= product.getQuantity() %>">
                    </div>
            
                    <div class="mb-3">
                        <label for="discount" class="h5">Discount(%)</label>
                        <input type="text" class="form-control" id="discount" name="discount" value="<%= product.getDiscount() %>">
                    </div>
            
                    <div class="mb-3">
                        <label for="production_date" class="h5">Production Date</label>
                        <input type="date" class="form-control" id="production_date" name="production_date" value="<%= product.getProductionDate() %>">
                    </div>
            
                    <input type="submit" class="btn btn-primary" value="Update Product">
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>