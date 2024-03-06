package main.java.rooms.base;

import main.java.rooms.base.Chunk;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    protected final String name;
    protected final int width;
    protected final int length;
    protected Chunk roomOrigin;
    protected ArrayList<ArrayList<Chunk>> chunkList;

    //The location of the room's origin on the map
    protected int gridXPos;
    protected int gridYPos;

    //ID of the room in terms of the grid
    protected int roomID = -1;

    //Testing Purposes, will need to be removed
    public String nickname;

    public Room(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
        generateChunkList();


    }

    //TESTING
    public Room(String name, int width, int length,String nickname) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.nickname = nickname;
        generateChunkList();
    }

    //Must be done or else!
    public void setRoomOrigin(Chunk chunk){
        roomOrigin = chunk;
    }

    public void generateRoom(){

    }


    public void generateChunkList(){
        //naming is cy_x
        chunkList = new ArrayList<>();
        ArrayList<Chunk> tempList = new ArrayList<>();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                tempList.add(new Chunk());
            }
            chunkList.add((ArrayList<Chunk>) tempList.clone());
            tempList.clear();
        }
    }



    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ArrayList<Chunk>> getChunkList() {
        return chunkList;
    }

    public void setGridXPos(int gridXPos) {
        this.gridXPos = gridXPos;
    }

    public void setGridYPos(int gridYPos) {
        this.gridYPos = gridYPos;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public Chunk getRoomOrigin() {
        return roomOrigin;
    }
}
