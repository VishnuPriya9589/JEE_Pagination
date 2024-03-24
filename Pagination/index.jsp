<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
    
    <% String message = (String)session.getAttribute("message"); %>
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-5 my-4">
                <% if(message != null) { %>
                    <div id="msg" class="alert alert-success m-auto my-3 h3">Product Record Is Saved!!</div>        
                <% } %>
                
                <a href="show.do?start=0" class="btn btn-danger">Show Products</a>
                <input type="number" name="dynamic" >
                
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-lg-5 col-sm-8 col-12 p-5 border border-secondary rounded" style="background-color: #eee;">
                <form action="save.do">
                    <div class="mb-3">
                        <label for="pname" class="h5">Product Name</label>
                        <select id="pname" name="product_name" class="form-select">
                            <option>Select</option>
                            <option>Laptop</option>
                            <option>Tablet</option>
                            <option>Smart Watch</option>
                            <option>Smart Phone</option>
                        </select> 
                    </div>

                    <div class="form-check mb-3">
                        <label for="" class="h5">Company Name</label>
                        <div class="form-check">
                            <input type="radio" class="form-check-input" id="cnm1" name="company_name" value="HP">
                            <label for="cnm1" class="form-check-label h5">HP</label>
                        </div>

                        <div class="form-check">
                            <input type="radio" class="form-check-input" id="cnm2" name="company_name" value="DELL">
                            <label for="cnm2" class="form-check-label h5">Dell</label>
                        </div>
                         
                        <div class="form-check">
                            <input type="radio" class="form-check-input" id="cnm3" name="company_name" value="ASUS">
                            <label for="cnm3" class="form-check-label h5">Asus</label>
                        </div>                         
                    </div>

                    <div class="mb-3">
                        <label for="price" class="h5">Price</label>
                        <input type="number" class="form-control" id="price" name="price">
                    </div>

                    <div class="mb-3">
                        <label for="quantity" class="h5">Quantity</label>
                        <input type="number" class="form-control" id="quantity" name="quantity">
                    </div>

                    <div class="mb-3">
                        <label for="discount" class="h5">Discount(%)</label>
                        <input type="text" class="form-control" id="discount" name="discount">
                    </div>

                    <div class="mb-3">
                        <label for="production_date" class="h5">Production Date</label>
                        <input type="date" class="form-control" id="production_date" name="production_date">
                    </div>

                    <input type="submit" class="btn btn-primary" value="Save">
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>