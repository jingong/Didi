package entity;

public class DriverHistory {
	private String username;
	private String startpoint;
	private String endpoint;
	private String date;
	private String phonenumber;
	public DriverHistory(){
		
	}
	public DriverHistory(String username,String startpoint,String endpoint,String phonenumber,String date){
		this.username = username;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.date = date;
		this.phonenumber = phonenumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
