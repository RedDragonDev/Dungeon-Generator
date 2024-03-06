package main.java.rooms;

import main.java.Enums.ChunkType;
import main.java.Enums.EdgeState;
import main.java.rooms.base.Chunk;
import main.java.rooms.base.Room;

public class WidthOneLengthOne extends Room {

    public WidthOneLengthOne() {
        super("One By One",2, 2);
        generateRoom();
    }


    @Override
    public void generateRoom() {
        Chunk c0_0 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER); //Top Left
        super.setRoomOrigin(c0_0);
        Chunk c0_1 = new Chunk(ChunkType.ROOM,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.INNER,EdgeState.POTENTIAL); //Top Right
        Chunk c1_0 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.INNER,EdgeState.POTENTIAL); //Bottom Left
        Chunk c1_1 = new Chunk(ChunkType.ROOM,EdgeState.INNER,EdgeState.POTENTIAL,EdgeState.POTENTIAL,EdgeState.INNER); //Bottom Right

        this.chunkList.get(0).set(0,c0_0);
        this.chunkList.get(0).set(1,c0_1);
        this.chunkList.get(1).set(0,c1_0);
        this.chunkList.get(1).set(1,c1_1);
    }

}
