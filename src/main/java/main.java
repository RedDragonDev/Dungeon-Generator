package main.java;

import main.java.display.DisplayPanel;
import main.java.generators.GridGenerators;
import main.java.generators.EdgeGenerators;
import main.java.generators.TreeMazeGenerator;
import main.java.generators.util.DirectionBias;
import main.java.rooms.*;
import main.java.rooms.base.Room;
import main.java.Enums.*;

import javax.swing.*;

public class main {



    public static void main(String[] args) {
        treeTest();
    }

    public static void treeTest(){
        Grid grid = new Grid(15,15);
        grid.placeStart(7,14, Direction.SOUTH);
        TreeMazeGenerator.hallwayFromStart(grid, Direction.NORTH,3,5,new DirectionBias(1,1,1,1));
        baseDisplay(grid);
    }

    public static void placeConnectTest(){
        Grid grid = baseTest();
        EdgeGenerators.disableEdges(grid,ChunkType.ROOM);
        EdgeGenerators.connectAllAdjacentRooms(grid);
        EdgeGenerators.giveEachRoomDoors(grid,1);
        EdgeGenerators.placeStartTempHall(grid);
        baseDisplay(grid);
    }

    public static Grid baseTest(){
        Grid grid = new Grid(15,15);
        grid.placeStart(7,14, Enums.Direction.SOUTH);

        Room room1 = new WidthOneLengthOne();
        Room room2 = new WidthTwoLengthTwo();
        Room room3 = new WidthThreeLengthThree();
        Room room4 = new WidthOneLengthTwo();
        Room room5 = new WidthOneLengthThree();
        Room room6 = new LRoom();

        GridGenerators.randomlyPlaceRoom(grid,room1);
        GridGenerators.randomlyPlaceRoom(grid,room2);
        GridGenerators.randomlyPlaceRoom(grid,room3);
        GridGenerators.randomlyPlaceRoom(grid,room4);
        GridGenerators.randomlyPlaceRoom(grid,room5);
        GridGenerators.randomlyPlaceRoom(grid,room6);

        //grid.printGrid();
        return grid;
    }

    public static void baseDisplay(Grid grid){
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

    public static void loopTest(){
        for (int i = 0; i < 1000; i++) {
            Grid grid = new Grid(11,11);
            grid.placeStart(5,10, Enums.Direction.SOUTH);

            Room room1 = new WidthOneLengthOne();
            Room room2 = new WidthTwoLengthTwo();
            Room room3 = new WidthOneLengthThree();


            GridGenerators.randomlyPlaceRoom(grid,room1);
            GridGenerators.randomlyPlaceRoom(grid,room2);
            GridGenerators.randomlyPlaceRoom(grid,room3);

            grid.printGrid();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void loopDisplayTest(int num,int delay){
        for (int i = 0; i < num; i++) {


            //DUNGEON GENERATION======================================================================
            Grid grid = baseTest();
            EdgeGenerators.disableEdges(grid, Enums.ChunkType.ROOM);


            //DISPLAY==================================================================================
            int scale = 25;
            int lineScale = 4;
            JFrame window = new JFrame("Please Work");
            DisplayPanel panel = new DisplayPanel(grid, scale, lineScale);

            window.getContentPane().add(panel);


            window.setSize(scale * (grid.getWidth()), scale * (grid.getLength()));

            window.setUndecorated(true);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            window.dispose();
        }

    }

    public static Grid stressTest(){
        Grid grid = new Grid(15,15);
        grid.placeStart(7,14, Enums.Direction.SOUTH);


        Room room1 = new LRoom();
        Room room2 = new LRoom();
        Room room3 = new LRoom();
        Room room4 = new LRoom();
        Room room5 = new LRoom();
        Room room6 = new LRoom();
        Room room7 = new WidthOneLengthOne();
        Room room8 = new WidthOneLengthOne();
        Room room9 = new WidthOneLengthOne();
        Room room10 = new WidthOneLengthOne();
        Room room11 = new WidthOneLengthOne();
        Room room12 = new WidthOneLengthOne();

        GridGenerators.randomlyPlaceRoom(grid,room1);
        GridGenerators.randomlyPlaceRoom(grid,room2);
        GridGenerators.randomlyPlaceRoom(grid,room3);
        GridGenerators.randomlyPlaceRoom(grid,room4);
        GridGenerators.randomlyPlaceRoom(grid,room5);
        GridGenerators.randomlyPlaceRoom(grid,room6);
        GridGenerators.randomlyPlaceRoom(grid,room7);
        GridGenerators.randomlyPlaceRoom(grid,room8);
        GridGenerators.randomlyPlaceRoom(grid,room9);
        GridGenerators.randomlyPlaceRoom(grid,room10);
        GridGenerators.randomlyPlaceRoom(grid,room11);
        GridGenerators.randomlyPlaceRoom(grid,room12);

        GridGenerators.randomlyPlaceRoom(grid,room2);

        return grid;
    }
}
