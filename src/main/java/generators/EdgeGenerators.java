package main.java.generators;

import main.java.Grid;
import main.java.rooms.base.Chunk;
import main.java.Enums.*;
import main.java.rooms.base.Room;
import main.java.util.Cord;

import java.util.ArrayList;

public class EdgeGenerators {


    //Disables edges that could never be valid because they hit an OOB area
    //todo check for when possibles are up against closed
    public static void disableEdges(Grid grid, ChunkType chunkType){

        ArrayList<ArrayList<Chunk>> gridMap = grid.getGridMap();

        //Check Top
        for (int i = 0; i < gridMap.get(0).size(); i++) {
            if(gridMap.get(0).get(i).getChunkType().equals(chunkType)){
                gridMap.get(0).get(i).setNorth(EdgeState.WALL);
            }
        }


        //Check Bottom
        for (int i = 0; i < gridMap.get(0).size(); i++) {
            if(gridMap.get(gridMap.size()-1).get(i).getChunkType().equals(chunkType)){
                gridMap.get(gridMap.size()-1).get(i).setSouth(EdgeState.WALL);
            }
        }

        //Check Right
        for (int i = 0; i < gridMap.size(); i++) {
            if(gridMap.get(i).get(gridMap.get(i).size()-1).getChunkType().equals(chunkType)){
                gridMap.get(i).get(gridMap.get(i).size()-1).setEast(EdgeState.WALL);
            }
        }

        //Check Left
        for (int i = 0; i < gridMap.size(); i++) {
            if(gridMap.get(i).get(0).getChunkType().equals(chunkType)){
                gridMap.get(i).get(0).setWest(EdgeState.WALL);
            }
        }



    }

    //Create doors at all places where a room is next to a room
    public static void connectAllAdjacentRooms(Grid grid){
        ArrayList<ArrayList<Chunk>> gridMap = grid.getGridMap();
        Chunk currentChunk;
        Chunk checkChunk;
        for (int y = 0; y < gridMap.size(); y++) {
            for (int x = 0; x < gridMap.get(y).size(); x++) {
                currentChunk = gridMap.get(y).get(x);
                //Check if selected chunk is a room
                if(currentChunk.getChunkType().equals(ChunkType.ROOM)) {
                    //Check North: If potential and not on top
                    if (y != 0 && currentChunk.getNorth().equals(EdgeState.POTENTIAL)) {
                        checkChunk = gridMap.get(y-1).get(x);
                        if(checkChunk.getChunkType().equals(ChunkType.ROOM) && checkChunk.getSouth().equals(EdgeState.POTENTIAL)){
                            currentChunk.setNorth(EdgeState.DOOR);
                            checkChunk.setSouth(EdgeState.DOOR);
                        }
                    }
                    //Check South
                    //if (y != gridMap.size() - 1) {}

                    //Check West
                    if (x != 0 && currentChunk.getWest().equals(EdgeState.POTENTIAL)) {
                        checkChunk = gridMap.get(y).get(x-1);
                        if(checkChunk.getChunkType().equals(ChunkType.ROOM) && checkChunk.getEast().equals(EdgeState.POTENTIAL)){
                            currentChunk.setWest(EdgeState.DOOR);
                            checkChunk.setEast(EdgeState.DOOR);
                        }

                    }

                    //Check East
                    //if (x != gridMap.get(0).size() - 1) {}
                }
            }
        }

    }


    public static void giveEachRoomDoors(Grid grid, int doorNum){
        ArrayList<Room> roomList = grid.getRoomsList();
        ArrayList<StoredEdge> storedEdges;
        Chunk currentChunk;


        for(Room room : roomList){
            storedEdges = new ArrayList<>();
            ArrayList<ArrayList<Chunk>> chunkList = room.getChunkList();

            for (int y = 0; y < chunkList.size(); y++) {
                for (int x = 0; x < chunkList.get(y).size(); x++) {

                    //This code is NOT Pretty, this will need to be revised

                    currentChunk = chunkList.get(y).get(x);
                    if(currentChunk.getNorth().equals(EdgeState.POTENTIAL)){
                        storedEdges.add(new StoredEdge(currentChunk,Direction.NORTH));
                    }
                    if(currentChunk.getSouth().equals(EdgeState.POTENTIAL)){
                        storedEdges.add(new StoredEdge(currentChunk,Direction.SOUTH));
                    }
                    if(currentChunk.getEast().equals(EdgeState.POTENTIAL)){
                        storedEdges.add(new StoredEdge(currentChunk,Direction.EAST));
                    }
                    if(currentChunk.getWest().equals(EdgeState.POTENTIAL)){
                        storedEdges.add(new StoredEdge(currentChunk,Direction.WEST));
                    }
                }
            }
            StoredEdge storedEdge = storedEdges.get(grid.random.nextInt(storedEdges.size()));

            storedEdge.chunk.setDirection(storedEdge.direction,EdgeState.DOOR);

        }

    }


}
