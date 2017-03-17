package lab3;

public class Table {

    protected int noOfSeats;
    protected int tableId;

    public Table(int id, int seats) {
        this.tableId = id;
        this.noOfSeats = seats;
    }

    int getId() {
        return tableId;
    }

    int getSeats() {
        return noOfSeats;
    }
}
