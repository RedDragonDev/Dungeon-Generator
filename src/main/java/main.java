package main.java;

import main.java.rooms.WidthOneLengthThree;
import main.java.rooms.WidthTwoLengthTwo;
import main.java.rooms.base.Room;

import java.util.Random;

public class main {



    public static void main(String[] args) {


        Grid grid = new Grid(11,11);
        grid.placeStart(5,10, Enums.Direction.SOUTH);

        Room room1 = new WidthTwoLengthTwo();
        Room room2 = new WidthOneLengthThree();


        grid.randomlyPlaceRoom(room1);
        grid.randomlyPlaceRoom(room2);



        grid.printGrid();
    }
}
