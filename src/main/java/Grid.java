package main.java;

import main.java.Util.Cord;
import main.java.rooms.StartRoom;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;
import main.java.Enums.*;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Random;

public class Grid {
    private ArrayList<ArrayList<Chunk>> gridMap;
    private ArrayList<Room> rooms;

    private int width;
    private int length;

    public Random random;

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
        rooms = new ArrayList<>();

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
        rooms.add(start);
        start.setRoomID(0);
        placeStartRoomChunks(x,y,start);
    }

    public void placeStartRoomChunks(int x, int y,Room room){
        gridMap.get(y).set(x,room.getChunkList().get(0).get(0));
    }

    public void randomlyPlaceRoom(Room room){
        room.setRoomID(rooms.size());
        rooms.add(room);

        int xMin = 0;
        int yMin = 0;


        //There is a bug here
        int xMax = (gridMap.get(0).size()-1)-(room.getWidth()-2);
        int yMax = (gridMap.size()-1)-(room.getLength()-2);

        ArrayList<Cord> validCords = checkAllSlots(xMin,yMin,xMax,yMax, room, room.getChunkList());

        Cord cord = validCords.get(random.nextInt(validCords.size()));

        System.out.println("x="+cord.x+" y="+cord.y);

        //Place the Room
        Chunk chunk;
        for (int ry = 0; ry < room.getLength(); ry++) {
            for (int rx = 0; rx < room.getWidth(); rx++) {
                chunk = room.getChunkList().get(ry).get(rx);
                gridMap.get(ry+cord.y).set(rx+cord.x, chunk);
            }
        }


        /*
        for(Cord c : validCords){
            System.out.println("x="+c.x+" y="+c.y);
        }

         */

    }

    public ArrayList<Cord> checkAllSlots(int xMin, int yMin, int xMax, int yMax, Room room, ArrayList<ArrayList<Chunk>> chunkList){
        ArrayList<Cord> cords = new ArrayList<>();

        int xCord = 0;
        int yCord = 0;


        boolean noFit = false;
        Chunk selectedChunk;
        Chunk gridChunk;

        //For Each Location on the Grid
        for (int y = yMin; y < yMax; y++) {
            for (int x = xMin; x < xMax; x++) {
                //For Each Chunk in the Room
                for (int yc = 0; yc < chunkList.size(); yc++) {
                    for (int xc = 0; xc < chunkList.get(yc).size(); xc++) {
                        //Check Currently selected chunk with where it will go
                        selectedChunk = chunkList.get(yc).get(xc);
                        gridChunk = gridMap.get(y+yc).get(x+xc);

                        //If Both neither are empty, then the room doesn't fit at these cords.
                        if(selectedChunk.getChunkType().equals(ChunkType.EMPTY) || gridChunk.getChunkType().equals(ChunkType.EMPTY)){
                            //System.out.println("one is empty");
                        }else{
                            //System.out.println("Doesn't fit at x="+x+" y="+y);
                            noFit = true;
                            break;
                        }

                    }
                    if(noFit){
                        //System.out.println("No fit for "+room.getName()+"\n at x="+x+" y="+y);
                        noFit = false;
                        break;
                    }
                }

                //If it fits add it to the possible
                if(!noFit){
                    cords.add(new Cord(x,y));
                }
            }
        }

        return cords;
    }
}
