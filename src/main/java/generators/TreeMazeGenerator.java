package main.java.generators;

import main.java.Enums.*;
import main.java.Grid;
import main.java.generators.util.DirectionBias;
import main.java.rooms.StartRoom;
import main.java.rooms.base.Chunk;

import java.util.Random;

public class TreeMazeGenerator {

    public static void hallwayFromStart(Grid grid, Direction branchEntrance, int minRooms, int maxRooms, DirectionBias directionBias){
        StartRoom startRoom = (StartRoom) grid.getRoomsList().get(0); //todo search for startroom instead
        Chunk startChunk = startRoom.getChunkList().get(0).get(0);    //todo add support for start rooms that are bigger than 1x1
        startChunk.setEdgeState(branchEntrance,EdgeState.DOOR);

        int numRooms = grid.random.nextInt(maxRooms - minRooms) + minRooms;




    }
}
