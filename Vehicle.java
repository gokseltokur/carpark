// Göksel Tokur 150116049
public class Vehicle {

	private String plateNumber;
	private int size;

	// Vehicle Class' constructor.
	public Vehicle(String plateNumber, int size){
		this.plateNumber = plateNumber;
		this.size = size;
	}
	// Getting vehicle's plate number.
	public String getPlateNumber(){
		return plateNumber;
	}
	// Getting vehicle's size.
	public int getSize(){
		return size;
	}
	// Printing Vehicle's info method.
	public String getVehicleInfo(){
		String a = "Vehicle Info\nPlate Number : " + getPlateNumber() + "\nSize : " + getSize();
		return a;
	}

	public void setSize(int newSize){
		this.size = newSize;
	}


}
