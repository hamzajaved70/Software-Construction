package lab3;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Order {

    Scanner sc = new Scanner(System.in);
    HashMap<Table, Booking> hm;
    Restaurant r1;
    Connection con;
    Statement stmt;
    ResultSet rs;

    public Order(Restaurant r) {
        this.hm = new HashMap<>();
        this.r1 = r;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/RRS", "root", "root");
            stmt = con.createStatement();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
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
                    String User;
                    String Pass;
                    System.out.println("Enter Username");
                    User = sc.next();
                    System.out.println("Enter Password");
                    Pass = sc.next();
                    

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
                    String Date = Integer.toString(dateD) + Integer.toString(dateM);
                    String Time = Integer.toString(hTime) + Integer.toString(mTime);
                    Booking booking1 = new Booking(name, guests, Date, Time);
                    int tableType = assignTable(guests, hTime);
                    if (tableType == 1) {
                        if (checkExists(guests, hTime, dateD, dateM, sCounter) == false) {
                            hm.put(r1.smallTables.get(sCounter), booking1);
                            Table table = r1.smallTables.get(sCounter);
                            sCounter++;
                            try {
                                String aSQL = "INSERT INTO Reservation (nameG,guests,timeG,dateG,tableG)"
                                        + " VALUES ('" + name + "','" + guests + "','" + Time + "','" + Date + "','" + table.getId() + "')";
                                stmt.executeUpdate(aSQL);
                            } catch (SQLException err) {
                                System.out.println(err.getMessage());
                            }
                        } else {
                            System.out.println("This table is already booked at this time, Please select another time!");
                        }
                    } else if (tableType == 2) {
                        if (checkExists(guests, hTime, dateD, dateM, mCounter) == false) {
                            hm.put(r1.mediumTables.get(mCounter), booking1);
                            Table table = r1.mediumTables.get(mCounter);
                            mCounter++;
                            try {
                                String aSQL = "INSERT INTO Reservation (nameG,guests,timeG,dateG,tableG)"
                                        + " VALUES ('" + name + "','" + guests + "','" + Time + "','" + Date + "','" + table.getId() + "')";
                                stmt.executeUpdate(aSQL);
                            } catch (SQLException err) {
                                System.out.println(err.getMessage());
                            }
                        } else {
                            System.out.println("This table is already booked at this time, Please select another time!");
                        }
                    } else if (tableType == 3) {
                        if (checkExists(guests, hTime, dateD, dateM, lCounter) == false) {
                            hm.put(r1.largeTables.get(lCounter), booking1);
                            Table table = r1.largeTables.get(lCounter);
                            lCounter++;
                            try {
                                String aSQL = "INSERT INTO Reservation (nameG,guests,timeG,dateG,tableG)"
                                        + " VALUES ('" + name + "','" + guests + "','" + Time + "','" + Date + "','" + table.getId() + "')";
                                stmt.executeUpdate(aSQL);
                            } catch (SQLException err) {
                                System.out.println(err.getMessage());
                            }
                        } else {
                            System.out.println("This table is already booked at this time, Please select another time!");
                        }
                    } else if (tableType == 4) {
                        if (checkExists(guests, hTime, dateD, dateM, eCounter) == false) {
                            hm.put(r1.extraTables.get(eCounter), booking1);
                            Table table = r1.extraTables.get(eCounter);
                            eCounter++;
                            try {
                                String aSQL = "INSERT INTO Reservation (nameG,guests,timeG,dateG,tableG)"
                                        + " VALUES ('" + name + "','" + guests + "','" + Time + "','" + Date + "','" + table.getId() + "')";
                                stmt.executeUpdate(aSQL);
                            } catch (SQLException err) {
                                System.out.println(err.getMessage());
                            }
                        } else {
                            System.out.println("This table is already booked at this time, Please select another time!");
                        }
                    }
                    if (sCounter == 4) {
                        sCounter = 0;
                    }
                    if (mCounter == 8) {
                        mCounter = 0;
                    }
                    if (lCounter == 3) {
                        lCounter = 0;
                    }
                    if (eCounter == 1) {
                        eCounter = 0;
                    }

                    break;
                case 2:
                    Set set = hm.entrySet();
                    Iterator i = set.iterator();
                    while (i.hasNext()) {
                        Map.Entry me = (Map.Entry) i.next();
                        Table testTable = (Table) me.getKey();
                        System.out.print("Table Number: " + testTable.getId() + " : ");
                        Booking test = (Booking) me.getValue();
                        System.out.println(test.getName() + "\n" + "Time: " + test.getTime() + " Date: " + test.getDate());
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

    public boolean checkExists(int tableType, int hTime, int date, int month, int counter) {
        if (tableType == 1) {
            if (hm.containsKey(r1.smallTables.get(counter)) == true) {
                Booking test = (Booking) hm.get(r1.smallTables.get(counter));
                if (hTime == Integer.parseInt(test.getTime()) && Integer.parseInt(test.getTime()) < ++hTime) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (tableType == 2) {
            if (hm.containsKey(r1.mediumTables.get(counter)) == true) {
                Booking test = (Booking) hm.get(r1.mediumTables.get(counter));
                if (hTime == Integer.parseInt(test.getTime()) && Integer.parseInt(test.getTime()) < ++hTime) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (tableType == 3) {
            if (hm.containsKey(r1.largeTables.get(counter)) == true) {
                Booking test = (Booking) hm.get(r1.largeTables.get(counter));
                if (hTime == Integer.parseInt(test.getTime()) && Integer.parseInt(test.getTime()) < ++hTime) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (tableType == 4) {
            if (hm.containsKey(r1.extraTables.get(counter)) == true) {
                Booking test = (Booking) hm.get(r1.extraTables.get(counter));
                if (hTime == Integer.parseInt(test.getTime()) && Integer.parseInt(test.getTime()) < ++hTime) {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;

    }
}
