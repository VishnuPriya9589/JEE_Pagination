package models;

import java.sql.*;
import java.util.ArrayList;

public class Product {
    private Integer productId;
    private String productName;
    private Date productionDate;
    private String companyName;
    private Integer price;
    private Integer quantity;
    private Float discount;

    public Product(String productName, String companyName, Integer price, Integer quantity, Float discount, Date productionDate) {
        this.productName = productName;
        this.companyName = companyName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.productionDate = productionDate;
    }

    public Product(Integer productId, String productName, String companyName, Integer price, Integer quantity, Float discount, Date productionDate) {
        this(productName, companyName, price, quantity, discount, productionDate);
        this.productId = productId;
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public void deleteProduct() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Vishi@123");

            String query = "delete from products where product_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, productId);

            ps.executeUpdate();

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean updateProductInfo() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Vishi@123");

            String query = "update products set product_name=?,company_name=?,price=?,quantity=?,discount=?,production_date=? where product_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, productName);
            ps.setString(2, companyName);
            ps.setInt(3, price);
            ps.setInt(4, quantity);
            ps.setFloat(5, discount);
            ps.setDate(6, productionDate);

            ps.setInt(7, productId);

            int val = ps.executeUpdate();

            if(val == 1)
                flag = true;

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
             e.printStackTrace();
        }

        return flag;
    }

    public void fetchProductInfo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Vishi@123");

            String query = "select * from products where product_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                productName = rs.getString(2);
                companyName = rs.getString(3); 
                price = rs.getInt(4);
                quantity = rs.getInt(5);
                discount = rs.getFloat(6);
                productionDate = rs.getDate(7);
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> collectAllProducts(int start) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Vishi@123");
        
            String query = "select * from products order by product_id limit ?,5";
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, start);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getDate(7)));
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
    public boolean saveProductInfo() {
        boolean flag = false;

        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Vishi@123");

            String query = "insert into products (product_name, company_name, price, quantity, discount, production_date) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, productName);
            ps.setString(2, companyName);
            ps.setInt(3, price);
            ps.setInt(4, quantity);
            ps.setFloat(5, discount);
            ps.setDate(6, productionDate);

            int val = ps.executeUpdate();

            if(val == 1)
                flag = true; 

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Date getProductionDate() {
        return productionDate;
    }
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getDiscount() {
        return discount;
    }
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
