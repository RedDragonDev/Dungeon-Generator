package main.java;

import main.java.util.Cord;
import main.java.rooms.StartRoom;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;
import main.java.Enums.*;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
    private ArrayList<ArrayList<Chunk>> gridMap;
    private ArrayList<Room> roomsList;

    private int width;
    private int length;

    public Random random;

    private boolean debug = false;

    public Grid(int x, int y){
        this.width = x;
        this.length = y;


        ArrayList<Chunk> tempList = new ArrayList<>();
        gridMap = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tempList.add(new Chunk());
            }
            gridMap.add((ArrayList<Chunk>) tempList.clone());
            tempList.clear();
        }

        //Create empty ArrayList for storing the rooms
        roomsList = new ArrayList<>();

        this.random = new Random();

    }
    public void printGrid(){
        int y = gridMap.size();
        int x = gridMap.size();
        String type = "WRONG";

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                switch(gridMap.get(i).get(j).getChunkType().id){
                    //ToFix: Fix the switches to actually be the enums
                    case "Empty":
                        type=" ";
                        break;
                    case "Room":
                        type="R";
                        break;
                    case "Hall":
                        type="H";
                        break;
                    case "Temp":
                        type="T";
                        break;
                    case "Start":
                        type="S";
                        break;
                }


                System.out.print(type);
            }
            System.out.println();
        }

    }


    public void placeStart(int x, int y, Direction direction){
        Room start = new StartRoom(direction);
        roomsList.add(start);
        start.setRoomID(0);
        placeStartRoomChunks(x,y,start);
    }

    public void placeStartRoomChunks(int x, int y,Room room){
        gridMap.get(y).set(x,room.getChunkList().get(0).get(0));
    }





    //==================================================================================================


    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Room> getRoomsList() {
        return roomsList;
    }

    public ArrayList<ArrayList<Chunk>> getGridMap() {
        return gridMap;
    }
}
