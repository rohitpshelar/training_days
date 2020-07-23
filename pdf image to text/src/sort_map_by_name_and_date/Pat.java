package sort_map_by_name_and_date;

import java.sql.Date;

public class Pat {

	String name;
	Date bdd;
	java.util.Date expDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBdd() {
		return bdd;
	}
	public void setBdd(Date bdd) {
		this.bdd = bdd;
	}
	public java.util.Date getExpDate() {
		return expDate;
	}
	public void setExpDate(java.util.Date expDate) {
		this.expDate = expDate;
	}
	public Pat(String name, Date bdd, java.util.Date expDate) {
		super();
		this.name = name;
		this.bdd = bdd;
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Pat [name=" + name + ", bdd=" + bdd + ", expDate=" + expDate + "]";
	}
	
	
	
}
