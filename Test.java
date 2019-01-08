// Göksel Tokur 150116049
public class Test {

	public static void main(String[] args) {
		// Manual Set DATE
		java.util.Date enter1 = new java.util.Date();
		enter1.setDate(25);enter1.setHours(21);enter1.setMinutes(46);enter1.setSeconds(00);
		java.util.Date enter2 = new java.util.Date();
		enter2.setDate(25);enter2.setHours(22);enter2.setMinutes(46);
		java.util.Date enter3 = new java.util.Date();
		enter3.setDate(25);enter3.setHours(23);enter3.setMinutes(46);
		java.util.Date enter4 = new java.util.Date();
		enter4.setDate(26);enter4.setHours(00);enter4.setMinutes(46);

		java.util.Date exit1 = new java.util.Date();
		exit1.setDate(26);exit1.setHours(01);exit1.setMinutes(46);exit1.setSeconds(00);
		java.util.Date exit2 = new java.util.Date();
		exit2.setDate(26);exit2.setHours(01);exit2.setMinutes(46);
		java.util.Date exit3 = new java.util.Date();
		exit3.setDate(26);exit3.setHours(04);exit3.setMinutes(46);
		java.util.Date exit4 = new java.util.Date();
		exit4.setDate(26);exit4.setHours(04);exit4.setMinutes(46);
		// FINISHED Manual Set DATE

		//Create new carpark
		CarPark carpark = new CarPark(10, 5);
		System.out.println("The car park with the capacity of "+ carpark.getCapacity() + " and the hourly price of " + carpark.getHourlyPrice() +" is created!");
		//Create vehicles
		Vehicle vehicle1 = new Vehicle("34KG3916", 4);
		Vehicle vehicle2 = new Vehicle("34CSE1141", 2);
		Vehicle vehicle3 = new Vehicle("34GV8993", 1);
		Vehicle vehicle4 = new Vehicle("34AN4876", 2);
		Vehicle vehicle5 = new Vehicle("07FF444", 4);

		//Park Vehicles
		Ticket a = carpark.parkVehicle(vehicle1, enter1);
		Ticket b = carpark.parkVehicle(vehicle2, enter2);
		Ticket c = carpark.parkVehicle(vehicle3, enter3);
		Ticket d = carpark.parkVehicle(vehicle4, enter4);
		Ticket e = carpark.parkVehicle(vehicle5, enter4);
		System.out.println();
		//Print vehicle list
		carpark.printVehicleList();
		//Exit two car
		carpark.exitVehicle(a, exit1);
		carpark.exitVehicle(b, exit2);
		System.out.println();
		//Print vehicle list
		carpark.printVehicleList();
		System.out.println();



		//Exit two car
		carpark.exitVehicle(c, exit3);
		carpark.exitVehicle(d, exit4);
		System.out.println();
		//Print car park's total income
		System.out.println("Total Income: " + carpark.getTotalIncome());
		System.out.println();
		//Print number of tickets
		System.out.println("Total number of tickets: " + Ticket.numberOfTickets);
		System.out.println();
		//Print tickets
		carpark.printTickets();


	}

}
