package main.java.rooms;

import main.java.Enums.*;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class StartRoom extends Room {
    Direction entranceDoor = Direction.SOUTH;

    public StartRoom(Direction entranceDoor) {
        super("Start Room",1, 1);
        this.entranceDoor = entranceDoor;
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0;
        switch (this.entranceDoor){
            case NORTH:
                c0_0 = new Chunk(ChunkType.START,EdgeState.ENTRANCE,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.POTENTIAL);
                break;
            case SOUTH:
                c0_0 = new Chunk(ChunkType.START,EdgeState.POTENTIAL,EdgeState.ENTRANCE,EdgeState.POTENTIAL,EdgeState.POTENTIAL);
                break;
            case EAST:
                c0_0 = new Chunk(ChunkType.START,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.ENTRANCE,EdgeState.POTENTIAL);
                break;
            case WEST:
                c0_0 = new Chunk(ChunkType.START,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.ENTRANCE);
                break;
            default:
                c0_0 = new Chunk(ChunkType.START,EdgeState.POTENTIAL,EdgeState.ENTRANCE,EdgeState.POTENTIAL,EdgeState.POTENTIAL);
                break;

        }

        chunkList.get(0).add(0,c0_0);
        super.setRoomOrigin(c0_0);
    }

}