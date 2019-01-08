// Göksel Tokur 150116049
public class Ticket {
	private Vehicle vehicle;
	private java.util.Date entryDate;
	private java.util.Date exitDate;
	private double totalPrice;
	public static int numberOfTickets;
	// Ticket Class' constructor. Setting variable of vehicle and entryDate.
	public Ticket(Vehicle vehicle, java.util.Date entryDate){
		this.vehicle = vehicle;
		this.entryDate = entryDate;
	}
	// Price Calculater method. consist of 3 factor vehicle's size, carpark's hourlyPrice and number of hours.
	public double calculatePrice(double hourlyPrice, java.util.Date exitDate){

		int numberOfHours = (int)Math.ceil((double)(exitDate.getTime() - entryDate.getTime())/3600000)  ;
		double parkingCost = vehicle.getSize() * hourlyPrice * numberOfHours;
		totalPrice = parkingCost;
		return parkingCost;
	}

	public String getTicketInfo(){
		// if vehicle do not exit yet, ticket info is this.
		if(exitDate == null){
			String a = "Ticket Info\nPlate Number : " + vehicle.getPlateNumber() + "\nEntry : " + entryDate ;
			return a;
		}
		// Printing ticket info
		else{
			int hours = (int)Math.ceil((double)(exitDate.getTime() - entryDate.getTime())/3600000) ;
			String b = "Ticket Info\nPlate Number : " + vehicle.getPlateNumber() + "\nEntry : " + entryDate
					+ "\nExit : " + exitDate + "\nHour : " + hours
					+ "\nFee : " + totalPrice + " TLs" ;
			return b;
		}

	}
	// Getting vehicle method.
	public Vehicle getVehicle(){
		return vehicle;
	}
	// Get total price.
	public double getPrice(){
		return totalPrice;
	}
	// Get entry date.
	public java.util.Date getEntryDate(){
		return entryDate;
	}
	// Setter of total price.
	public void setPrice(double newPrice){
		this.totalPrice = newPrice;
	}
	// Setter of entry date.
	public void setEntryDate(java.util.Date newEntryDate){
		this.entryDate = newEntryDate;
	}
	// Setter of exit date.
	public void setExitDate(java.util.Date newExitDate){
		this.exitDate = newExitDate;
	}



}
