package lab3;

import java.util.*;

public class Order {

    Scanner sc = new Scanner(System.in);
    HashMap<Table, Booking> hm;
    HashMap<Table, Integer> unbooked;
    Restaurant r1;

    public Order(Restaurant r) {
        this.hm = new HashMap<>();
        this.unbooked = new HashMap<>();
        this.r1 = r;
    }

    void orderSystem() {
        int choice;
        int sCounter = 0, mCounter = 0, lCounter = 0, eCounter = 0;
        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Make Reservation");
            System.out.println("2. Check Reservations");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name under Reservation");
                    String name = sc.next();
                    System.out.println("Enter number of Guests");
                    int guests = sc.nextInt();
                    System.out.println("Enter time of Arrival: \n hh mm");
                    int hTime = sc.nextInt();
                    int mTime = sc.nextInt();
                    System.out.println("Enter date of Arrival: \n dd mm");
                    int dateD = sc.nextInt();
                    int dateM = sc.nextInt();
                    String dateTime = Integer.toString(hTime) + Integer.toString(mTime) + Integer.toString(dateD) + Integer.toString(dateM);
                    Booking booking1 = new Booking(name, guests, dateTime);
                    int tableType = assignTable(guests, hTime);
                    if (tableType == 1) {
                        hm.put(r1.smallTables.get(sCounter), booking1);
                        sCounter++;
                    } else if (tableType == 2) {
                        hm.put(r1.mediumTables.get(mCounter), booking1);
                        mCounter++;
                    } else if (tableType == 3) {
                        hm.put(r1.largeTables.get(lCounter), booking1);
                        lCounter++;
                    } else if (tableType == 4) {
                        hm.put(r1.extraTables.get(eCounter), booking1);
                        eCounter++;
                    }

                    break;
                case 2:
                    Set set = hm.entrySet();
                    Iterator i = set.iterator();
                    while (i.hasNext()) {
                        Map.Entry me = (Map.Entry) i.next();
                        Table testTable = (Table) me.getKey();
                        System.out.print(testTable.getId() + ": ");
                        Booking test = (Booking) me.getValue();
                        System.out.println(test.getName() + "\n" + "Time and Date :" + test.getTime());
                    }
                    break;
                default:
                    System.out.println();
            }
        }
    }

    public int assignTable(int guests, int hour) {
        if (guests <= 12 && guests > 6) {
            return 4;
        }
        if (hour > 11 || hour < 22) {
            if (guests <= 2) {
                return 1;
            }
            if (guests <= 4 && guests > 2) {
                return 2;
            }
            if (guests <= 6 && guests > 4) {
                return 3;
            } else {
                return 0;
            }
        } else {
            System.out.println("Restaurant is closed during these hours!");
            return 0;
        }
    }

}
