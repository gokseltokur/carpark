// Göksel Tokur 150116049
public class CarPark {

	private int capacity;
	public ParkPlace[] parkPlaceArray;
	public Ticket[] ticketArray;
	private double hourlyPrice;
	private static int parkPlaceCounter = 0;
	private static int ticketCounter = 0;


	// Carpark's constructor, set capacity of carpark and hourly price.
	public CarPark(int capacity, double hourlyPrice){
		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
		parkPlaceArray = new ParkPlace[capacity*10];
		ticketArray = new Ticket[capacity*10];


	}


	//Parking vehicle method
	public Ticket parkVehicle(Vehicle vehicle, java.util.Date entryDate){
		boolean boo = false;
		//if capacity enough for vehicle, boolean is true otherwise boolean is false
		if(vehicle.getSize() <= capacity)
			boo = true;
		// if capacity is not enough, program print error message.
		if(boo == false){
			System.out.println("Car park is full! " + "The vehicle with " + vehicle.getPlateNumber() + " plate number cannot be parked.");
			return null;
		}
		// if capacity is enough for vehicle, it can park in our car park.
		else if(boo == true){

			ParkPlace parked = new ParkPlace(vehicle);
			parkPlaceArray[parkPlaceCounter] = parked;
			// When vehicle parked, car park's capacity decrease as vehicle's size.
			capacity = capacity - vehicle.getSize();

			System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");
			parkPlaceCounter++;


		}
		// Create new ticket.
		Ticket tick = new Ticket(vehicle, entryDate);
		return tick;

	}


	// Method for vehicle exit.
	public Vehicle exitVehicle(Ticket ticket, java.util.Date exitDate){
		//Loop for placing tickets to ticket array and vehicle exiting.
		for(int i = 0 ; i<parkPlaceCounter ; i++){
			if(ticket.getVehicle().getPlateNumber() == parkPlaceArray[i].getVehicle().getPlateNumber() ){
				ticketArray[ticketCounter] = ticket;
				ticketArray[ticketCounter].setExitDate(exitDate);

				//Calculating price.
				double price = ticketArray[ticketCounter].calculatePrice(hourlyPrice, exitDate);
				System.out.println("The price for vehicle with " + ticket.getVehicle().getPlateNumber()
						+ " plate number is: " + price + " TLs");

				ticketArray[ticketCounter].setPrice(price);
				ticketCounter++;
				//When the vehicle exits, capacity increase as vehicle's size.
				capacity = capacity + ticket.getVehicle().getSize();

				parkPlaceArray[i].getVehicle().setSize(0);


				Ticket.numberOfTickets++;
			}
		}

		return ticket.getVehicle();


	}
	// Method for total income.
	public double getTotalIncome(){
		double total = 0 ;
		for(int i = 0; i < ticketCounter; i++ ){
			total = total + ticketArray[i].getPrice();

		}

		return total;


	}
	// Method for printing vehicle list.
	public void printVehicleList(){
		System.out.println("VEHICLE LIST:");
		System.out.println("--------------");
		for(int i = 0 ; i < parkPlaceCounter ; i++){
			if(parkPlaceArray[i].getVehicle().getSize() != 0){
				System.out.println(parkPlaceArray[i].getVehicle().getVehicleInfo() + "\n");
			}
		}
		System.out.println("-----------------------------------------------------");
	}
	// Method for printing tickets.
	public void printTickets(){
		for(int i = 0 ; i < ticketCounter ; i++){
			System.out.println(ticketArray[i].getTicketInfo() + "\n");

		}
	}

	public int getCapacity(){
		return capacity;
	}

	public double getHourlyPrice(){
		return hourlyPrice;
	}





}
