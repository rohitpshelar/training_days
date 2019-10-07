package com.depu.shwetu;

public class Student  implements java.io.Serializable {

    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rollno;
     private String name;

    // Constructors

    /** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(Integer rollno) {
        this.rollno = rollno;
    }
    
    /** full constructor */
    public Student(Integer rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

   
    // Property accessors

    public Integer getRollno() {
        return this.rollno;
    }
    
    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   

}