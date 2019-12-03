package enhanceWithNullObject;

public class Bean {

	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Bean [id=" + id + ", name=" + name + "]";
	}
	public Bean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
