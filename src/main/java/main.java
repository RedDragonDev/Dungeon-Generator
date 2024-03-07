package main.java;

import main.java.Display.DisplayPanel;
import main.java.rooms.*;
import main.java.rooms.base.Room;

import javax.swing.*;
import java.util.Random;

public class main {



    public static void main(String[] args) {

        Grid grid = baseTest();

        int scale = 25;
        int lineScale = 4;
        JFrame window = new JFrame("Please Work");
        DisplayPanel panel = new DisplayPanel(grid,scale,lineScale);

        window.getContentPane().add(panel);


        window.setSize(scale*(grid.getWidth()),scale*(grid.getLength()));

        window.setUndecorated(true);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public static Grid baseTest(){
        Grid grid = new Grid(15,15);
        grid.placeStart(7,14, Enums.Direction.SOUTH);

        Room room1 = new WidthOneLengthOne();
        Room room2 = new WidthTwoLengthTwo();
        Room room3 = new WidthThreeLengthThree();
        Room room4 = new WidthOneLengthTwo();
        Room room5 = new WidthOneLengthThree();

        grid.randomlyPlaceRoom(room1);
        grid.randomlyPlaceRoom(room2);
        grid.randomlyPlaceRoom(room3);
        grid.randomlyPlaceRoom(room4);
        grid.randomlyPlaceRoom(room5);

        grid.printGrid();
        return grid;
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
