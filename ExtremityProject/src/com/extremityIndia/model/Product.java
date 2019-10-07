package com.extremityIndia.model;



public class Product  implements java.io.Serializable {


    // Fields    

     private Integer pid;
     private String pname;
     private String price;


    // Constructors

    /** default constructor */
    public Product() {
    }

    
    /** full constructor */
    public Product(Integer pid, String pname, String price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

   
    // Property accessors

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
   








}