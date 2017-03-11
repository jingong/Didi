package entity;

public class Driver {
	private int did;
	private String username;
	private String password;
	private String name;
	private String sex;
	private int age;
	private int driverage;
	private String phonenumber;
	public Driver(){
		
	}
	public Driver(String username,String password,String name,String sex,int age,int driverage,String phonenumber){
		//this.did = did;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.driverage = driverage;
		this.phonenumber = phonenumber;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDriverage() {
		return driverage;
	}
	public void setDriverage(int driverage) {
		this.driverage = driverage;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}
