package main.java;

import main.java.rooms.WidthOneLengthOne;
import main.java.rooms.WidthOneLengthThree;
import main.java.rooms.WidthTwoLengthTwo;
import main.java.rooms.base.Room;

import java.util.Random;

public class main {



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            Grid grid = new Grid(11,11);
            grid.placeStart(5,10, Enums.Direction.SOUTH);

            Room room1 = new WidthTwoLengthTwo();
            Room room2 = new WidthTwoLengthTwo();
            Room room3 = new WidthTwoLengthTwo();
            Room room4 = new WidthTwoLengthTwo();
            Room room5 = new WidthTwoLengthTwo();



            grid.randomlyPlaceRoom(room1);
            grid.randomlyPlaceRoom(room2);
            grid.randomlyPlaceRoom(room3);
            grid.randomlyPlaceRoom(room4);
            grid.randomlyPlaceRoom(room5);



            grid.printGrid();
            Thread.sleep(1000);
        }

    }
}
