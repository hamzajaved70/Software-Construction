package lab3;

import java.util.*;

public class Restaurant {

    private final int timeOfOpening;
    private final int timeOfClosing;
    public final List<Table> smallTables;
    public final List<Table> mediumTables;
    public final List<Table> largeTables;
    public final List<Table> extraTables;

    public Restaurant(int open, int close) {
        this.extraTables = new ArrayList<>();
        this.largeTables = new ArrayList<>();
        this.mediumTables = new ArrayList<>();
        this.smallTables = new ArrayList<>();
        this.timeOfOpening = open;
        this.timeOfClosing = close;

        for (int i = 0; i < 4; i++) {
            smallTables.add(i, new Table(i, 2));
        }

        for (int i = 0, j = 4; i < 8; i++, j++) {
            mediumTables.add(i, new Table(j, 4));
        }

        for (int i = 0, j = 12; i < 3; i++, j++) {
            largeTables.add(i, new Table(j, 6));
        }

        for (int i = 0, j = 15; i < 1; i++, j++) {
            extraTables.add(i, new Table(j, 12));
        }
    }
}
