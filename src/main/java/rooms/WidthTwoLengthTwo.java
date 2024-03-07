package main.java.rooms;

import main.java.Enums.*;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class WidthTwoLengthTwo extends Room {

    public WidthTwoLengthTwo() {
        super("2x2",2, 2);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL); //Top Left
        super.setRoomOrigin(c0_0);
        Chunk c0_1 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER); //Top Right
        Chunk c1_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL); //Bottom Left
        Chunk c1_1 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.INNER); //Bottom Right

        this.chunkList.get(0).set(0,c0_0);
        this.chunkList.get(0).set(1,c0_1);
        this.chunkList.get(1).set(0,c1_0);
        this.chunkList.get(1).set(1,c1_1);
    }

}
