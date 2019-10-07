package com.hibernate;

public class Reg  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String fname;
     private String lname;
     private String gender;
     private String qual;
     private String adds;
     private String lang;
     private String uname;
     private String pw;
     private String photo;


    // Constructors

    /** default constructor */
    public Reg() {
    }

	/** minimal constructor */
    public Reg(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Reg(Integer id, String fname, String lname, String gender, String qual, String adds, String lang, String uname, String pw, String photo) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.qual = qual;
        this.adds = adds;
        this.lang = lang;
        this.uname = uname;
        this.pw = pw;
        this.photo = photo;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQual() {
        return this.qual;
    }
    
    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getAdds() {
        return this.adds;
    }
    
    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getLang() {
        return this.lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPw() {
        return this.pw;
    }
    
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
   








}