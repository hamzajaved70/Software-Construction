package lab3;

public class Booking {

    private final int numOfGuests;
    private final String timeOfArrival;
    private final String dateOfArrival;
    private final String name;
    private final int bookingId;
    private static int counter = 0;

    public Booking(String nameG, int guests, String date, String time) {
        this.name = nameG;
        this.numOfGuests = guests;
        this.timeOfArrival = time;
        this.dateOfArrival = date;
        this.bookingId = counter++;
    }

    public int getId() {
        return bookingId;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return timeOfArrival;
    }
    
    public String getDate(){
        return dateOfArrival;
    }
    
    public int getGuests(){
        return numOfGuests;
    }
}
