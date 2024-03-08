package main.java.generators;

import main.java.Enums;
import main.java.Grid;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;
import main.java.util.Cord;

import java.util.ArrayList;

public class GridGenerators {

    //Will place a given room at a random location that it will fit
    //Todo figure out what should happen if a room CANT fit
    public static void randomlyPlaceRoom(Grid grid, Room room){
        ArrayList<ArrayList<Chunk>> gridMap = grid.getGridMap();
        ArrayList<Room> roomsList = grid.getRoomsList();

        room.setRoomID(roomsList.size());
        roomsList.add(room);

        int xMin = 0;
        int yMin = 0;

        int xMax = (gridMap.get(0).size()-1)-(room.getWidth()-2);
        int yMax = (gridMap.size()-1)-(room.getLength()-2);

        ArrayList<Cord> validCords = checkAllSlots(grid,xMin,yMin,xMax,yMax, room, room.getChunkList());

        Cord cord = validCords.get(grid.random.nextInt(validCords.size()));


        //System.out.println("x="+cord.x+" y="+cord.y);

        //Place the Room chunk by chunk
        Chunk chunk;
        for (int ry = 0; ry < room.getLength(); ry++) {
            for (int rx = 0; rx < room.getWidth(); rx++) {
                chunk = room.getChunkList().get(ry).get(rx);
                gridMap.get(ry+cord.y).set(rx+cord.x, chunk);
            }
        }
    }

    public static ArrayList<Cord> checkAllSlots(Grid grid, int xMin, int yMin, int xMax, int yMax, Room room, ArrayList<ArrayList<Chunk>> chunkList){
        ArrayList<ArrayList<Chunk>> gridMap = grid.getGridMap();

        ArrayList<Cord> cords = new ArrayList<>();

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
                        if(selectedChunk.getChunkType().equals(Enums.ChunkType.EMPTY) || gridChunk.getChunkType().equals(Enums.ChunkType.EMPTY)){
                            //System.out.println("one is empty");
                        }else{
                            //
                            // System.out.println("For room \"" + room.getName() + "\" Doesn't fit at x=" + x + " y=" + y);
                            noFit = true;
                            break;
                        }

                    }
                    if(noFit){
                        break;
                    }
                }

                //If it fits add it to the possible
                if(!noFit){
                    cords.add(new Cord(x,y));
                }else{
                    noFit = false;
                }
            }
        }

        return cords;
    }


    //======================================================================================================================================================
    //
}
