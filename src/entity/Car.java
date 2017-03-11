package entity;

public class Car {
	private String carNumber;
	private String carType;
	private String carCompany;
	private String carPurchase;
	private int carUsetime;
	public Car(){
		
	}
	public Car(String carNumber,String carType,String carCompany,String carPurchase,int carUsetime){
		this.carNumber = carNumber;
		this.carType = carType;
		this.carCompany = carCompany;
		this.carPurchase = carPurchase;
		this.carUsetime = carUsetime;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarPurchase() {
		return carPurchase;
	}
	public void setCarPurchase(String carPurchase) {
		this.carPurchase = carPurchase;
	}
	public int getCarUsetime() {
		return carUsetime;
	}
	public void setCarUsetime(int carUsetime) {
		this.carUsetime = carUsetime;
	}
	
}
