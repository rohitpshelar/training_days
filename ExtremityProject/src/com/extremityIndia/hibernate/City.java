package com.extremityIndia.hibernate;



/**
 * City generated by MyEclipse - Hibernate Tools
 */

public class City  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cityid;
     private State state;
     private String cityname;


    // Constructors

    /** default constructor */
    public City() {
    }

    
    /** full constructor */
    public City(Integer cityid, State state, String cityname) {
        this.cityid = cityid;
        this.state = state;
        this.cityname = cityname;
    }

   
    // Property accessors

    public Integer getCityid() {
        return this.cityid;
    }
    
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public State getState() {
        return this.state;
    }
    
    public void setState(State state) {
        this.state = state;
    }

    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
   








}