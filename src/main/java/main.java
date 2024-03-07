package main.java;

import main.java.rooms.WidthOneLengthOne;
import main.java.rooms.WidthOneLengthThree;
import main.java.rooms.WidthThreeLengthThree;
import main.java.rooms.WidthTwoLengthTwo;
import main.java.rooms.base.Room;

import java.util.Random;

public class main {



    public static void main(String[] args) {
        baseTest();




    }

    public static void baseTest(){
        Grid grid = new Grid(15,15);
        grid.placeStart(8,14, Enums.Direction.SOUTH);

        Room room1 = new WidthThreeLengthThree();
        Room room2 = new WidthThreeLengthThree();
        Room room3 = new WidthThreeLengthThree();
        Room room4 = new WidthThreeLengthThree();
        Room room5 = new WidthThreeLengthThree();

        grid.randomlyPlaceRoom(room1);
        grid.randomlyPlaceRoom(room2);
        grid.randomlyPlaceRoom(room3);
        grid.randomlyPlaceRoom(room4);
        grid.randomlyPlaceRoom(room5);

        grid.printGrid();
    }

    public static void loopTest(){
        for (int i = 0; i < 1000; i++) {
            Grid grid = new Grid(11,11);
            grid.placeStart(5,10, Enums.Direction.SOUTH);

            Room room1 = new WidthOneLengthOne();
            Room room2 = new WidthTwoLengthTwo();
            Room room3 = new WidthOneLengthThree();


            grid.randomlyPlaceRoom(room1);
            grid.randomlyPlaceRoom(room2);
            grid.randomlyPlaceRoom(room3);

            grid.printGrid();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void twoByTwoTest(){
        Grid grid = new Grid(11,11);
        grid.placeStart(5,10, Enums.Direction.SOUTH);

        Room room2 = new WidthTwoLengthTwo();


        grid.randomlyPlaceRoom(room2);

        grid.printGrid();
    }
}
