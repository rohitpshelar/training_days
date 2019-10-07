package com.extremityIndia.hibernate;



/**
 * Customer generated by MyEclipse - Hibernate Tools
 */

public class Customer  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
     private String cname;
     private String addr;
     private String mbno;


    // Constructors

    /** default constructor */
    public Customer() {
    }

    
    /** full constructor */
    public Customer(Integer cid, String cname, String addr, String mbno) {
        this.cid = cid;
        this.cname = cname;
        this.addr = addr;
        this.mbno = mbno;
    }

   
    // Property accessors

    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddr() {
        return this.addr;
    }
    
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMbno() {
        return this.mbno;
    }
    
    public void setMbno(String mbno) {
        this.mbno = mbno;
    }
   








}